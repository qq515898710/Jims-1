package org.mo.open.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DefaultController implements GenericController {

	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
