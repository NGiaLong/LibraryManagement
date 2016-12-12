package com.controller.Order;

import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Book;
import com.model.Order;
import com.model.OrderDetail;
import com.model.Staff;
import com.model.Student;
import com.model.DAO.Book.BookJDBC;
import com.model.DAO.Order.OrderJDBC;
import com.model.DAO.OrderDetail.OrderDetailJDBC;
import com.model.DAO.Student.StudentJDBC;

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
	private ApplicationContext context;

	@RequestMapping(method = RequestMethod.GET)
	public String getListOrder(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		List<Order> oList = orderJDBC.getAll();
		model.addAttribute("oList", oList);
		return "indexOrder";
	}

	@RequestMapping(value = "/Add", method = RequestMethod.GET)
	public String addOrder(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		List<Student> students = studentJDBC.getAll();
		model.addAttribute("sList", students);
		return "addOrder";
	}
	
	@RequestMapping(value = "/Add/Detail/{orderId}", method = RequestMethod.GET)
	public String addOrderDetail(@PathVariable int orderId,ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		List<Book> bookList = bookJDBC.getAll1();
		Order order = orderJDBC.getOne(orderId);
		List<OrderDetail> oDList = detailJDBC.getDetailByOrderId(orderId);
		model.addAttribute("bList", bookList);
		model.addAttribute("order", order);
		model.addAttribute("oDList", oDList);
		return "addDetailForOrder";
	}
	
	@RequestMapping(value = "/Add/Detail/{orderId}/{bookId}", method = RequestMethod.GET)
	public String addDetail(@PathVariable int orderId,@PathVariable int bookId ,RedirectAttributes redirectAtt,ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
//		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		int check = detailJDBC.addDetailByOBId(orderId, bookId);
		if(check == 1){
			redirectAtt.addFlashAttribute("success", "Thêm sách thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Thêm sách thất bại");
		}
		return "redirect:/Order/Add/Detail/"+orderId;
	}
	
	@RequestMapping(value = "/Add/Detail/{orderId}/delete/{id}", method = RequestMethod.GET)
	public String removedDetail(@PathVariable int id, @PathVariable int orderId,RedirectAttributes redirectAtt,ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		OrderDetail oDetail = (OrderDetail) detailJDBC.getDetailById(id);
		int m = 0;
	
			m = bookJDBC.updateStatus(oDetail.getBookId());
		
		if(m == 0){
			redirectAtt.addFlashAttribute("error", "Bỏ sách thất bại");
		}else{
			int check = detailJDBC.deleteDetailById(id);
			if(check == 1 ){
				redirectAtt.addFlashAttribute("success", "Bỏ sách thành công");
			} else {
				redirectAtt.addFlashAttribute("error", "Bỏ sách thất bại");
			}
		}
		return "redirect:/Order/Add/Detail/"+orderId;
	}

	@RequestMapping(value = "/Add/{stuId}", method = RequestMethod.GET)
	public String addOrderId(@PathVariable int stuId, ModelMap model, HttpServletRequest request, RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		Staff staffss = (Staff) request.getSession().getAttribute("staffSession");
		int add = orderJDBC.addOrder(stuId, staffss.getId());
		Order order =  orderJDBC.getLastOrder();
		int id = 0;
		id = order.getId();
		if (add == 1) {
			redirectAtt.addFlashAttribute("success", "Tạo đơn mượn sách thành công");
			
//			request.getSession().setAttribute("orderSSId", id);
			System.out.println("Là: " + id);
			return "redirect:/Order/Add/Detail/"+id;
		} else {
			redirectAtt.addFlashAttribute("error", "Tạo đơn mượn sách thất bại");
			return "redirect:/Add";
		}
		
	}

	@RequestMapping(value = "/ExpiredHistory", method = RequestMethod.GET)
	public String getListExpiredHistory(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		List<Order> expiredList = orderJDBC.getExpired();
		model.addAttribute("expiredList", expiredList);
		return "expiredHistory";
	}

	@RequestMapping(value = "/Detail/{id}", method = RequestMethod.GET)
	public String getOrderDetail(ModelMap model, HttpServletRequest request, @PathVariable int id) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		Order order = orderJDBC.getOne(id);
		model.addAttribute("order", order);
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		List<OrderDetail> detailList = detailJDBC.getDetailByOrderId(id);
		model.addAttribute("detailList", detailList);
		return "detailOrder";
	}

	@RequestMapping(value = "/Return/{id}", method = RequestMethod.GET)
	public String returnOrder(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		// Dat lai trang thai cua sach
		List<OrderDetail> detailList = detailJDBC.getDetailByOrderId(id);
		for (OrderDetail orderDetail : detailList) {
			int book = bookJDBC.updateStatus(orderDetail.getBookId());
			if (book != 1) {
				redirectAtt.addFlashAttribute("error", "Lỗi cập nhật trạng thái sách");
			}
		}
		int order = orderJDBC.updateStatus(id);
		if (order == 1) {
			redirectAtt.addFlashAttribute("success", "Trả sách thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Trả sách thất bại");
		}
		return "redirect:/Order";
	}

	@RequestMapping(value = "/Delete/{id}", method = RequestMethod.GET)
	public String DeleteOrder(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		// Dat lai trang thai cua sach
		List<OrderDetail> detailList = detailJDBC.getDetailByOrderId(id);
		for (OrderDetail orderDetail : detailList) {
			int book = bookJDBC.updateStatus(orderDetail.getBookId());
			if (book != 1) {
				redirectAtt.addFlashAttribute("error", "Lỗi cập nhật trạng thái sách");
			}
		}
		// Xoa orderDetail
		if (detailList.size() > 0) {
			int detail = detailJDBC.deleteDetailByOrderId(id);
			if (detail == 0) {
				redirectAtt.addFlashAttribute("error", "Xóa chi tiết đơn mượn sách thất bại");
			}
		}

		// Xoa Order
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		int order = orderJDBC.deleteOne(id);
		if (order == 1) {
			redirectAtt.addFlashAttribute("success", "Xóa đơn mượn sách thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Xóa đơn mượn sách thất bại");
		}
		return "redirect:/Order";
	}
	
	@RequestMapping(value = "/OrderList", method = RequestMethod.GET)
	public String getListOrderByUser(ModelMap model, HttpServletRequest request, RedirectAttributes redirectAtt){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		if(request.getSession().getAttribute("studentSession")==null){
			redirectAtt.addFlashAttribute("error", "Bạn không có quyền truy cập vào trang này");
			return "redirect:/thongtincanhan";
		}
		Student std = (Student) request.getSession().getAttribute("studentSession");		
		List<Order> orderList = orderJDBC.getBorrowedByUserId(std.getId());
		model.addAttribute("orderList", orderList);
		return "indexOrderStudent";
	}
	
	@RequestMapping(value = "/OrderHistory", method = RequestMethod.GET)
	public String getListOrderHistoryByUser(ModelMap model, HttpServletRequest request, RedirectAttributes redirectAtt){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		OrderJDBC orderJDBC = (OrderJDBC) context.getBean("orderJDBC");
		if(request.getSession().getAttribute("studentSession")==null){
			redirectAtt.addFlashAttribute("error", "Bạn không có quyền truy cập vào trang này");
			return "redirect:/thongtincanhan";
		}
		Student std = (Student) request.getSession().getAttribute("studentSession");		
		List<Order> orderList = orderJDBC.getHistoryByUserId(std.getId());
		model.addAttribute("orderList", orderList);
		return "indexOrderStudent";
	}
}
