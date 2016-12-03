package com.model;

public class Order {
	private int id;
	private int studentId;
	private String studentName;
	private String staffName;
	private int staffId;
	private String datePurchase;
	private String dateExpire;
	private boolean status;
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
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(String datePurchase) {
		this.datePurchase = datePurchase;
	}
	public String getDateExpire() {
		return dateExpire;
	}
	public void setDateExpire(String dateExpire) {
		this.dateExpire = dateExpire;
	}
	
	public final boolean isStatus() {
		return status;
	}
	public final void setStatus(boolean status) {
		this.status = status;
	}
	public Order(int id, int studentId, int staffId, String datePurchase, String dateExpire) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.staffId = staffId;
		this.datePurchase = datePurchase;
		this.dateExpire = dateExpire;
	}
	
	public Order(int id, String studentName, String staffName, String datePurchase, String dateExpire) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.staffName = staffName;
		this.datePurchase = datePurchase;
		this.dateExpire = dateExpire;
	}
	
	public Order(int id, int studentId, String studentName, String staffName, int staffId, String datePurchase,
			String dateExpire) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.studentName = studentName;
		this.staffName = staffName;
		this.staffId = staffId;
		this.datePurchase = datePurchase;
		this.dateExpire = dateExpire;
	}
	public Order(){}
}
