package org.mo.open.common.controller;

import javax.annotation.Resource;

import org.mo.open.common.service.PermissionService;
import org.mo.open.common.service.RoleService;
import org.mo.open.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PermissionController {

	private UserService userService;
	
	private PermissionService permissionService;
	
	private RoleService roleService;
	
	private static Logger logger = LoggerFactory.getLogger(PermissionController.class);
	
	@RequestMapping(value = "admin/quanxianguanli.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "sysManage");
		model.put("active", "QuanXianGuanLi");
		logger.info("进入权限管理界面");
		return new ModelAndView("common/sysManage/QuanXianGuanLi");
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}
	
	@Resource(name="permissionService")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public RoleService getRoleService() {
		return roleService;
	}
	
	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
