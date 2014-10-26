package org.mo.jims.coop.controller;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/coop/")
public class CustomerInfoController {
	private CustomerInfoService customerInfoService;

	@RequestMapping(value = "kehuguanli.html/{page}/{size}", method = RequestMethod.GET)
	public ModelAndView KeHuGuanLi(@PathVariable int page,
			@PathVariable int size,ModelMap model) {
		Page<CustomerInfo> allCustomerInfo = customerInfoService.getAllCustomerInfo(page, size);
		model.put("baseActive", "baseManage");
		model.put("active", "KeHuGuanLi");
		model.put("allCustomerInfo", allCustomerInfo);
		return new ModelAndView("coop/baseManage/KeHuGuanLi");
	}

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Resource(name = "customerInfoService")
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}
}
