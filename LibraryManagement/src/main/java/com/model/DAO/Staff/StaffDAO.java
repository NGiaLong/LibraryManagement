package com.model.DAO.Staff;

import java.util.List;

import com.model.Staff;

public interface StaffDAO {

	public List<Staff> getAll();

	public List<Staff> getAll2();

	public int addNewStaff(Staff staff);
	
	public Staff getStaffById(int id);

	public int deactivateStaffById(int id);
	
	public int reactiveStaffById(int id);

	public int editStaffById(int id);
	
	public int resetPasswordById(int id);
}
