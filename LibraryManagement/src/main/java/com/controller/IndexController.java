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
import com.model.DAO.Staff.StaffJDBC;

@Controller
public class IndexController {
	private ApplicationContext context;
	@ModelAttribute("perInfor")
	public PersionalInformationBean perInfor(){
		return new PersionalInformationBean();
	}
	@ModelAttribute("changePass")
	public ChangePasswordBean changePass(){
		return new ChangePasswordBean();
	}
	@RequestMapping(value = "/thongtincanhan", method = RequestMethod.GET)
	public String getIndex() {

		return "personalinformation";
	}
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("SpringWeb") ChangePasswordBean changePass, HttpServletRequest request, ModelMap model,RedirectAttributes redirectAttrs) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		int status = 0;
		Staff staff = (Staff) request.getSession().getAttribute("staffSession");
		int id = staff.getId();
		String oldPassRight = staff.getPassword();
		System.out.println("Mật khẩu cũ :"+ oldPassRight +" với id: "+ id);
		if(oldPassRight.equals(changePass.getOldPassword())){
			if(changePass.getNewPassword().equals(changePass.getReNewPassword())){
				status = staffJDBC.setPasswordById(id, changePass.getNewPassword());
				Staff newStaff = (Staff) staffJDBC.getStaffById(id);
				request.getSession().setAttribute("staffSession", newStaff);
			}else{
				status = 2;
			}
		}else{
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
