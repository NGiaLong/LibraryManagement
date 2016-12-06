package com.model.DAO.OrderDetail;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.OrderDetail;

public class OrderDetailJDBC implements OrderDetailDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<OrderDetail> getDetailByOrderId(int orderId) {
		String sql = "SELECT dt.Id, dt.OrderId, dt.BookId, b.Title, b.Author,dt.DatePaid, dt.Status "
				+ "FROM OrderDetails dt, Books b WHERE dt.BookId = b.Id AND dt.OrderId = "+orderId;
		try {
			List<OrderDetail> detailList = jdbcTemplateObject.query(sql, new OrderDetailMapper());
			return detailList;
		} catch (Exception e) {
			return null;
		}
	}

}
