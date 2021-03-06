package com.controller.Category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Category;
import com.model.DAO.Book.BookJDBC;
import com.model.DAO.Category.CategoryJDBC;

@Controller
@RequestMapping(value = "/Category")
public class CategoryController {
	private ApplicationContext context;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String getCategories(ModelMap model, HttpServletRequest request){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		List<Category> listCategory = categoryJDBC.getAll();
		model.addAttribute("listCategory", listCategory);
		return "indexCategory";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String addCategory(){
		return "addCategory";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/postAdd")
	public String postAddCategory(ModelMap model, RedirectAttributes redirectAtt, HttpServletRequest request){
		String cateName = request.getParameter("name");
		Category category = new Category();
		category.setName(cateName);
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		int result = categoryJDBC.addCategory(category);
		if (result == 1) {
			redirectAtt.addFlashAttribute("success", "Thêm mới thể loại thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Thêm mới thể loại thất bại");
		}
		return "redirect:/Category";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit/{categoryId}")
	public String editCategory(@PathVariable String categoryId, ModelMap model){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		Category category = categoryJDBC.getOne(Integer.parseInt(categoryId));
		model.addAttribute(category);
		return "editCategory";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/postEdit")
	public String postEditCategory(ModelMap model, RedirectAttributes redirectAtt, HttpServletRequest request){		
		Category category = new Category();
		category.setId(Integer.parseInt(request.getParameter("id")));
		category.setName(request.getParameter("name"));
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		int result = categoryJDBC.updateCategory(category);
		if (result == 1) {
			redirectAtt.addFlashAttribute("success", "Chỉnh sửa thể loại thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Chỉnh sửa thể loại thất bại");
		}
		return "redirect:/Category";
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete/{categoryId}")
	public String deleteCategory(@PathVariable String categoryId, RedirectAttributes redirectAtt, ModelMap model){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");		
		if(bookJDBC.findByCategoryId(Integer.parseInt(categoryId))==null){
			redirectAtt.addFlashAttribute("error", "Thể loại này không thể xóa do còn sách tồn tại");
			return "redirect:/Category";
		} else {
			Category category = categoryJDBC.getOne(Integer.parseInt(categoryId));
			model.addAttribute(category);
			return "deleteCategory";
		}		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/postDelete")
	public String postDeleteCategory(ModelMap model, RedirectAttributes redirectAtt, HttpServletRequest request){				
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		int result = categoryJDBC.deleteCategory(Integer.parseInt(request.getParameter("id")));
		if (result == 1) {
			redirectAtt.addFlashAttribute("success", "Xóa thể loại thành công");
		} else {
			redirectAtt.addFlashAttribute("error", "Xóa thể loại thất bại");
		}
		return "redirect:/Category";
	}
}
