package org.mo.jims.coop.controller;

import javax.annotation.Resource;

import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.SellService;
import org.mo.open.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author moziqi
 *
 */
@Controller
public class SellReturnController {

	public SellService sellService;

	public GoodInfoService goodInfoService;

	public CustomerInfoService customerInfoService;

	public UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(SellReturnController.class);

	@RequestMapping(value = "coop/xiaoshoutuihuo.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "sellManage");
		model.put("active", "XiaoShouTuiHuo");
		logger.info("进入销售退货界面");
		return new ModelAndView("coop/sellManage/XiaoShouTuiHuo");
	}
	
	@RequestMapping(value = "coop/xiaoshoutuihuochaxun.html", method = RequestMethod.GET)
	public ModelAndView showSearch(ModelMap model) {
		model.put("baseActive", "searchStatistic");
		model.put("active", "XiaoShouTuiHuoChaXun");
		logger.info("进入销售退货查询界面");
		return new ModelAndView("coop/searchStatistic/XiaoShouTuiHuoChaXun");
	}

	public SellService getSellService() {
		return sellService;
	}

	@Resource(name = "sellService")
	public void setSellService(SellService sellService) {
		this.sellService = sellService;
	}

	public GoodInfoService getGoodInfoService() {
		return goodInfoService;
	}

	@Resource(name = "goodInfoService")
	public void setGoodInfoService(GoodInfoService goodInfoService) {
		this.goodInfoService = goodInfoService;
	}

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Resource(name = "customerInfoService")
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
