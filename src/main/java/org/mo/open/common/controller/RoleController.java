package org.mo.open.common.controller;

import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Role;
import org.mo.open.common.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {
	
	private RoleService roleService;
	
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@RequestMapping(value = "admin/jueseguanli.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "sysManage");
		model.put("active", "JueSeGuanLi");
		logger.info("进入角色管理界面");
		return new ModelAndView("common/sysManage/JueSeGuanLi", model);
	}
	
	@RequestMapping(value = "admin/rolelist", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getAll(){
		List<Role> roleAll = roleService.getRoleAll();
		return roleAll;
	}
	
	public RoleService getRoleService() {
		return roleService;
	}

	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
