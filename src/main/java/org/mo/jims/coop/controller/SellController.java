package org.mo.jims.coop.controller;

import javax.annotation.Resource;

import org.mo.jims.coop.dto.SellDTO;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.Sell;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.SellService;
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
public class SellController {

	public SellService sellService;

	public GoodInfoService goodInfoService;

	public CustomerInfoService customerInfoService;

	public UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(SellController.class);

	@RequestMapping(value = "coop/xiaoshoudan.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "sellManage");
		model.put("active", "XiaoShouDan");
		logger.info("进入销售单界面");
		return new ModelAndView("coop/sellManage/XiaoShouDan");
	}

	@RequestMapping(value = "coop/xiaoshouchaxun.html", method = RequestMethod.GET)
	public ModelAndView showSearch(ModelMap model) {
		model.put("baseActive", "searchStatistic");
		model.put("active", "XiaoShouChaXun");
		logger.info("进入销售单查询界面");
		return new ModelAndView("coop/searchStatistic/XiaoShouChaXun");
	}
	
	@RequestMapping(value = "coop/xiaoshoupaihang.html", method = RequestMethod.GET)
	public ModelAndView showSort(ModelMap model) {
		model.put("baseActive", "searchStatistic");
		model.put("active", "XiaoShouPaiHang");
		logger.info("进入销售排名界面");
		return new ModelAndView("coop/searchStatistic/XiaoShouPaiHang");
	}
	
	@RequestMapping(value = "coop/addSell", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public JsonResponse addSell(@RequestBody final SellDTO[] sellDTO){
		JsonResponse jsonResponse = new JsonResponse();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User userByPK = userService.getUserByPK(username);
		try{
			for(SellDTO dto : sellDTO){
				String goodName = dto.getGoodName();
				GoodInfo goodInfoByName = goodInfoService.getGoodInfoByName(goodName);
				String customerName = dto.getCustomerName();
				CustomerInfo customerInfoByName = customerInfoService.getCustomerInfoByName(customerName);
				Sell addObject = dto.toAddObject(Approval.NOPASS, goodInfoByName, customerInfoByName, userByPK);
				sellService.saveSell(addObject);
			}
			jsonResponse.setMessage("插入成功");
			jsonResponse.setSuccess(true);
			return  jsonResponse;
		}catch(Exception e){
			throw new MyRuntimeException("添加销售信息失败");
		}
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
