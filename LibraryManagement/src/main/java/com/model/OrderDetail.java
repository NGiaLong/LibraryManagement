package com.model;

import java.util.Date;

public class OrderDetail {
	int id;
	int orderId;
	int bookId;
	String bookTitle;
	String bookAuthor;
	Date datePaid;
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
	public Date getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public OrderDetail(int id, int orderId, int bookId, Date datePaid, boolean status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookId = bookId;
		this.datePaid = datePaid;
		this.status = status;
	}
	public OrderDetail(){}
}
