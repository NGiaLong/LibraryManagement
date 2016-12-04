package com.controller.Order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Order;
import com.model.Student;
import com.model.DAO.Order.OrderJDBC;
import com.model.DAO.Student.StudentJDBC;

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
	private ApplicationContext context;
	@RequestMapping( method = RequestMethod.GET)
	public String studentmanagement(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		List<Order> oList = orderJDBC.getAll();
		model.addAttribute("oList", oList);
		return "indexOrder";
	}
}
