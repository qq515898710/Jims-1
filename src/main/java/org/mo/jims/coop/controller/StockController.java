package org.mo.jims.coop.controller;


import javax.annotation.Resource;

import org.mo.jims.coop.dto.StockDTO;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.Stock;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.ProviderInfoService;
import org.mo.jims.coop.service.StockService;
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
public class StockController {
	
	private static Logger logger = LoggerFactory.getLogger(StockController.class);
	
	private ProviderInfoService providerInfoService;
	
	private GoodInfoService goodInfoService;
	
	private UserService userService;
	
	private StockService stockService;

	@RequestMapping(value = "coop/jinhuodan.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "stockManage");
		model.put("active", "JinHuoDan");
		logger.info("进入进货单界面");
		return new ModelAndView("coop/stockManage/JinHuoDan");
	}
	
	@RequestMapping(value = "coop/rukuchaxun.html", method = RequestMethod.GET)
	public ModelAndView showSearch(ModelMap model) {
		model.put("baseActive", "searchStatistic");
		model.put("active", "RuKuChaXun");
		logger.info("进入进货查询界面");
		return new ModelAndView("coop/searchStatistic/RuKuChaXun");
	}
	
	@RequestMapping(value = "coop/addStock", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public JsonResponse addStock(@RequestBody final StockDTO[] stockDTO){
		JsonResponse jsonResponse = new JsonResponse();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User userByPK = userService.getUserByPK(username);
		try{
			for(StockDTO dto :stockDTO) {
				String goodName = dto.getGoodName();
				GoodInfo goodInfoByName = goodInfoService.getGoodInfoByName(goodName);
				String providerName = dto.getProviderName();
				ProviderInfo providerInfoByName = providerInfoService.getProviderInfoByName(providerName);
				Stock addObject = dto.toAddObject(Approval.NOPASS, goodInfoByName, providerInfoByName, userByPK);
				stockService.saveStock(addObject);
			}
			jsonResponse.setMessage("插入成功");
			jsonResponse.setSuccess(true);
			return  jsonResponse;
		} catch (MyRuntimeException e) {
			throw new MyRuntimeException("添加入库信息失败");
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

	public StockService getStockService() {
		return stockService;
	}
	
	@Resource(name = "stockService")
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

}
