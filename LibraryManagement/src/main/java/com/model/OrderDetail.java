package com.model;

import org.joda.time.DateTime;

public class OrderDetail {
	int id;
	int orderId;
	int bookId;
	DateTime datePaid;
	boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public DateTime getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(DateTime datePaid) {
		this.datePaid = datePaid;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public OrderDetail(int id, int orderId, int bookId, DateTime datePaid, boolean status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookId = bookId;
		this.datePaid = datePaid;
		this.status = status;
	}
	public OrderDetail(){}
}
