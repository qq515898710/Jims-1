package org.mo.open.common.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.mo.open.common.entity.User;
import org.mo.open.common.service.RoleService;
import org.mo.open.common.service.UserService;
import org.mo.open.common.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;
	
	private RoleService roleService;
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "coop/profile.html", method = RequestMethod.GET)
	public ModelAndView profile(ModelMap model){
		logger.info("进入个人信息界面");
		return new ModelAndView("common/profile", model);
	}
	
	@RequestMapping(value = "admin/genggaimima.html", method = RequestMethod.GET)
	public ModelAndView alterPassword(ModelMap model){
		model.put("baseActive", "sysManage");
		model.put("active", "GengGaiMiMa");
		logger.info("进入修改密码界面");
		return new ModelAndView("common/sysManage/GengGaiMiMa", model);
	}
	
	@RequestMapping(value = "admin/caozuoyuanguanli.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "sysManage");
		model.put("active", "CaoZuoYuanGuanLi");
		logger.info("进入操作员管理界面");
		return new ModelAndView("common/sysManage/CaoZuoYuanGuanLi", model);
	}
	
	@RequestMapping(value = "admin/pageofuserlist", method = RequestMethod.GET)
	@ResponseBody
	public Page<User> list(
			@RequestParam String account,
			@RequestParam String username,
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size) {
		String newAccount = "";
		String newUsername = "";
		try {
			// 编码有问题,get传过来的参数
			newAccount = new String(account.getBytes("iso8859-1"), "UTF-8");
			newUsername = new String(username.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = new User();
		user.setAccount(newAccount);
		user.setUsername(newUsername);
		return userService.getALLUserInfo(user, page, size);
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
