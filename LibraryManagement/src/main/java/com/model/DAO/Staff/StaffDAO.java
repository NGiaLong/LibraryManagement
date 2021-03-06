package com.model.DAO.Staff;

import java.util.List;

import com.model.Staff;

public interface StaffDAO {

	public List<Staff> getAll();
	
	public List<Staff> getAll1();

	public List<Staff> getAll2();

	public int addNewStaff(Staff staff);

	public Staff getStaffById(int id);
	
	public Staff getStaffByEmail(String email);

	public int deactivateStaffById(int id);

	public int reactiveStaffById(int id);

	public int editStaffById(int id, Staff staff);

	public int resetPasswordById(int id);
	
	public String getPasswordById(int id);
	
	public int setPasswordById(int id, String pass);
}
