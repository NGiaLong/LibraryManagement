package com.controller.Login;


import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	private ApplicationContext context;
	@ModelAttribute("loginBean")
	public LoginBean loginBean(){
		return new LoginBean();
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String staffmanagement(ModelMap model, HttpServletRequest request) {
		return "login";
	}
}
