package org.mo.jims.coop.controller;

import javax.annotation.Resource;

import org.mo.jims.coop.dto.SellReturnDTO;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.SellReturn;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.SellReturnService;
import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;
import org.mo.open.common.service.UserService;
import org.mo.open.common.util.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author moziqi
 *
 */
@Controller
public class SellReturnController {

	public SellReturnService sellReturnService;

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
	
	@RequestMapping(value = "coop/addSellReturn", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public JsonResponse addSell(@RequestBody final SellReturnDTO[] sellReturnDTO){
		JsonResponse jsonResponse = new JsonResponse();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User userByPK = userService.getUserByPK(username);
		try{
			for(SellReturnDTO dto : sellReturnDTO){
				String goodName = dto.getGoodName();
				GoodInfo goodInfoByName = goodInfoService.getGoodInfoByName(goodName);
				String customerName = dto.getCustomerName();
				CustomerInfo customerInfoByName = customerInfoService.getCustomerInfoByName(customerName);
				SellReturn addObject = dto.toAddObject(Approval.NOPASS, goodInfoByName, customerInfoByName, userByPK);
				sellReturnService.saveSellReturn(addObject);
			}
			jsonResponse.setMessage("插入成功");
			jsonResponse.setSuccess(true);
			return  jsonResponse;
		}catch(Exception e){
			throw new MyRuntimeException("添加销售退货信息失败");
		}
	}

	public SellReturnService getSellReturnService() {
		return sellReturnService;
	}

	@Resource(name = "sellReturnService")
	public void setSellReturnService(SellReturnService sellReturnService) {
		this.sellReturnService = sellReturnService;
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
