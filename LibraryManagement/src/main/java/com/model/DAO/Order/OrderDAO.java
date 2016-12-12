package com.model.DAO.Order;

import java.util.List;

import com.model.Order;

public interface OrderDAO {
	public List<Order> getAll(); 
	public List<Order> getExpired();
	public Order getLastOrder();
	public Order getOne(int id);
	public int deleteOne(int id);
	public int updateStatus(int id);
	public int addOrder(int stuId, int staId);
	public List<Order> getBorrowedByUserId(int userId);
	public List<Order> getHistoryByUserId(int userId);
}
