package com.controller.Logout;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LogoutController {
	@RequestMapping(value = "/logout" ,method = RequestMethod.GET)
	public String processLogout(HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
		return "redirect:/login";
	}
}
