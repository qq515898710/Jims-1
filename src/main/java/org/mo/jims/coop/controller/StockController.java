package org.mo.jims.coop.controller;

import javax.annotation.Resource;

import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.ProviderInfoService;
import org.mo.open.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class StockController {
	
	private static Logger logger = LoggerFactory.getLogger(StockController.class);
	
	private ProviderInfoService providerInfoService;
	
	private GoodInfoService goodInfoService;
	
	private UserService userService;

	@RequestMapping(value = "coop/jinhuodan.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "stockManage");
		model.put("active", "JinHuoDan");
		logger.info("进入进货单界面");
		return new ModelAndView("coop/stockManage/JinHuoDan");
	}
	
	@RequestMapping("view")
	public void view() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		System.out.println(username);
	}
	
	public ProviderInfoService getProviderInfoService() {
		return providerInfoService;
	}

	@Resource(name = "providerInfoService")
	public void setProviderInfoService(ProviderInfoService providerInfoService) {
		this.providerInfoService = providerInfoService;
	}

	public GoodInfoService getGoodInfoService() {
		return goodInfoService;
	}

	@Resource(name = "goodInfoService")
	public void setGoodInfoService(GoodInfoService goodInfoService) {
		this.goodInfoService = goodInfoService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
