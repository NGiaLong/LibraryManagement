package com.model.DAO.Order;

import java.util.List;

import com.model.Order;

public interface OrderDAO {
	public List<Order> getAll(); 
	public List<Order> getExpired();
	public Order getOne(int id);
	public int deleteOne(int id);
	public int updateStatus(int id);
}
