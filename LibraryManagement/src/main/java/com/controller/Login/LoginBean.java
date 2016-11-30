package com.controller.Login;

public class LoginBean {
	private String email;
	private String password;
	
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
	public LoginBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public LoginBean() {
		super();
	}
	
	
}
