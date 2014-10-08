package org.mo.jims.coop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/coop/")
public class BaseController {

	@RequestMapping(value = "cZKs8DCjl7PhWwE5HP9FeA==.html", method = RequestMethod.GET)
	public ModelAndView KeHuGuanLi(ModelMap model) {
		model.put("baseActive", "baseManage");
		model.put("active", "KeHuGuanLi");
		return new ModelAndView("coop/baseManage/KeHuGuanLi");
	}
	
}
