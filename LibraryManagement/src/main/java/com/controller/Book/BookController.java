package com.controller.Book;

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

import com.model.Book;
import com.model.Category;
import com.model.DAO.Book.BookJDBC;
import com.model.DAO.Category.CategoryJDBC;

@Controller
@RequestMapping(value ="/Book")
public class BookController {
	private ApplicationContext context;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String getBooks(ModelMap model, HttpServletRequest request){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		List<Book> listBook = bookJDBC.getAll();		
		model.addAttribute("listBook", listBook);
		return "indexBook";
	}
	
	@ModelAttribute("createBookBean")
	public CreateBookBean createBookBean() {
		return new CreateBookBean();
	}
	
	@ModelAttribute("editBookBean")
	public EditBookBean editBookBean() {
		return new EditBookBean();
	}
	
	@RequestMapping(value="/add", method =  RequestMethod.GET)
	public String addBook(ModelMap model, HttpServletRequest request){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		List<Category> listCategory = categoryJDBC.getAll();
		model.addAttribute("listCategory",listCategory);
		return "addBook";
	}
	
	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
	public String editBook(@PathVariable int id, ModelMap model){
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		Book book = bookJDBC.getOne(id);
		model.addAttribute("book",book);
		return "editBook";
	}
	
}
