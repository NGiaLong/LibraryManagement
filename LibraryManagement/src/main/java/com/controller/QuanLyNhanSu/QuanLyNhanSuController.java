package com.controller.QuanLyNhanSu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.group.BO.PhanQuyen.PhanQuyenBO;
//import com.group.model.NhanVien;
//import com.group.model.DAO.NhanVien.NhanVienJDBC;

@Controller
public class QuanLyNhanSuController {
	private ApplicationContext context;
	@RequestMapping(value = "/quan-ly-nhan-vien", method = RequestMethod.GET)
	public String quanLyNhanVien(ModelMap model, HttpServletRequest request) {
//		PhanQuyenBO pqBo = new PhanQuyenBO();
//		int roleID = Integer.parseInt(request.getSession().getAttribute("roleID").toString());
//		if (!pqBo.checkPermission(roleID, 4)) {
//			model.addAttribute("mess", "Bạn không có quyền truy cập chức năng này");
//			return "khongcoquyen";
//		}
		context = new ClassPathXmlApplicationContext("Beans.xml");
//		NhanVienJDBC nvJDBC = (NhanVienJDBC) context.getBean("nhanVienJDBC");
//		List<NhanVien> nvList = nvJDBC.getAll();
//		model.addAttribute("role", roleID);
//		model.addAttribute("maNV", ((String) request.getSession().getAttribute("maNhanVien")).trim());
//		model.addAttribute("nvList", nvList);
		return "quanlynhanvien";

	}
}
