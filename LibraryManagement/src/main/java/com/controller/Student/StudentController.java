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

import com.model.Staff;
import com.model.Student;
import com.model.Student;
import com.model.Student;
import com.model.DAO.Staff.StaffJDBC;
import com.model.DAO.Student.StudentJDBC;
import com.model.DAO.Student.StudentJDBC;
import com.model.DAO.Student.StudentJDBC;
import com.model.DAO.Student.StudentJDBC;
import com.model.DAO.Student.StudentJDBC;

@Controller
public class StudentController {
	private ApplicationContext context;

	@ModelAttribute("addStudentBean")
	public AddStudentBean addStudentBean() {
		return new AddStudentBean();
	}

	@ModelAttribute("editStudentBean")
	public EditStudentBean editStudentBean() {
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

	@RequestMapping(value = "/reset-student-password/{id}", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/delete-student/{stid}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable int stid, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		int delete = studentJDBC.deleteStudentById(stid);
		if (delete == 1) {
			redirectAttrs.addFlashAttribute("success", "Xóa đọc viên thành công!");
		} else {
			redirectAttrs.addFlashAttribute("error", "Xóa đọc viên thất bại!");
		}
		return "redirect:/deactivated-student-management";
	}

	@RequestMapping(value = "/add-student", method = RequestMethod.POST)
	public String addstudentProcess(@ModelAttribute("SpringWeb") AddStudentBean addStudentBean, ModelMap model,
			HttpServletRequest request, RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		List<Staff> staffs = staffJDBC.getAll1();
		List<Student> students = studentJDBC.getAll1();
		for (Staff staff : staffs) {
			if(staff.getEmail().equals(addStudentBean.getEmail())){
				redirectAtt.addFlashAttribute("error", "Email đã tồn tại!");
				return "redirect:/student-management";
			}
		}
		for (Student student : students) {
			if(student.getEmail().equals(addStudentBean.getEmail())){
				redirectAtt.addFlashAttribute("error", "Email đã tồn tại!");
				return "redirect:/student-management";
			}
		}
		int addStudent = studentJDBC.addNewStudent(
				new Student(addStudentBean.getName(), addStudentBean.getDateOfBirth(), addStudentBean.isGender(),
						addStudentBean.getEmail(), addStudentBean.getAddress(), addStudentBean.getPhone()));
		if (addStudent == 1) {
			redirectAtt.addFlashAttribute("success", "Tạo đọc viên thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Tạo đọc viên thất bại");
		}
		return "redirect:/student-management";
	}

	@RequestMapping(value = "/edit-student/{id}", method = RequestMethod.GET)
	public String editstudent(ModelMap model, HttpServletRequest request, @PathVariable int id) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		Student st = studentJDBC.getStudentById(id);
		model.addAttribute("student", st);
		return "editstudent";
	}

	@RequestMapping(value = "/edit-student/{id}", method = RequestMethod.POST)
	public String editstudentProcess(@ModelAttribute("SpringWeb") EditStudentBean editStudentBean, ModelMap model, HttpServletRequest request, @PathVariable int id, RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		List<Staff> staffs = staffJDBC.getAll1();
		List<Student> students = studentJDBC.getAll1();
		for (Staff staff : staffs) {
			if(staff.getEmail().equals(editStudentBean.getEmail())){
				redirectAtt.addFlashAttribute("error", "Email đã tồn tại!");
				return "redirect:/student-management";
			}
		}
		for (Student student : students) {
			if(student.getEmail().equals(editStudentBean.getEmail())){
				redirectAtt.addFlashAttribute("error", "Email đã tồn tại!");
				return "redirect:/student-management";
			}
		}
		int editStudent = studentJDBC.editStudentById(id, new Student(editStudentBean.getName(), editStudentBean.getDateOfBirth(), editStudentBean.isGender(), editStudentBean.getEmail(), editStudentBean.getAddress(), editStudentBean.getPhone()));
		if (editStudent == 1) {
			redirectAtt.addFlashAttribute("success", "Sửa đọc viên thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Sửa đọc viên thất bại");
		}
		return "redirect:/student-management";
	}
}
