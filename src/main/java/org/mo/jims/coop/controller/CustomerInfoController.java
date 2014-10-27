package org.mo.jims.coop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.open.common.util.ApplicationContextProvider;
import org.mo.open.common.util.JSonUtil;
import org.mo.open.common.util.Page;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/coop/")
public class CustomerInfoController {
	private CustomerInfoService customerInfoService;

	@RequestMapping(value = "kehuguanli.html", method = RequestMethod.GET)
	public ModelAndView KeHuGuanLi(ModelMap model) {
//		Page<CustomerInfo> allCustomerInfo = customerInfoService.getAllCustomerInfo(page, size);
		model.put("baseActive", "baseManage");
		model.put("active", "KeHuGuanLi");
//		model.put("allCustomerInfo", allCustomerInfo);
		return new ModelAndView("coop/baseManage/KeHuGuanLi");
	}

	@RequestMapping(value = "pageOfCustomers", method = RequestMethod.GET)
	@ResponseBody
	public Page<CustomerInfo> list(
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size,
			HttpServletResponse response) {
		Page<CustomerInfo> allCustomerInfo = customerInfoService.getAllCustomerInfo(page, size);
		return allCustomerInfo;
//		try {
//			response.setCharacterEncoding("utf-8");
//			response.getWriter().write("{\"success\":true, \"data\":" + JSonUtil.toJSon(allCustomerInfo)+ "}");
////			response.getWriter().write(JSonUtil.toJSon(allCustomerInfo));
//			response.getWriter().flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Resource(name = "customerInfoService")
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}
}
