package org.mo.jims.coop.controller;

import javax.annotation.Resource;

import org.mo.jims.coop.dto.LoginDTO;
import org.mo.open.common.entity.User;
import org.mo.open.common.service.UserService;
import org.mo.open.common.util.JsonResponse;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/coop/sys/")
public class UserController {

	private UserService userService;

	@RequestMapping(value = "caozuoyuanguanli.html/{page}/{size}", method = RequestMethod.GET)
	public ModelAndView caoZuoYuanGuanLi(@PathVariable int page,
			@PathVariable int size, ModelMap model) {
		LoginDTO userDTO = new LoginDTO();
		Page<User> allUserInfo = userService.getALLUserInfo(
				userDTO.toObject(), page, size);
		model.put("baseActive", "sysManage");
		model.put("active", "CaoZuoYuanGuanLi");
		model.put("allUserInfo", allUserInfo);
		return new ModelAndView("coop/sysManage/CaoZuoYuanGuanLi", model);
	}

	@RequestMapping(value = "CaoZuoYuanGuanLi.html", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public JsonResponse showUserInfo(
			@RequestParam(required = true, defaultValue = "10") int size,
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestBody(required = false) LoginDTO userDTO) {
		Page<User> allUserInfo = userService.getALLUserInfo(
				userDTO.toObject(), page, size);
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
