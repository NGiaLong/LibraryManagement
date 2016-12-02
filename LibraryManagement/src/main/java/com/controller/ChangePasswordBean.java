package com.controller;

public class ChangePasswordBean {
	private String oldPassword;
	private String newPassword;
	private String reNewPassword;
	public final String getOldPassword() {
		return oldPassword;
	}
	public final void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public final String getNewPassword() {
		return newPassword;
	}
	public final void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public final String getReNewPassword() {
		return reNewPassword;
	}
	public final void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	public ChangePasswordBean(String oldPassword, String newPassword, String reNewPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.reNewPassword = reNewPassword;
	}
	public ChangePasswordBean() {
		super();
	}
	
}
