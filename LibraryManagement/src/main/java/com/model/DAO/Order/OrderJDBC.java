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
		String sql = "select * from dbo.V_Order order by Status asc, DateExpire asc";
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
}
