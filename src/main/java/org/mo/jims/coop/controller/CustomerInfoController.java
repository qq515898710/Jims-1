package org.mo.jims.coop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.mo.jims.coop.dto.AddCustomerInfoDTO;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.open.common.util.Page;
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
public class CustomerInfoController {

	private CustomerInfoService customerInfoService;

	@RequestMapping(value = "kehuguanli.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "baseManage");
		model.put("active", "KeHuGuanLi");
		return new ModelAndView("coop/baseManage/KeHuGuanLi");
	}

	@RequestMapping(value = "addCoustomer", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, String> add(
			@RequestBody AddCustomerInfoDTO customerInfoDTO,
			HttpServletResponse response) {
		Map<String, String> modelMap = new HashMap<String, String>();
		if("".equals(customerInfoDTO.getName())){
			modelMap.put("name", "客户名称不能为空");
		}
		if("".equals(customerInfoDTO.getAbbreviation())){
			modelMap.put("abbreviation", "简称不能为空");
		}
		if ("".equals(customerInfoDTO.getAddress())) {
			modelMap.put("address", "地址不能为空");
		}
		if("".equals(customerInfoDTO.getPostalCode())){
			modelMap.put("postalCode", "邮政编码不能为空");
		}
		if("".equals(customerInfoDTO.getPhone())){
			modelMap.put("phone", "手机不能为空");
		}
		if("".equals(customerInfoDTO.getFax())){
			modelMap.put("fax", "传真不能为空");
		}
		if("".equals(customerInfoDTO.getContacts())){
			modelMap.put("contacts", "联系人不能为空");
		}
		if("".equals(customerInfoDTO.getTelephone())){
			modelMap.put("telephone", "联系人电话不能为空");
		}
		if("".equals(customerInfoDTO.getEmail())){
			modelMap.put("email", "邮箱不能为空");
		}
		if("".equals(customerInfoDTO.getDepositBank())){
			modelMap.put("depositBank", "开户行");
		}
		if("".equals(customerInfoDTO.getAccountBank())){
			modelMap.put("accountBank", "开户行帐号");
		}
		if (modelMap.size() < 0) {
			CustomerInfo entity = customerInfoDTO.toObject();
			customerInfoService.save(entity);
		}
		return modelMap;
	}

	@RequestMapping(value = "pageOfCustomers", method = RequestMethod.GET)
	@ResponseBody
	public Page<CustomerInfo> list(
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size,
			HttpServletResponse response) {
		Page<CustomerInfo> allCustomerInfo = customerInfoService.getAllCustomerInfo(page, size);
		return allCustomerInfo;
	}

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Resource(name = "customerInfoService")
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}
}
