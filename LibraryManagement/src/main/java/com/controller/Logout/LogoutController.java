package com.controller.Logout;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String processLogout(HttpServletRequest request) {
		int role = (int) request.getSession().getAttribute("roleSession");
		if (role == 1) {
			request.getSession().setAttribute("staffSession", null);
		} else {
			request.getSession().setAttribute("studentSession", null);
		}
		request.getSession().setAttribute("roleSession", 0);
		return "redirect:/login";
	}
}
