package com.model;

import org.joda.time.DateTime;

public class Order {
	int id;
	int studentId;
	int staffId;
	DateTime datePurchase;
	DateTime dateExpire;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public DateTime getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(DateTime datePurchase) {
		this.datePurchase = datePurchase;
	}
	public DateTime getDateExpire() {
		return dateExpire;
	}
	public void setDateExpire(DateTime dateExpire) {
		this.dateExpire = dateExpire;
	}
	public Order(int id, int studentId, int staffId, DateTime datePurchase, DateTime dateExpire) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.staffId = staffId;
		this.datePurchase = datePurchase;
		this.dateExpire = dateExpire;
	}
	public Order(){}
}
