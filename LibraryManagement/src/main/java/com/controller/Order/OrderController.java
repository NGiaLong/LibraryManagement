package com.controller.Order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Order;
import com.model.OrderDetail;
import com.model.DAO.Order.OrderJDBC;
import com.model.DAO.OrderDetail.OrderDetailJDBC;

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
	private ApplicationContext context;
	
	@RequestMapping( method = RequestMethod.GET)
	public String getListOrder(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		List<Order> oList = orderJDBC.getAll();
		model.addAttribute("oList", oList);
		return "indexOrder";
	}
	
	@RequestMapping(value = "/ExpiredHistory", method = RequestMethod.GET)
	public String getListExpiredHistory(ModelMap model, HttpServletRequest request){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		List<Order> expiredList = orderJDBC.getExpired();
		model.addAttribute("expiredList", expiredList);
		return "expiredHistory";
	}
	
	@RequestMapping(value = "/Detail/{id}", method = RequestMethod.GET)
	public String getOrderDetail(ModelMap model, HttpServletRequest request, @PathVariable int id){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		Order order = orderJDBC.getOne(id);
		System.out.println(order);
		model.addAttribute("order", order);
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		List<OrderDetail> detailList = detailJDBC.getDetailByOrderId(id);
		model.addAttribute("detailList",detailList);
		return "detailOrder";
	}
}
