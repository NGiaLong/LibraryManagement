package com.model.DAO.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Order;
import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order> {
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException{
		Order order = new Order();
		order.setId(rs.getInt(1));
		order.setStudentId(rs.getInt(2));
		order.setStudentName(rs.getString(3));
		order.setStaffName(rs.getString(4));
		order.setStaffId(rs.getInt(5));
		order.setDatePurchase(rs.getString(6));
		order.setDateExpire(rs.getString(7));
		order.setStatus(rs.getBoolean(9));
		return order;
	}
	
}
