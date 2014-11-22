package org.mo.jims.coop.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mo.jims.coop.dto.AddCustomerInfoDTO;
import org.mo.jims.coop.dto.EditCustomerInfoDTO;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.service.CustomerInfoService;
import org.mo.open.common.converter.SpringDateConverter;
import org.mo.open.common.exception.MyRuntimeException;
import org.mo.open.common.util.JsonResponse;
import org.mo.open.common.util.Page;
import org.mo.open.common.util.RegexValidateUtil;
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
public class CustomerInfoController {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerInfoController.class);
	
	private CustomerInfoService customerInfoService;

	@RequestMapping(value = "coop/kehuguanli.html", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {
		model.put("baseActive", "baseManage");
		model.put("active", "KeHuGuanLi");
		logger.info("进入客户管理界面");
		return new ModelAndView("coop/baseManage/KeHuGuanLi");
	}
	
	@RequestMapping(value="coop/searchCustomerById",method=RequestMethod.POST)
	@ResponseBody
	public CustomerInfo searchById(@RequestParam(required=true)  final String searchId){
		String[] ids = searchId.split(",");
		CustomerInfo customerInfo = null;
		if (ids.length < 1) {
			customerInfo = customerInfoService.getCustomerInfoByPK(searchId);
		} else {
			customerInfo = customerInfoService.getCustomerInfoByPK(ids[0]);
		}
		//TODO:测试用
		System.out.println("search-----"+customerInfo.toString());
		return customerInfo;
	}

	@RequestMapping(value = "coop/pageOfCustomersByName", method = RequestMethod.GET)
	@ResponseBody
	public Page<CustomerInfo> listByName(
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
		Page<CustomerInfo> customerInfoByNameOrAbbreviation = customerInfoService
				.getCustomerInfoByCriteria(newStr,
						springDateConverter.convert(beginTime),
						springDateConverter.convert(endTime), page, size);
		return customerInfoByNameOrAbbreviation;
	}
	
	@RequestMapping(value = "coop/pageOfCustomers", method = RequestMethod.GET)
	@ResponseBody
	public Page<CustomerInfo> list(
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size) {
		Page<CustomerInfo> allCustomerInfo = customerInfoService.getAllCustomerInfoByPage(page, size);
		return allCustomerInfo;
	}
	
	@RequestMapping(value = "admin/editCustomer", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, String> edit(@RequestBody final EditCustomerInfoDTO customerInfoDTO,
			HttpServletResponse response, HttpSession session){
		//TODO:测试用
		System.out.println("edit-----"+customerInfoDTO.toString());
		final Map<String, String> modelMap = validateEditCutomerInfoDTO(customerInfoDTO);//校验表单
		String formtoken = customerInfoDTO.getFormtoken();
		String token = (String) session.getAttribute("CustomerEidtToken");
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
							CustomerInfo entity = customerInfoDTO.toObject();
							customerInfoService.alterCustomerInfo(entity);
						} catch (InterruptedException e) {
							modelMap.put("tip", "修改失败");
						}
					}
				});
				session.removeAttribute("CustomerEidtToken");
			}
		}else {
			modelMap.put("tip", "请不要重复提交");
		}
		return modelMap;
	}
	

	@RequestMapping(value = "admin/deleteCustomer", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse delete(@RequestParam(required=true) String deleteId) {
		JsonResponse jsonResponse =null;
		String[] ids = deleteId.split(",");
		if (ids.length > 1) {
			boolean batchRemove = customerInfoService.batchRemove(ids);
			 jsonResponse = deleteTip(batchRemove);
		}
		boolean removeByPK = customerInfoService.removeCustomerInfoByPK(deleteId);
		jsonResponse = deleteTip(removeByPK);
		return jsonResponse;
	}

	@RequestMapping(value = "admin/addCustomer", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, String> add(
			@RequestBody final AddCustomerInfoDTO addCustomerInfoDTO,
			HttpServletResponse response, HttpSession session) {
		final Map<String, String> modelMap = validateAddCutomerInfoDTO(addCustomerInfoDTO);//校验表单
		String formtoken = addCustomerInfoDTO.getFormtoken();
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
							CustomerInfo entity = addCustomerInfoDTO.toObject();
							customerInfoService.saveCustomerInfo(entity);
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

	private Map<String, String> validateAddCutomerInfoDTO(AddCustomerInfoDTO customerInfoDTO) {
		Map<String, String> modelMap = new HashMap<String, String>();
		if ("".equals(customerInfoDTO.getName())) {
			modelMap.put("name", "客户名称不能为空");
		}
		if ("".equals(customerInfoDTO.getAbbreviation())) {
			modelMap.put("abbreviation", "简称不能为空");
		}
		if ("".equals(customerInfoDTO.getAddress())) {
			modelMap.put("address", "地址不能为空");
		}
		if ("".equals(customerInfoDTO.getPostalCode())) {
			modelMap.put("postalCode", "邮政编码不能为空");
		}
		if ("".equals(customerInfoDTO.getPhone())) {
			modelMap.put("phone", "手机不能为空");
		} else if (!RegexValidateUtil.checkCellphone(customerInfoDTO.getPhone())) {
			modelMap.put("phone", "手机格式不正确(13000000000)");
		}
		if ("".equals(customerInfoDTO.getFax())) {
			modelMap.put("fax", "传真不能为空");
		}else if(!RegexValidateUtil.checkFax(customerInfoDTO.getFax())) {
			modelMap.put("fax", "传真格式不正确");
		}
		if ("".equals(customerInfoDTO.getContacts())) {
			modelMap.put("contacts", "联系人不能为空");
		}
		if ("".equals(customerInfoDTO.getTelephone())) {
			modelMap.put("telephone", "座机不能为空");
		}else if(!RegexValidateUtil.checkTelephone(customerInfoDTO.getTelephone())) {
			modelMap.put("telephone", "座机格式不正确(XXXX-XXXXXXX)");
		}
		if ("".equals(customerInfoDTO.getEmail())) {
			modelMap.put("email", "邮箱不能为空");
		}else if(!RegexValidateUtil.checkEmail(customerInfoDTO.getEmail())){
			modelMap.put("email", "邮箱格式不正确");
		}
		if ("".equals(customerInfoDTO.getDepositBank())) {
			modelMap.put("depositBank", "开户行不能为空");
		}
		if ("".equals(customerInfoDTO.getAccountBank())) {
			modelMap.put("accountBank", "开户行帐号不能为空");
		}
		return modelMap;
	}
	
	private Map<String, String> validateEditCutomerInfoDTO(
			EditCustomerInfoDTO customerInfoDTO) {
		Map<String, String> modelMap = new HashMap<String, String>();
		if ("".equals(customerInfoDTO.getName())) {
			modelMap.put("name", "客户名称不能为空");
		}
		if ("".equals(customerInfoDTO.getAbbreviation())) {
			modelMap.put("abbreviation", "简称不能为空");
		}
		if ("".equals(customerInfoDTO.getAddress())) {
			modelMap.put("address", "地址不能为空");
		}
		if ("".equals(customerInfoDTO.getPostalCode())) {
			modelMap.put("postalCode", "邮政编码不能为空");
		}
		if ("".equals(customerInfoDTO.getPhone())) {
			modelMap.put("phone", "手机不能为空");
		} else if (!RegexValidateUtil.checkCellphone(customerInfoDTO.getPhone())) {
			modelMap.put("phone", "手机格式不正确(13000000000)");
		}
		if ("".equals(customerInfoDTO.getFax())) {
			modelMap.put("fax", "传真不能为空");
		}else if(!RegexValidateUtil.checkFax(customerInfoDTO.getFax())) {
			modelMap.put("fax", "传真格式不正确");
		}
		if ("".equals(customerInfoDTO.getContacts())) {
			modelMap.put("contacts", "联系人不能为空");
		}
		if ("".equals(customerInfoDTO.getTelephone())) {
			modelMap.put("telephone", "座机不能为空");
		}else if(!RegexValidateUtil.checkTelephone(customerInfoDTO.getTelephone())) {
			modelMap.put("telephone", "座机格式不正确(XXXX-XXXXXXX)");
		}
		if ("".equals(customerInfoDTO.getEmail())) {
			modelMap.put("email", "邮箱不能为空");
		}else if(!RegexValidateUtil.checkEmail(customerInfoDTO.getEmail())){
			modelMap.put("email", "邮箱格式不正确");
		}
		if ("".equals(customerInfoDTO.getDepositBank())) {
			modelMap.put("depositBank", "开户行不能为空");
		}
		if ("".equals(customerInfoDTO.getAccountBank())) {
			modelMap.put("accountBank", "开户行帐号不能为空");
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
	
	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Resource(name = "customerInfoService")
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}
}
