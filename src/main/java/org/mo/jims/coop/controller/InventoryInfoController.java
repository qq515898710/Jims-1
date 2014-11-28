package org.mo.jims.coop.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mo.jims.coop.dto.InventoryInfoDTO;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.jims.coop.service.GoodInfoService;
import org.mo.jims.coop.service.InventoryInfoService;
import org.mo.open.common.converter.SpringDateConverter;
import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;
import org.mo.open.common.service.UserService;
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
public class InventoryInfoController {

	private static Logger logger = LoggerFactory
			.getLogger(InventoryInfoController.class);

	private InventoryInfoService inventoryInfoService;

	private GoodInfoService goodInfoService;

	private UserService userService;

	@RequestMapping(value = "coop/kucunpandian.html", method = RequestMethod.GET)
	public ModelAndView checkInventory(ModelMap model) {
		model.put("baseActive", "baseManage");
		model.put("active", "KuCunPanDian");
		logger.info("进入库存盘点界面");
		return new ModelAndView("coop/depotManage/KuCunPanDian");
	}

	@RequestMapping(value = "coop/jiagetiaozheng.html", method = RequestMethod.GET)
	public ModelAndView adjustInventory(ModelMap model) {
		model.put("baseActive", "baseManage");
		model.put("active", "JiaGeTiaoZheng");
		logger.info("进入价格调整界面");
		return new ModelAndView("coop/depotManage/JiaGeTiaoZheng");
	}

	@RequestMapping(value = "coop/searchInventoryById", method = RequestMethod.POST)
	@ResponseBody
	public InventoryInfo searchInventoryById(
			@RequestParam(required = true) final String searchId) {
		String[] ids = searchId.split(",");
		InventoryInfo inventoryInfo = null;
		if (ids.length < 1) {
			inventoryInfo = inventoryInfoService.getInventoryInfoByPK(searchId);
		} else {
			inventoryInfo = inventoryInfoService.getInventoryInfoByPK(ids[0]);
		}
		// TODO:测试用
		System.out.println("search-----" + inventoryInfo.toString());
		return inventoryInfo;
	}
	
	@RequestMapping(value = "coop/showInventoryInfoPercentageofDayOnThisMonth", method = RequestMethod.GET)
	@ResponseBody
	public Float showInventoryInfoPercentageofDayOnThisMonth() {
		Float inventoryInfoPercentageofDayOnThisMonth = inventoryInfoService
				.getInventoryInfoPercentageofDayOnThisMonth();
		return inventoryInfoPercentageofDayOnThisMonth;
	}
	
	@RequestMapping(value = "coop/showCountInventoryInfoInToday", method = RequestMethod.GET)
	@ResponseBody
	public int showCountInventoryInfoInToday(){
		int countInventoryInfoInToday = inventoryInfoService.countInventoryInfoInToday();
		return countInventoryInfoInToday;
	}
	
	@RequestMapping(value = "coop/pageOfInventorysByCriteria", method = RequestMethod.GET)
	@ResponseBody
	public Page<InventoryInfo> listInventoryByCriteria(
			@RequestParam(required = true, defaultValue = "1") int page,
			@RequestParam(required = true, defaultValue = "10") int size,
			@RequestParam final String goodName,
			@RequestParam final String beginTime,
			@RequestParam final String endTime) {
		String newStr = "";
		try {
			// 编码有问题,get传过来的参数
			newStr = new String(goodName.getBytes("iso8859-1"), "UTF-8");
			// TODO:测试用
			System.out.println(beginTime + "---" + endTime);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SpringDateConverter springDateConverter = new SpringDateConverter();
		Page<InventoryInfo> inventoryInfoByNameOrAbbreviation = inventoryInfoService
				.getInventoryInfoByCriteria(newStr,
						springDateConverter.convert(beginTime),
						springDateConverter.convert(endTime), page, size);
		return inventoryInfoByNameOrAbbreviation;
	}

	@RequestMapping(value = "admin/editInventory", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, String> editInventory(
			@RequestBody final InventoryInfoDTO inventoryInfoDTO,
			HttpServletResponse response, HttpSession session) {
		// TODO:测试用
		System.out.println("edit-----" + inventoryInfoDTO.toString());
		final Map<String, String> modelMap = new HashMap<String, String>();
		String formtoken = inventoryInfoDTO.getFormtoken();
		String token = (String) session.getAttribute("InventoryEidtToken");
		if (formtoken.equals(token)) {// 防止重复提及表单
			// 启动线程,1.7新特性
			ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
			newCachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						GoodInfo goodInfoByName = goodInfoService.getGoodInfoByName(inventoryInfoDTO.getGoodName());
						if (goodInfoByName != null) {
							InventoryInfo entity = inventoryInfoDTO.toAddObject(goodInfoByName);
							inventoryInfoService.alterInventoryInfo(entity);
							modelMap.put("success", "ok");
						} else {
							modelMap.put("tip", "修改失败");
						}
					} catch (InterruptedException e) {
						modelMap.put("tip", "修改失败");
						throw new MyRuntimeException(getClass().getName() + "修改失败");
					}
				}
			});
			session.removeAttribute("InventoryEidtToken");
		} else {
			modelMap.put("tip", "请不要重复提交");
		}
		return modelMap;
	}

	@RequestMapping(value = "admin/deleteInventory", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteInventory(
			@RequestParam(required = true) String deleteId) {
		JsonResponse jsonResponse = null;
		String[] ids = deleteId.split(",");
		if (ids.length > 1) {
			boolean batchRemove = inventoryInfoService.batchRemove(ids);
			jsonResponse = deleteTip(batchRemove);
		}
		boolean removeByPK = inventoryInfoService
				.removeInventoryInfoByPK(deleteId);
		jsonResponse = deleteTip(removeByPK);
		return jsonResponse;
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

	public InventoryInfoService getInventoryInfoService() {
		return inventoryInfoService;
	}

	@Resource(name = "inventoryInfoService")
	public void setInventoryInfoService(
			InventoryInfoService inventoryInfoService) {
		this.inventoryInfoService = inventoryInfoService;
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

}
