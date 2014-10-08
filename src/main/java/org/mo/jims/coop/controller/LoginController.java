package org.mo.jims.coop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.mo.jims.coop.dto.LoginDTO;
import org.mo.open.common.service.UserService;
import org.mo.open.common.util.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController{
	private UserService userService;

	@RequestMapping(value="checklogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestBody LoginDTO loginDTO, HttpSession session, ModelMap model) {
		Map<String, Object> modelMap = new HashMap<String, Object>(); 
		String codeImage = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String code = loginDTO.getCode();
		boolean checkLogin = userService.checkLogin(loginDTO.toObject());
		boolean equalsIgnoreCase = code.equalsIgnoreCase(codeImage);
		if (checkLogin && equalsIgnoreCase) {
			modelMap.put("info", 1);
			return modelMap;
		} else {
			if (!checkLogin) {
				modelMap.put("user_error", 2);
			}
			if (!equalsIgnoreCase) {
				modelMap.put("code_error", 3);
			}
		}
		return modelMap;
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
