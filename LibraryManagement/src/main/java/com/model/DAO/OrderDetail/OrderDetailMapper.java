package com.model.DAO.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.model.OrderDetail;

public class OrderDetailMapper implements RowMapper<OrderDetail>{
	public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException{
		OrderDetail detail = new OrderDetail();
		detail.setId(rs.getInt(1));
		detail.setOrderId(rs.getInt(2));
		detail.setBookId(rs.getInt(3));
		detail.setBookTitle(rs.getString(4));
		detail.setBookAuthor(rs.getString(5));
		detail.setDatePaid(rs.getDate(6));
		return detail;
	}
}
