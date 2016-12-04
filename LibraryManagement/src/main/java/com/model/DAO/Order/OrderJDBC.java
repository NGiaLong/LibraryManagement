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
}
