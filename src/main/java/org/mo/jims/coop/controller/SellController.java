package org.mo.jims.coop.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.mo.jims.coop.dto.SellDTO;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.Sell;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.SellService;
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
	
	@RequestMapping(value = "admin/editsell", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public JsonResponse edit(@RequestBody final SellDTO sellDTO){
		JsonResponse jsonResponse = new JsonResponse();
		String sapproval = sellDTO.getApproval();
		System.out.println("----------------------"+sapproval);
		Approval approval = null;
		if ("1".equals(sapproval)) {
			approval = Approval.NOPASS;
			Sell editObject = sellDTO.toEditObject(approval);
			boolean alterSell = sellService.alterSell(editObject);
			if (alterSell) {
				jsonResponse.setSuccess(true);
				jsonResponse.setMessage("修改进货成功");
			} else {
				jsonResponse.setSuccess(false);
				jsonResponse.setMessage("修改进货失败");
			}
		} else if ("0".equals(sapproval)) {
			approval = Approval.PASS;
			Sell editObject = sellDTO.toEditObject(approval);
			boolean alterSell = sellService.alterSell(editObject);
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
	
	@RequestMapping(value = "coop/searchsellbyid", method = RequestMethod.POST)
	@ResponseBody
	public Sell searchById(String searchId){
		return sellService.getSellByPK(searchId);
	}
	
	@RequestMapping(value = "coop/deletesell", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteById(String deleteId) {
		JsonResponse jsonResponse = new JsonResponse();
		boolean removeSellByPK = sellService.removeSellByPK(deleteId);
		if (removeSellByPK) {
			jsonResponse.setSuccess(true);
			jsonResponse.setMessage("删除进货成功");
		} else {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("删除进货失败");
		}
		return jsonResponse;
	}
	
	@RequestMapping(value = "coop/pageOfSell", method = RequestMethod.GET)
	@ResponseBody
	public Page<Sell> list(
			@RequestParam String goodname,
			@RequestParam String customername, 
			@RequestParam String beginTime,
			@RequestParam String endTime,
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size) {
		String ngoodName = "";
		String ncustomername = "";
		try {
			// 编码有问题,get传过来的参数
			ngoodName = new String(goodname.getBytes("iso8859-1"), "UTF-8");
			ncustomername = new String(customername.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SpringDateConverter springDateConverter = new SpringDateConverter();
		Page<Sell> sellByCriteria = sellService.getSellByCriteria(ngoodName, ncustomername, 
				springDateConverter.convert(beginTime),
				springDateConverter.convert(endTime), page, size);
		return sellByCriteria;
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
