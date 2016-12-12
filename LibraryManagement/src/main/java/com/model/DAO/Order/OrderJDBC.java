package com.model.DAO.Order;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Order;

public class OrderJDBC implements OrderDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<Order> getAll(){
		String sql = "SELECT o.Id, st.Id, st.Name, sta.Name, sta.Id, o.DatePurchase, o.DateExpire, o.Status "
				+ "FROM Orders o, Students st, Staffs sta where o.StaffId = sta.Id AND o.StudentId = st.Id AND "
				+ "o.DateExpire > GETDATE() AND o.Status=0";
		try {
			List<Order> listOrder = jdbcTemplateObject.query(sql, new OrderMapper());
			return listOrder;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Order> getExpired() {
		String sql = "SELECT o.Id, st.Id, st.Name, sta.Name, sta.Id, o.DatePurchase, o.DateExpire, o.Status"
				+ " FROM Orders o, Students st, Staffs sta where o.StaffId = sta.Id AND o.StudentId = st.Id "
				+ "AND o.DateExpire < GETDATE() AND o.Status=0"; 
		try {
			List<Order> listOrder = jdbcTemplateObject.query(sql, new OrderMapper());
			return listOrder;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Order getOne(int id) {
		String sql = "SELECT o.Id, st.Id, st.Name, sta.Name, sta.Id, o.DatePurchase, o.DateExpire, o.Status"
				+ " FROM Orders o, Students st, Staffs sta where o.StaffId = sta.Id AND o.StudentId = st.Id AND o.Id = "+id;
		try {
			Order order = jdbcTemplateObject.queryForObject(sql, new OrderMapper());
			return order;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int deleteOne(int id) {
		String sql = "DELETE FROM Orders WHERE Id = ?";
		return jdbcTemplateObject.update(sql, new Object[] {id});
	}

	@Override
	public int updateStatus(int id) {
		String sql = "UPDATE Orders SET Status = 1 WHERE Id = ?";
		return jdbcTemplateObject.update(sql, new Object[] {id});
	}
	@Override
	public int addOrder(int stuId, int staId){
		String sql = "insert into Orders (StudentId, StaffId, DatePurchase, DateExpire, Status)"
				+ "values (?,?,getdate(),DATEADD(dd, 90, getdate()),0)";
		try {
			return jdbcTemplateObject.update(sql, new Object[]{stuId, staId});
		} catch (Exception e) {
			return 0;
		}
	}
	@Override
	public Order getLastOrder(){
		String sql = "select top 1 o.Id, st.Id, st.Name, sta.Name, sta.Id, o.DatePurchase, o.DateExpire, o.Status "
				+ "FROM Orders o, Students st, Staffs sta where o.StaffId = sta.Id AND o.StudentId = st.Id order by o.Id desc";
		try {
			Order order = jdbcTemplateObject.queryForObject(sql, new OrderMapper());
			return order;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Order> getBorrowedByUserId(int userId) {
		String sql = "SELECT o.Id, st.Id, st.Name, sta.Name, sta.Id, o.DatePurchase, o.DateExpire, o.Status "
				+ "FROM Orders o, Students st, Staffs sta where o.StaffId = sta.Id AND o.StudentId = st.Id AND "
				+ "o.Status=0 AND o.StudentId = " + userId;
		try {
			List<Order> listOrder = jdbcTemplateObject.query(sql, new OrderMapper());
			return listOrder;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Order> getHistoryByUserId(int userId) {
		String sql = "SELECT o.Id, st.Id, st.Name, sta.Name, sta.Id, o.DatePurchase, o.DateExpire, o.Status "
				+ "FROM Orders o, Students st, Staffs sta where o.StaffId = sta.Id AND o.StudentId = st.Id AND o.StudentId = " + userId;
		try {
			List<Order> listOrder = jdbcTemplateObject.query(sql, new OrderMapper());
			return listOrder;
		} catch (Exception e) {
			return null;
		}
	}
}
