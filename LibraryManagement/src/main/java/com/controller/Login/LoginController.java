package com.controller.Login;

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
public class LoginController {
	private ApplicationContext context;

	@ModelAttribute("loginBean")
	public LoginBean loginBean() {
		return new LoginBean();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView(ModelMap model, HttpServletRequest request) {
		try {
			int roleSession =  (int) request.getSession().getAttribute("roleSession");		
			if (roleSession != 0) {
				return "redirect:/index";
			}
		} catch (Exception e) {
			return "login";
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("SpringWeb") LoginBean loginBean, ModelMap model,
			HttpServletRequest request, RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		int role = loginBean.getRole();
		String email = loginBean.getEmail();
		String password = loginBean.getPassword();
		if (role == 1) {
			StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
			Staff staff = staffJDBC.getStaffByEmail(email);
			if (staff == null) {
				model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
				return "login";
			}
			if (password.equals(staff.getPassword())) {
				if (!staff.isStatus()) {
					model.addAttribute("error", "Tài khoản này đang bị khóa");
					return "login";
				} else {
					request.getSession().setAttribute("staffSession", staff);
					request.getSession().setAttribute("roleSession", 1);
					redirectAtt.addFlashAttribute("success", "Đăng nhập thành công!");
					return "redirect:/index";
				}
			}
		} else if (role == 2){
			StudentJDBC studentJDBC = (StudentJDBC) context.getBean("studentJDBC");
			Student student = studentJDBC.getStudentByEmail(email);
			if (student == null) {
				model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
				return "login";
			}
			if (password.equals(student.getPassword())) {
				if (!student.isStatus()) {
					model.addAttribute("error", "Tài khoản này đang bị khóa");
					return "login";
				} else {
					request.getSession().setAttribute("studentSession", student);
					request.getSession().setAttribute("roleSession", 2);
					redirectAtt.addFlashAttribute("success", "Đăng nhập thành công!");
					return "redirect:/index";
				}
			}
		}

		return "login";
	}
}
