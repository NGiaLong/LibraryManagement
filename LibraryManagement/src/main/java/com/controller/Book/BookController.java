package com.controller.Book;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Book;
import com.model.Category;
import com.model.DAO.Book.BookJDBC;
import com.model.DAO.Category.CategoryJDBC;
import com.model.DAO.OrderDetail.OrderDetailJDBC;
import com.opencsv.CSVReader;

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
	
	@RequestMapping(value = "/uploadExcel", method = RequestMethod.GET)
	public String upload(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryJDBC categoryJDBC = (CategoryJDBC) context.getBean("categoryJDBC");
		List<Category> categoryList = categoryJDBC.getAll();
		model.addAttribute("categoryList", categoryList);
		return "uploadExcel";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET )
	public String deleteBook(@PathVariable int id, ModelMap model, HttpServletRequest request,
			RedirectAttributes redirectAtt){		
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		Book book = bookJDBC.getOne(id);
		OrderDetailJDBC detailJDBC = (OrderDetailJDBC) context.getBean("orderDetailJDBC");
		if(detailJDBC.getListByBookId(id).size()>0){
			redirectAtt.addFlashAttribute("error", "Không thể xóa sách khi đã cho thuê!");
			return "redirect:/Book";
		}
		model.addAttribute("book", book);
		return "deleteBook";		
	}
	
	@RequestMapping(value = "/postDelete", method = RequestMethod.POST)
	public String postDeleteBook(ModelMap model, HttpServletRequest request,
			RedirectAttributes redirectAtt) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		int deleteBook = bookJDBC.deleteBook(Integer.parseInt(request.getParameter("id")));
		if (deleteBook == 1) {
			redirectAtt.addFlashAttribute("success", "Xóa sách thành công!");
		} else {
			redirectAtt.addFlashAttribute("error", "Xóa sách thất bại!");
		}
		return "redirect:/Book";
	}
	
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)	
	public String uploadFile(ModelMap model,@RequestParam MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAtt) {	 
	    if (file.isEmpty()) {
	        model.put("error", "failed to upload file because its empty");
	        return "redirect:/Book/uploadExcel";
	    }
	    String rootPath = request.getSession().getServletContext().getRealPath("/");
	    File dir = new File(rootPath + File.separator + "uploadedfile");
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	    File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());	 
	    try {
	        try (InputStream is = file.getInputStream();
	                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
	            int i;
	            //write file to server
	            while ((i = is.read()) != -1) {
	                stream.write(i);
	            }
	            stream.flush();
	        }
	    } catch (IOException e) {
	        model.put("error", "failed to process file because : " + e.getMessage());
	        return "redirect:/Book/uploadExcel";
	    }
	 
	    String[] nextLine;
	    try {
	        //read file
	        //CSVReader(fileReader, ';', '\'', 1) means
	        //using separator ; and using single quote ' . Skip first line when read
	    	BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
	        try (FileReader fileReader = new FileReader(serverFile);
	            CSVReader reader = new CSVReader(fileReader, ';', '\'', 1);) {
	            while ((nextLine = reader.readNext()) != null) {	                
	                for(int i=0;i<nextLine.length;i++){
	                    Book book = new Book();
	                    book.setTitle(nextLine[i].split(",")[0]);
	                    book.setDescription("");
	                    book.setAuthor(nextLine[i].split(",")[1]);
	                    book.setEdition(Integer.parseInt(nextLine[i].split(",")[2]));
	                    book.setPublisher(nextLine[i].split(",")[3]);
	                    book.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
	                    book.setStatus(true);
	                	bookJDBC.addBook(book);
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("error while reading csv and put to db : " + e.getMessage());
	    } 
	 
	    model.put("success", "success upload and process file");
	    return "redirect:/Book";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/remain")
	public String getRemainBooks(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BookJDBC bookJDBC = (BookJDBC) context.getBean("bookJDBC");
		List<Book> listBook = bookJDBC.getRemain();
		model.addAttribute("listBook", listBook);
		return "remainBook";
	}
}
