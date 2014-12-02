package org.mo.jims.coop.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mo.jims.coop.dto.ProviderInfoDTO;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.service.ProviderInfoService;
import org.mo.open.common.converter.SpringDateConverter;
import org.mo.open.common.exception.MyRuntimeException;
import org.mo.open.common.util.JsonResponse;
import org.mo.open.common.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProviderInfoController {
	
	private static Logger logger = LoggerFactory.getLogger(ProviderInfoController.class);
	
	private ProviderInfoService providerInfoService;
	
	@RequestMapping(value = "admin/gongyingshangguanli.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "baseManage");
		model.put("active", "GongYingShangGuanLi");
		logger.info("进入供应商管理界面");
		return new ModelAndView("coop/baseManage/GongYingShangGuanLi");
	}
	
	@RequestMapping(value = "coop/gongyingshangchaxun.html", method = RequestMethod.GET)
	public ModelAndView showSearch(ModelMap model) {
		model.put("baseActive", "searchStatistic");
		model.put("active", "GongYingShangChaXun");
		logger.info("进入供应商查询界面");
		return new ModelAndView("coop/searchStatistic/GongYingShangChaXun");
	}
	
	@RequestMapping(value="coop/searchProviderByName",method=RequestMethod.GET)
	@ResponseBody
	public ProviderInfo searchByName(@RequestParam(required=true)String name){
		String newStr = "";
		try {
			// 编码有问题,get传过来的参数
			newStr = new String(name.getBytes("iso8859-1"), "UTF-8");
			//TODO:测试用
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ProviderInfo providerInfoByName = providerInfoService.getProviderInfoByName(newStr);
		return providerInfoByName;
	}
	
	@RequestMapping(value="coop/listProviderByName",method=RequestMethod.GET)
	@ResponseBody
	public List<String> listByName(){
		List<String> allProviderName = providerInfoService.getAllProviderName();
		return allProviderName;
	}
	
	@RequestMapping(value="coop/searchProviderById",method=RequestMethod.POST)
	@ResponseBody
	public ProviderInfo searchById(@RequestParam(required=true)  final String searchId){
		String[] ids = searchId.split(",");
		ProviderInfo providerInfo = null;
		if (ids.length < 1) {
			providerInfo = providerInfoService.getProviderInfoByPK(searchId);
		} else {
			providerInfo = providerInfoService.getProviderInfoByPK(ids[0]);
		}
		//TODO:测试用
		System.out.println("search-----"+providerInfo.toString());
		return providerInfo;
	}

	@RequestMapping(value = "coop/pageOfProvidersByCriteria", method = RequestMethod.GET)
	@ResponseBody
	public Page<ProviderInfo> listByCriteria(
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size,
			@RequestParam final String name,
			@RequestParam final String beginTime,
			@RequestParam final String endTime) {
		String newStr = "";
		try {
			// 编码有问题,get传过来的参数
			newStr = new String(name.getBytes("iso8859-1"), "UTF-8");
			//TODO:测试用
			System.out.println(beginTime + "---" + endTime);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SpringDateConverter springDateConverter = new SpringDateConverter();
		Page<ProviderInfo> providerInfoByNameOrAbbreviation = providerInfoService
				.getProviderInfoByCriteria(newStr,
						springDateConverter.convert(beginTime),
						springDateConverter.convert(endTime), page, size);
		return providerInfoByNameOrAbbreviation;
	}
	
	@RequestMapping(value = "admin/editProvider", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, String> edit(@RequestBody final ProviderInfoDTO providerInfoDTO,
			HttpServletResponse response, HttpSession session){
		//TODO:测试用
		System.out.println("edit-----"+providerInfoDTO.toString());
		final Map<String, String> modelMap = validateCutomerInfoDTO(providerInfoDTO);//校验表单
		String formtoken = providerInfoDTO.getFormtoken();
		String token = (String) session.getAttribute("ProviderEidtToken");
		if (formtoken.equals(token)) {//防止重复提及表单
			if (modelMap.isEmpty()) {//对表单校验,空继续执行
				modelMap.put("success", "ok");
				//启动线程,1.7新特性
				ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
				newCachedThreadPool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(3000);
							ProviderInfo entity = providerInfoDTO.toEditObject();
							providerInfoService.alterProviderInfo(entity);
						} catch (InterruptedException e) {
							modelMap.put("tip", "修改失败");
						}
					}
				});
				session.removeAttribute("ProviderEidtToken");
			}
		}else {
			modelMap.put("tip", "请不要重复提交");
		}
		return modelMap;
	}
	

	@RequestMapping(value = "admin/deleteProvider", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse delete(@RequestParam(required=true) String deleteId) {
		JsonResponse jsonResponse =null;
		String[] ids = deleteId.split(",");
		List<String> id = new ArrayList<String>();
		for(String result : ids){
			id.add(result);
		}
		boolean batchRemove = providerInfoService.batchRemove(id);
		jsonResponse = deleteTip(batchRemove);
		return jsonResponse;
	}

	@RequestMapping(value = "admin/addProvider", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, String> add(
			@RequestBody final ProviderInfoDTO addProviderInfoDTO,
			HttpServletResponse response, HttpSession session) {
		final Map<String, String> modelMap = validateCutomerInfoDTO(addProviderInfoDTO);//校验表单
		String formtoken = addProviderInfoDTO.getFormtoken();
		String token = (String) session.getAttribute("token");
		if (formtoken.equals(token)) {//防止重复提及表单
			if (modelMap.isEmpty()) {//对表单校验,空继续执行
				modelMap.put("success", "ok");
				//启动线程,1.7新特性
				ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
				newCachedThreadPool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(3000);
							ProviderInfo entity = addProviderInfoDTO.toAddObject();
							//TODO 商品添加好没做啊,记得来修改啊,关于多对多的问题啊
							providerInfoService.saveProviderInfo(entity);
						} catch (InterruptedException e) {
							modelMap.put("tip", "保存失败");
							throw new MyRuntimeException(
									"保存失败");
						}
					}
				});
				session.removeAttribute("token");
			}
		}else {
			modelMap.put("tip", "请不要重复提交");
		}
		return modelMap;
	}

	private Map<String, String> validateCutomerInfoDTO(ProviderInfoDTO providerInfoDTO) {
		Map<String, String> modelMap = new HashMap<String, String>();
		if ("".equals(providerInfoDTO.getName())) {
			modelMap.put("name", "供应商名称不能为空");
		}
		if ("".equals(providerInfoDTO.getAbbreviation())) {
			modelMap.put("abbreviation", "简称不能为空");
		}
		if ("".equals(providerInfoDTO.getAddress())) {
			modelMap.put("address", "地址不能为空");
		}
		if ("".equals(providerInfoDTO.getPostalCode())) {
			modelMap.put("postalCode", "邮政编码不能为空");
		}
		if ("".equals(providerInfoDTO.getPhone())) {
			modelMap.put("phone", "电话不能为空");
		}
		if ("".equals(providerInfoDTO.getFax())) {
			modelMap.put("fax", "传真不能为空");
		}
		if ("".equals(providerInfoDTO.getContacts())) {
			modelMap.put("contacts", "联系人不能为空");
		}
		if ("".equals(providerInfoDTO.getTelephone())) {
			modelMap.put("telephone", "联系人电话不能为空");
		}
		if ("".equals(providerInfoDTO.getDepositBank())) {
			modelMap.put("depositBank", "开户行不能为空");
		}
		if ("".equals(providerInfoDTO.getEmail())) {
			modelMap.put("email", "电子邮箱不能为空");
		}
		return modelMap;
	}
	
	private JsonResponse deleteTip(boolean removeByPK) {
		JsonResponse jsonResponse = new JsonResponse();
		if (removeByPK) {
			jsonResponse.setSuccess(true);
			jsonResponse.setMessage("删除成功");
		} else {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("删除失败");
		}
		return jsonResponse;
	}
	
	public ProviderInfoService getProviderInfoService() {
		return providerInfoService;
	}

	@Resource(name = "providerInfoService")
	public void setProviderInfoService(ProviderInfoService providerInfoService) {
		this.providerInfoService = providerInfoService;
	}
	
	
}
