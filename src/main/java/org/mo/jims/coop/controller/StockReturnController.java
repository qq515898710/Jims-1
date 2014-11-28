package org.mo.jims.coop.controller;


import javax.annotation.Resource;

import org.mo.jims.coop.dto.StockReturnDTO;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.StockReturn;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.ProviderInfoService;
import org.mo.jims.coop.service.StockReturnService;
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

@Controller
@RequestMapping("/")
public class StockReturnController {
	
	private static Logger logger = LoggerFactory.getLogger(StockReturnController.class);
	
	private ProviderInfoService providerInfoService;
	
	private GoodInfoService goodInfoService;
	
	private UserService userService;
	
	private StockReturnService stockReturnService;

	@RequestMapping(value = "coop/jinhuotuihuo.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "stockManage");
		model.put("active", "JinHuoTuiHuo");
		logger.info("进入进货退货界面");
		return new ModelAndView("coop/stockManage/JinHuoTuiHuo");
	}
	
	@RequestMapping(value = "coop/addStockReturn", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public JsonResponse addStock(@RequestBody final StockReturnDTO[] stockReturnDTOs){
		JsonResponse jsonResponse = new JsonResponse();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User userByPK = userService.getUserByPK(username);
		try{
			for(StockReturnDTO dto :stockReturnDTOs) {
				String goodName = dto.getGoodName();
				GoodInfo goodInfoByName = goodInfoService.getGoodInfoByName(goodName);
				String providerName = dto.getProviderName();
				ProviderInfo providerInfoByName = providerInfoService.getProviderInfoByName(providerName);
				StockReturn addObject = dto.toAddObject(Approval.NOPASS, goodInfoByName, providerInfoByName, userByPK);
				stockReturnService.saveStockReturn(addObject);
			}
			jsonResponse.setMessage("插入成功");
			jsonResponse.setSuccess(true);
			return  jsonResponse;
		} catch (MyRuntimeException e) {
			throw new MyRuntimeException("添加进货退货信息失败");
		}
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

	public StockReturnService getStockReturnService() {
		return stockReturnService;
	}
	
	@Resource(name = "stockReturnService")
	public void setStockReturnService(StockReturnService stockReturnService) {
		this.stockReturnService = stockReturnService;
	}

}
