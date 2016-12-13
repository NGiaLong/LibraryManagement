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
	
	@Override
	public OrderDetail getDetailById(int id) {
		String sql = "SELECT dt.Id, dt.OrderId, dt.BookId, b.Title, b.Author,dt.DatePaid, dt.Status "
				+ "FROM OrderDetails dt, Books b WHERE dt.BookId = b.Id AND dt.Id = "+id;
		try {
			OrderDetail detailList = jdbcTemplateObject.queryForObject(sql, new OrderDetailMapper());
			return detailList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int deleteDetailByOrderId(int orderId) {
		String sql = "DELETE FROM OrderDetails WHERE OrderId = ?";
		return jdbcTemplateObject.update(sql, new Object[] {orderId});
	}
	
	@Override
	public int deleteDetailById(int id) {
		String sql = "DELETE FROM OrderDetails WHERE Id = ?";
		try {
			return jdbcTemplateObject.update(sql, new Object[] {id});
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	@Override

	public int addDetailByOBId(int orderId, int bookId){
		String sql = "insert into OrderDetails( OrderId , BookId, Status) values (?,?,0 )";
		String sql2 = "update Books set Status = '0' where Id = ?";
		try {
			 jdbcTemplateObject.update(sql2, new Object[]{bookId});
			return jdbcTemplateObject.update(sql, new Object[] {orderId, bookId});
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<OrderDetail> getListByBookId(int bookId) {
		String sql = "SELECT dt.Id, dt.OrderId, dt.BookId, b.Title, b.Author,dt.DatePaid, dt.Status "
				+ "FROM OrderDetails dt, Books b WHERE dt.BookId = b.Id AND dt.BookId = "+bookId;
		try {
			List<OrderDetail> detailList = jdbcTemplateObject.query(sql, new OrderDetailMapper());
			return detailList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int updateDetail(int orderId) {
		String sql = "UPDATE OrderDetails SET Status = 1,DatePaid = GETDATE() WHERE OrderId = ?";
		try {
			return jdbcTemplateObject.update(sql, new Object[] {orderId});
		} catch (Exception e) {
			return 0;
		}
	}

}
