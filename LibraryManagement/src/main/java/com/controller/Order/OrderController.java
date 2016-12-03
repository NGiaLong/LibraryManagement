package com.controller.Order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Student;
import com.model.DAO.Student.StudentJDBC;

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
	private ApplicationContext context;
	@RequestMapping(value = "/student-management", method = RequestMethod.GET)
	public String studentmanagement(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		List<Student> sList = studentJDBC.getAll();
		model.addAttribute("sList", sList);
		return "studentmanagement";
	}
}
