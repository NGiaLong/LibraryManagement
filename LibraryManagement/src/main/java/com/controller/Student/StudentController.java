package com.controller.Student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Student;
import com.model.Student;
import com.model.DAO.Student.StudentJDBC;
import com.model.DAO.Student.StudentJDBC;
import com.model.DAO.Student.StudentJDBC;
import com.model.DAO.Student.StudentJDBC;

@Controller
public class StudentController {
	private ApplicationContext context;
	@ModelAttribute("addStudentBean")
	public AddStudentBean addStudentBean(){
		return new AddStudentBean();
	}
	@ModelAttribute("editStudentBean")
	public EditStudentBean editStudentBean(){
		return new EditStudentBean();
	}
	@RequestMapping(value = "/student-management", method = RequestMethod.GET)
	public String studentmanagement(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		List<Student> sList = studentJDBC.getAll();
		model.addAttribute("sList", sList);
		return "studentmanagement";
	}

	@RequestMapping(value = "/deactivated-student-management", method = RequestMethod.GET)
	public String deactivatedStudent(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		List<Student> sList = studentJDBC.getAll2();
		model.addAttribute("sList", sList);
		return "deactivatedstudentmanagement";
	}
	@RequestMapping(value = "/deactivated-student-management/{id}", method = RequestMethod.GET)
	public String deactivatedstudentprocess(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		int deacti = studentJDBC.deactivateStudentById(id);
		if (deacti == 1) {
			redirectAtt.addFlashAttribute("success", "Ngưng hoạt động tài khoản thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Ngưng hoạt động tài khoản thất bại!");
		}
		return "redirect:/student-management";
	}
	@RequestMapping(value = "/reactive-student/{id}", method = RequestMethod.GET)
	public String reactivestudent(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		int reactive = studentJDBC.reactiveStudentById(id);
		if (reactive == 1) {
			redirectAtt.addFlashAttribute("success", "Khôi phục tài khoản thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Khôi phục tài khoản thất bại!");
		}
		return "redirect:/deactivated-student-management";
	}
	@RequestMapping(value = "/reset-password/{id}", method = RequestMethod.GET)
	public String resetPassword(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		int reset = studentJDBC.resetPasswordById(id);
		if (reset == 1) {
			redirectAtt.addFlashAttribute("success", "Khôi phục mật khẩu thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Khôi phục mật khẩu thất bại!");
		}
		return "redirect:/student-management";
	}
	@RequestMapping(value = "/add-student", method = RequestMethod.GET)
	public String addstudent(ModelMap model, HttpServletRequest request) {
		return "addstudent";
	}
	
	@RequestMapping(value = "/edit-student/{id}", method = RequestMethod.GET)
	public String editstudent(ModelMap model, HttpServletRequest request, @PathVariable int id) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		Student st = studentJDBC.getStudentById(id);
		model.addAttribute("student", st);
		return "editstudent";
	}
}
