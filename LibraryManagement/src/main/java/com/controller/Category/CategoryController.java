package com.controller.Category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Category;
import com.model.DAO.Category.CategoryJDBC;

@Controller
@RequestMapping(value = "/Category")
public class CategoryController {
	private ApplicationContext context;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCategories(ModelMap model, HttpServletRequest request){
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		List<Category> listCategory = categoryJDBC.getAll();
		model.addAttribute("listCategory", listCategory);
		return "indexCategory";
	}
}
