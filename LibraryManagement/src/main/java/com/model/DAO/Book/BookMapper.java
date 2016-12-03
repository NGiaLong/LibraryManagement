package com.model.DAO.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Book;

public class BookMapper implements RowMapper<Book>{
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException{
		Book book = new Book();
		book.setId(rs.getInt(1));
		book.setTitle(rs.getString(2));
		book.setDescription(rs.getString(3));
		book.setAuthor(rs.getString(4));
		book.setEdition(rs.getInt(5));
		book.setPublisher(rs.getString(6));
		book.setCategoryId(rs.getInt(7));
		book.setCategoryName(rs.getString(8));
		book.setStatus(rs.getBoolean(9));
		return book;
	}
}
