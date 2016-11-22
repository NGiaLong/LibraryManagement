package com.controller.Staff;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Staff;
import com.model.DAO.Staff.StaffJDBC;

@Controller
public class StaffController {
	private ApplicationContext context;
	@RequestMapping(value = "/staff-management", method = RequestMethod.GET)
	public String quanLyNhanVien(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		List<Staff> sList = staffJDBC.getAll();
		model.addAttribute("sList",sList);
		return "staffmanagement";

	}
}
