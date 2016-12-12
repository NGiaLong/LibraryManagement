package com.model.DAO.Book;

import java.util.List;

import com.model.Book;

public interface BookDAO {
	public List<Book> getAll();
	public Book getOne(int bookId);
	public int updateBook(Book book);
	public int deleteBook(int bookId);
	public int addBook(Book book);
	public int updateStatus(int bookId);
	public List<Book> findByCategoryId(int categoryId);
}
