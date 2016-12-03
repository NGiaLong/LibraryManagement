package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Staff;
import com.model.Student;
import com.model.DAO.Staff.StaffJDBC;
import com.model.DAO.Student.StudentJDBC;

@Controller
public class IndexController {
	private ApplicationContext context;

	@ModelAttribute("perInfor")
	public PersionalInformationBean perInfor() {
		return new PersionalInformationBean();
	}

	@ModelAttribute("changePass")
	public ChangePasswordBean changePass() {
		return new ChangePasswordBean();
	}

	@RequestMapping(value = "/thongtincanhan", method = RequestMethod.GET)
	public String getIndex() {
		return "personalinformation";
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("SpringWeb") ChangePasswordBean changePass, HttpServletRequest request,
			ModelMap model, RedirectAttributes redirectAttrs) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
		int status = 0;
		String oldPassRight = "";
		int id = 0;
		if ((int) request.getSession().getAttribute("roleSession") == 1) {
			Staff staff = (Staff) request.getSession().getAttribute("staffSession");
			id = staff.getId();
			oldPassRight = staff.getPassword();
		}
		if ((int) request.getSession().getAttribute("roleSession") == 2) {
			Student student = (Student) request.getSession().getAttribute("studentSession");
			id = student.getId();
			oldPassRight = student.getPassword();
		}
		if (oldPassRight.equals(changePass.getOldPassword())) {
			if (changePass.getNewPassword().equals(changePass.getReNewPassword())) {
				if ((int) request.getSession().getAttribute("roleSession") == 1) {
					status = staffJDBC.setPasswordById(id, changePass.getNewPassword());
					Staff newStaff = (Staff) staffJDBC.getStaffById(id);
					request.getSession().setAttribute("staffSession", newStaff);
				} else if ((int) request.getSession().getAttribute("roleSession") == 2) {
					status = studentJDBC.setPasswordById(id, changePass.getNewPassword());
					Student newStudent = (Student) studentJDBC.getStudentById(id);
					request.getSession().setAttribute("studentSession", newStudent);
				}
			} else {
				status = 2;
			}
		} else {
			status = 3;
		}
		switch (status) {
		case 1:
			redirectAttrs.addFlashAttribute("success", "Đổi mật khẩu thành công");
			break;
		case 2:
			redirectAttrs.addFlashAttribute("error", "Mật khẩu mới nhập vào không trùng nhau");
			break;
		case 3:
			redirectAttrs.addFlashAttribute("error", "Mật khẩu cũ không đúng");
			break;

		default:
			redirectAttrs.addFlashAttribute("error", "Đổi mật khẩu thất bại");
			break;
		}
		return "redirect:/thongtincanhan";
	}
}
