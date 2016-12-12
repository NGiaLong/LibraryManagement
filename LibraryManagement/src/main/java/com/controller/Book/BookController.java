package com.controller.Book;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Book;
import com.model.Category;
import com.model.DAO.Book.BookJDBC;
import com.model.DAO.Category.CategoryJDBC;

@Controller
@RequestMapping(value = "/Book")
public class BookController {
	private ApplicationContext context;

	@RequestMapping(method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String getBooks(ModelMap model, HttpServletRequest request) {
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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		List<Category> listCategory = categoryJDBC.getAll();
		model.addAttribute("listCategory", listCategory);
		return "addBook";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable int id, ModelMap model) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		Book book = bookJDBC.getOne(id);
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		List<Category> listCategory = categoryJDBC.getAll();
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("book", book);
		return "editBook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAddBook(ModelMap model, HttpServletRequest request, RedirectAttributes redirectAtt,
			@ModelAttribute("SpringWeb") CreateBookBean bean) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		int addBook = bookJDBC.addBook(new Book(bean.getTitle(), bean.getDescription(), bean.getAuthor(),
				bean.getEdition(), bean.getPublisher(), bean.getCategoryId(), true));
		if (addBook == 1) {
			redirectAtt.addFlashAttribute("success", "Thêm mới sách thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Thêm mới sách thất bại!");
		}
		return "redirect:/Book";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String postEditBook(@PathVariable int id, ModelMap model, HttpServletRequest request,
			RedirectAttributes redirectAtt, @ModelAttribute("SpringWeb") EditBookBean bean) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		int editBook = bookJDBC.updateBook(new Book(bean.getId(), bean.getTitle(), bean.getDescription(),
				bean.getAuthor(), bean.getEdition(), bean.getPublisher(), bean.getCategoryId(), bean.isStatus()));
		if (editBook == 1) {
			redirectAtt.addFlashAttribute("success", "Chỉnh sửa sách thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Chỉnh sửa sách thất bại!");
		}
		return "redirect:/Book";
	}
	
	/*@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
		String filename = file.getOriginalFilename();

		try {
			byte barr[] = file.getBytes();
			OutputStream bout = new FileOutputStream(session.getServletContext().getRealPath()+ filename);

			bout.write(barr);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/Book";
	}*/
}
