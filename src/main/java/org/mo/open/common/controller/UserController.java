package org.mo.open.common.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.mo.open.common.dto.UserDTO;
import org.mo.open.common.entity.Role;
import org.mo.open.common.entity.User;
import org.mo.open.common.entity.UserRole;
import org.mo.open.common.service.RoleService;
import org.mo.open.common.service.UserService;
import org.mo.open.common.util.JsonResponse;
import org.mo.open.common.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
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

	private static Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@RequestMapping(value = "coop/profile.html", method = RequestMethod.GET)
	public ModelAndView profile(ModelMap model) {
		logger.info("进入个人信息界面");
		return new ModelAndView("common/profile", model);
	}

	@RequestMapping(value = "admin/genggaimima.html", method = RequestMethod.GET)
	public ModelAndView alterPassword(ModelMap model) {
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
	
	@RequestMapping(value = "admin/deleteuserbyid", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse delete(@RequestParam(required = true) String deleteId) {
		JsonResponse jsonResponse = null;
		String[] ids = deleteId.split(",");
		List<String> id = new ArrayList<String>();
		for (String result : ids) {
			id.add(result);
		}
		boolean batchRemove = userService.batchRemove(id);
		jsonResponse = deleteTip(batchRemove);
		return jsonResponse;
	}

	@RequestMapping(value = "admin/searchuserbyid", method = RequestMethod.POST)
	@ResponseBody
	public User searchById(@RequestParam(required = true) String searchId) {
		User userByPK = null;
		String[] ids = searchId.split(",");
		if (ids.length < 1) {
			userByPK = userService.getUserByPK(searchId);
		} else {
			userByPK = userService.getUserByPK(ids[0]);
		}
		List<Role> byUser = roleService.getByUser(userByPK.getAccount());
		userByPK.setRole(byUser);
		return userByPK;
	}

	/**
	 * 修改用户名de角色
	 * 
	 * @param userDTO
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "admin/alteruserinfo", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse alter(@RequestBody UserDTO userDTO, HttpSession session) {
		JsonResponse jsonResponse = new JsonResponse();
		User entity = userDTO.toEditObject();
		String account = entity.getAccount();
		// 获取页面得到用户勾选了什么角色
		String[] name = userDTO.getRoleName().split(",");
		List<Role> role = new ArrayList<Role>();
		for (String result : name) {
			Role roleByName = roleService.getRoleByName(result);
			role.add(roleByName);
		}
		List<Role> byUser = roleService.getByUser(account);
		for (Role r : byUser) {
			UserRole userRole = new UserRole();
			userRole.setUser(entity);
			userRole.setRole(r);
			// 删除原来的用户多余的角色
			userService.removeUserRoleRelativity(userRole);
		}
		for (Role r : role) {
			UserRole userRole = new UserRole();
			userRole.setUser(entity);
			userRole.setRole(r);
			// 添加新的用户角色
			roleService.saveUserRoleRelativity(userRole);
		}
		jsonResponse.setSuccess(true);
		jsonResponse.setMessage("更改角色成功");
		return jsonResponse;
	}

	/**
	 * 修改密码
	 * 
	 * @param userDTO
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "admin/edituserinfo", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse edit(@RequestBody UserDTO userDTO) {
		JsonResponse jsonResponse = new JsonResponse();
		System.out.println(userDTO.toString());
		if ("".equals(userDTO.getPassword()) || userDTO.getPassword() == null
				|| userDTO.getPassword().length() < 5) {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("密码格式不正确,修改失败");

		} else if (!userDTO.getPassword().equals(userDTO.getRepassword())) {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("两次输入的密码不一样哦,修改失败");
		} else {
			User entity = userDTO.toEditObject();
			boolean alterUser = userService.alterUser(entity);
			if(alterUser){
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("修改密码成功");
			}else{
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("修改密码失败");
			}

		}
		return jsonResponse;
	}

	@RequestMapping(value = "admin/adduser", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse add(@RequestBody UserDTO userDTO) {
		JsonResponse jsonResponse = new JsonResponse();
		if ("".equals(userDTO.getUsername())
				&& "".equals(userDTO.getPassword())
				&& userDTO.getUsername().length() < 5
				&& userDTO.getPassword().length() < 5) {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("失败");
		} else {
			User entity = new User(userDTO.getUsername(), userDTO.getPassword());
			String[] name = userDTO.getRoleName().split(",");
			List<Role> role = new LinkedList<Role>();
			for (String result : name) {
				Role roleByName = roleService.getRoleByName(result);
				role.add(roleByName);
			}
			entity.setRole(role);
			boolean saveUser = userService.saveUser(entity);
			if (saveUser) {
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("成功");
			} else {
				jsonResponse.setSuccess(false);
				jsonResponse.setMessage("失败");
			}
		}
		return jsonResponse;
	}

	@RequestMapping(value = "admin/pageofuserlist", method = RequestMethod.GET)
	@ResponseBody
	public Page<User> list(@RequestParam String account,
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

	@Resource(name = "roleService")
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
	
	private JsonResponse deleteTip(boolean removeByPK) {
		JsonResponse jsonResponse = new JsonResponse();
		if (removeByPK) {
			jsonResponse.setSuccess(true);
			jsonResponse.setMessage("删除成功");
		} else {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("删除失败");
		}
		return jsonResponse;
	}
}
