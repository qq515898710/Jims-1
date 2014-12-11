package org.mo.jims.coop.controller;


import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.mo.jims.coop.dto.StockDTO;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.Stock;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.ProviderInfoService;
import org.mo.jims.coop.service.StockService;
import org.mo.open.common.converter.SpringDateConverter;
import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;
import org.mo.open.common.service.UserService;
import org.mo.open.common.util.JsonResponse;
import org.mo.open.common.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@RequestMapping(value = "admin/editstock", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public JsonResponse edit(@RequestBody final StockDTO stockDTO){
		JsonResponse jsonResponse = new JsonResponse();
		String sapproval = stockDTO.getApproval();
		System.out.println("----------------------"+sapproval);
		Approval approval = null;
		if ("1".equals(sapproval)) {
			approval = Approval.NOPASS;
			Stock editObject = stockDTO.toEditObject(approval);
			boolean alterStock = stockService.alterStock(editObject);
			if (alterStock) {
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("修改进货成功");
			} else {
				jsonResponse.setSuccess(false);
				jsonResponse.setMessage("修改进货失败");
			}
		} else if ("0".equals(sapproval)) {
			approval = Approval.PASS;
			Stock editObject = stockDTO.toEditObject(approval);
			boolean alterStock = stockService.alterStock(editObject);
			if (alterStock) {
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("修改进货成功");
			} else {
				jsonResponse.setSuccess(false);
				jsonResponse.setMessage("修改进货失败");
			}
		} else {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("修改进货失败");
		}
		return jsonResponse;
	}
	
	@RequestMapping(value = "coop/searchstockbyid", method = RequestMethod.POST)
	@ResponseBody
	public Stock searchById(String searchId){
		return stockService.getStockByPK(searchId);
	}
	
	@RequestMapping(value = "coop/deletestock", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteById(String deleteId) {
		JsonResponse jsonResponse = new JsonResponse();
		boolean removeStockByPK = stockService.removeStockByPK(deleteId);
		if (removeStockByPK) {
			jsonResponse.setSuccess(true);
			jsonResponse.setMessage("删除进货成功");
		} else {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("删除进货失败");
		}
		return jsonResponse;
	}
	
	@RequestMapping(value = "coop/pageOfStock", method = RequestMethod.GET)
	@ResponseBody
	public Page<Stock> list(
			@RequestParam String goodname,
			@RequestParam String providername, 
			@RequestParam String username,
			@RequestParam String beginTime,
			@RequestParam String endTime,
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size) {
		String ngoodName = "";
		String nprovidername = "";
		String nusername = "";
		try {
			// 编码有问题,get传过来的参数
			ngoodName = new String(goodname.getBytes("iso8859-1"), "UTF-8");
			nprovidername = new String(providername.getBytes("iso8859-1"), "UTF-8");
			nusername = new String(username.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SpringDateConverter springDateConverter = new SpringDateConverter();
		Page<Stock> stockByCriteria = stockService.getStockByCriteria(ngoodName, nprovidername, nusername,
				springDateConverter.convert(beginTime),
				springDateConverter.convert(endTime), page, size);
		return stockByCriteria;
	}
	
	@RequestMapping(value = "coop/addStock", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public JsonResponse addStock(@RequestBody final StockDTO[] stockDTO){
		JsonResponse jsonResponse = new JsonResponse();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
