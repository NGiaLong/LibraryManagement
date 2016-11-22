package com.model.DAO.Book;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Book;

public class BookJDBC implements BookDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Book> getAll() {
		String sql = "SELECT b.Id,b.Title,b.Description, b.Author,b.Edition, b.Publisher,c.Id,c.Name,b.Status FROM Books b, Categories c WHERE b.CategoryId = c.Id";
		try {
			List<Book> listBook = jdbcTemplateObject.query(sql, new BookMapper());			
			return listBook;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Book getOne(int bookId) {
		String sql = "SELECT b.Id,b.Title,b.Description, b.Author,b.Edition, b.Publisher,c.Id,c.Name,b.Status FROM Books b, Categories c WHERE b.CategoryId = c.Id AND b.Id = ?";
		Book book = (Book) jdbcTemplateObject.queryForObject(sql, new Object[] { bookId }, new BookMapper());
		return book;
	}

	@Override
	public int updateBook(Book book) {
		String SQL = "update Books set Title = ?,Description = ?,Author = ?,Edition = ?,Publisher = ?,CategoryId = ?,Status = ? WHERE  Id =? ";
		return jdbcTemplateObject.update(SQL, new Object[] { book.getTitle(), book.getDescription(), book.getAuthor(),
				book.getEdition(), book.getPublisher(), book.getCategoryId(), book.isStatus(), book.getId() });
	}

	@Override
	public int deleteBook(int bookId) {
		String SQL = "delete from Books where Id = ?";
		return jdbcTemplateObject.update(SQL, new Object[] { bookId });
	}

	@Override
	public int addBook(Book book) {
		String SQL = "INSERT INTO Categories VALUES (?,?,?,?,?,?,?)";
		return jdbcTemplateObject.update(SQL, new Object[] { book.getTitle(), book.getDescription(), book.getAuthor(),
				book.getEdition(), book.getPublisher(), book.getCategoryId(), book.isStatus() });
	}

}
