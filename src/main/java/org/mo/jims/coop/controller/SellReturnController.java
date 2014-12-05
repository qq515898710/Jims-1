package org.mo.jims.coop.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.mo.jims.coop.dto.SellReturnDTO;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.SellReturn;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.SellReturnService;
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
	
	@RequestMapping(value = "admin/editsellreturn", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public JsonResponse edit(@RequestBody final SellReturnDTO sellReturnDTO){
		JsonResponse jsonResponse = new JsonResponse();
		String sapproval = sellReturnDTO.getApproval();
		System.out.println("----------------------"+sapproval);
		Approval approval = null;
		if ("1".equals(sapproval)) {
			approval = Approval.NOPASS;
			SellReturn editObject = sellReturnDTO.toEditObject(approval);
			boolean alterSell = sellReturnService.alterSellReturn(editObject);
			if (alterSell) {
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("修改进货成功");
			} else {
				jsonResponse.setSuccess(false);
				jsonResponse.setMessage("修改进货失败");
			}
		} else if ("0".equals(sapproval)) {
			approval = Approval.PASS;
			SellReturn editObject = sellReturnDTO.toEditObject(approval);
			boolean alterSell = sellReturnService.alterSellReturn(editObject);
			if (alterSell) {
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
	
	@RequestMapping(value = "coop/searchsellreturnbyid", method = RequestMethod.POST)
	@ResponseBody
	public SellReturn searchById(String searchId){
		return sellReturnService.getSellReturnByPK(searchId);
	}
	
	@RequestMapping(value = "coop/deletesellreturn", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteById(String deleteId) {
		JsonResponse jsonResponse = new JsonResponse();
		boolean removeSellByPK = sellReturnService.removeSellReturnByPK(deleteId);
		if (removeSellByPK) {
			jsonResponse.setSuccess(true);
			jsonResponse.setMessage("删除进货成功");
		} else {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("删除进货失败");
		}
		return jsonResponse;
	}
	
	@RequestMapping(value = "coop/pageOfSellReturn", method = RequestMethod.GET)
	@ResponseBody
	public Page<SellReturn> list(
			@RequestParam String goodname,
			@RequestParam String customername, 
			@RequestParam String beginTime,
			@RequestParam String endTime,
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size) {
		String ngoodName = "";
		String nprovidername = "";
		try {
			// 编码有问题,get传过来的参数
			ngoodName = new String(goodname.getBytes("iso8859-1"), "UTF-8");
			nprovidername = new String(customername.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SpringDateConverter springDateConverter = new SpringDateConverter();
		Page<SellReturn> sellByCriteria = sellReturnService.getSellReturnByCriteria(ngoodName, nprovidername, 
				springDateConverter.convert(beginTime),
				springDateConverter.convert(endTime), page, size);
		return sellByCriteria;
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
