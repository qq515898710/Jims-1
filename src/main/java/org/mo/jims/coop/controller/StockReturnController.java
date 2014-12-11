package org.mo.jims.coop.controller;


import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.mo.jims.coop.dto.StockReturnDTO;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.StockReturn;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.ProviderInfoService;
import org.mo.jims.coop.service.StockReturnService;
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
	
	@RequestMapping(value = "coop/rukutuihuochaxun.html", method = RequestMethod.GET)
	public ModelAndView showSearch(ModelMap model) {
		model.put("baseActive", "searchStatistic");
		model.put("active", "RuKuTuiHuoChaXun");
		logger.info("进入进货退货查询界面");
		return new ModelAndView("coop/searchStatistic/RuKuTuiHuoChaXun");
	}
	
	@RequestMapping(value = "admin/editstockreturn", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public JsonResponse edit(@RequestBody final StockReturnDTO stockReturnDTO){
		JsonResponse jsonResponse = new JsonResponse();
		String sapproval = stockReturnDTO.getApproval();
		System.out.println("----------------------"+sapproval);
		Approval approval = null;
		if ("1".equals(sapproval)) {
			approval = Approval.NOPASS;
			StockReturn editObject = stockReturnDTO.toEditObject(approval);
			boolean alterStock = stockReturnService.alterStockReturn(editObject);
			if (alterStock) {
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("修改进货成功");
			} else {
				jsonResponse.setSuccess(false);
				jsonResponse.setMessage("修改进货失败");
			}
		} else if ("0".equals(sapproval)) {
			approval = Approval.PASS;
			StockReturn editObject = stockReturnDTO.toEditObject(approval);
			boolean alterStock = stockReturnService.alterStockReturn(editObject);
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
	
	@RequestMapping(value = "coop/searchstockreturnbyid", method = RequestMethod.POST)
	@ResponseBody
	public StockReturn searchById(String searchId){
		System.out.println(searchId);
		return stockReturnService.getStockReturnByPK(searchId);
	}
	
	@RequestMapping(value = "coop/deletestockreturn", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteById(String deleteId) {
		JsonResponse jsonResponse = new JsonResponse();
		boolean removeStockByPK = stockReturnService.removeStockReturnByPK(deleteId);
		if (removeStockByPK) {
			jsonResponse.setSuccess(true);
			jsonResponse.setMessage("删除进货成功");
		} else {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("删除进货失败");
		}
		return jsonResponse;
	}
	
	@RequestMapping(value = "coop/pageOfStockReturn", method = RequestMethod.GET)
	@ResponseBody
	public Page<StockReturn> list(
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
		Page<StockReturn> stockByCriteria = stockReturnService.getStockReturnByCriteria(ngoodName, nprovidername, nusername,
				springDateConverter.convert(beginTime),
				springDateConverter.convert(endTime), page, size);
		return stockByCriteria;
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
