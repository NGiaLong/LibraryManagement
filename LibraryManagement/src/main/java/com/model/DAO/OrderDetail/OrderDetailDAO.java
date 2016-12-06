package com.model.DAO.OrderDetail;

import java.util.List;

import com.model.OrderDetail;

public interface OrderDetailDAO {
	List<OrderDetail> getDetailByOrderId(int orderId);
	int deleteDetailByOrderId(int orderId);
}
