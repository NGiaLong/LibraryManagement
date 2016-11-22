package com.controller.Login;


import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
	private ApplicationContext context;
	@ModelAttribute("loginBean")
	public LoginBean loginBean(){
		return new LoginBean();
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView(ModelMap model, HttpServletRequest request) {
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("SpringWeb") LoginBean loginBean, ModelMap model, HttpServletRequest request, RedirectAttributes redirectAtt) {
		redirectAtt.addFlashAttribute("success", "Đăng nhập thành công!");
		return "redirect:/index";
	}
}
