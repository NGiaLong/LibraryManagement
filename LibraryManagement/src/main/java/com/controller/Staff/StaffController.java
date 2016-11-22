package com.controller.Staff;

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
import com.model.DAO.Staff.StaffJDBC;

@Controller
public class StaffController {
	private ApplicationContext context;

	@ModelAttribute("editStaffBean")
	public EditStaffBean editStaffBean() {
		return new EditStaffBean();
	}

	@ModelAttribute("createStaffBean")
	public CreateStaffBean createStaffBean() {
		return new CreateStaffBean();
	}

	@RequestMapping(value = "/staff-management", method = RequestMethod.GET)
	public String staffmanagement(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		List<Staff> sList = staffJDBC.getAll();
		model.addAttribute("sList", sList);
		return "staffmanagement";
	}

	@RequestMapping(value = "/deactivated-staff-management", method = RequestMethod.GET)
	public String deactivatedstaff(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		List<Staff> sList = staffJDBC.getAll2();
		model.addAttribute("sList", sList);
		return "deactivatedstaffmanagement";
	}

	@RequestMapping(value = "/deactivated-staff-management/{id}", method = RequestMethod.GET)
	public String deactivatedstaffprocess(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		int deacti = staffJDBC.deactivateStaffById(id);
		if (deacti == 1) {
			redirectAtt.addFlashAttribute("success", "Ngưng hoạt động tài khoản thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Ngưng hoạt động tài khoản thất bại!");
		}
		return "redirect:/staff-management";
	}

	@RequestMapping(value = "/reactive-staff/{id}", method = RequestMethod.GET)
	public String reactivestaff(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		int reactive = staffJDBC.reactiveStaffById(id);
		if (reactive == 1) {
			redirectAtt.addFlashAttribute("success", "Khôi phục tài khoản thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Khôi phục tài khoản thất bại!");
		}
		return "redirect:/deactivated-staff-management";
	}

	@RequestMapping(value = "/reset-staff-password/{id}", method = RequestMethod.GET)
	public String resetPassword(ModelMap model, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		int reset = staffJDBC.resetPasswordById(id);
		if (reset == 1) {
			redirectAtt.addFlashAttribute("success", "Khôi phục mật khẩu thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Khôi phục mật khẩu thất bại!");
		}
		return "redirect:/staff-management";
	}

	@RequestMapping(value = "/add-staff", method = RequestMethod.GET)
	public String addstaff(ModelMap model, HttpServletRequest request) {
		return "addstaff";
	}

	@RequestMapping(value = "/add-staff", method = RequestMethod.POST)
	public String addstaffProcess(@ModelAttribute("SpringWeb") CreateStaffBean createStaffBean, ModelMap model,
			HttpServletRequest request, RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		int createStaff = staffJDBC.addNewStaff(
				new Staff(createStaffBean.getName(), createStaffBean.getDateOfBirth(), createStaffBean.isGender(),
						createStaffBean.getEmail(), createStaffBean.getAddress(), createStaffBean.getPhone()));
		if (createStaff == 1) {
			redirectAtt.addFlashAttribute("success", "Tạo nhân viên thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Tạo nhân viên thất bại!");
		}
		return "redirect:/staff-management";
	}

	@RequestMapping(value = "/edit-staff/{id}", method = RequestMethod.GET)
	public String editstaff(ModelMap model, HttpServletRequest request, @PathVariable int id) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		Staff st = staffJDBC.getStaffById(id);
		model.addAttribute("staff", st);
		return "editstaff";
	}

	@RequestMapping(value = "/edit-staff/{id}", method = RequestMethod.POST)
	public String editstaffProcess(@ModelAttribute("SpringWeb") EditStaffBean editStaffBean, ModelMap model,
			HttpServletRequest request, @PathVariable int id, RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StaffJDBC staffJDBC = (StaffJDBC) context.getBean("staffJDBC");
		int editStaff = staffJDBC.editStaffById(id,
				new Staff(editStaffBean.getName(), editStaffBean.getDateOfBirth(), editStaffBean.isGender(),
						editStaffBean.getEmail(), editStaffBean.getAddress(), editStaffBean.getPhone()));
		if (editStaff == 1) {
			redirectAtt.addFlashAttribute("success", "Sửa nhân viên thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Sửa nhân viên thất bại!");
		}
		return "redirect:/staff-management";
	}

}
