package com.controller.Login;

public class LoginBean {
	private int role;
	private String email;
	private String password;
	
	public final int getRole() {
		return role;
	}
	public final void setRole(int role) {
		this.role = role;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginBean(int role, String email, String password) {
		super();
		this.role = role;
		this.email = email;
		this.password = password;
	}
	public LoginBean() {
		super();
	}
	
	
}
