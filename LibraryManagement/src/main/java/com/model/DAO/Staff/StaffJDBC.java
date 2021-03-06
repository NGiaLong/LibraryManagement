package com.model.DAO.Staff;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Staff;

public class StaffJDBC implements StaffDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Staff> getAll() {
		String sql = "select * from Staffs where status = '1'";
		try {
			List<Staff> staffList = jdbcTemplateObject.query(sql, new StaffMapper());
			return staffList;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Staff> getAll1(){
		String sql = "select * from Staffs";
		try {
			List<Staff> staffList = jdbcTemplateObject.query(sql, new StaffMapper());
			return staffList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Staff> getAll2() {
		String sql = "select * from Staffs where status = '0'";
		try {
			List<Staff> staffList = jdbcTemplateObject.query(sql, new StaffMapper());
			return staffList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addNewStaff(Staff staff) {
		String sql = "insert into Staffs ( Name, DateOfBirth, Gender, Email, Password, Address, Phone, Status)"
				+ "values(?,?,?,?,'123456',?,?,'1')";
		try {
			return jdbcTemplateObject.update(sql, new Object[] { staff.getName(), staff.getDateOfBirth(),
					staff.isGender(), staff.getEmail(), staff.getAddress(), staff.getPhone() });
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int deactivateStaffById(int id) {
		String sql = "update Staffs set Status = '0' where Id ='" + id + "'";
		return jdbcTemplateObject.update(sql);
	}

	@Override
	public int reactiveStaffById(int id) {
		String sql = "update Staffs set Status = '1' where Id ='" + id + "'";
		return jdbcTemplateObject.update(sql);
	}

	@Override
	public int editStaffById(int id, Staff staff) {
		String sql = "update Staffs set Name = ? , DateOfBirth = ? , Gender = ? , Email = ?  , Address = ? , Phone = ? where id = ?";
		try {
			return jdbcTemplateObject.update(sql, new Object[] { staff.getName(), staff.getDateOfBirth(),
					staff.isGender(), staff.getEmail(), staff.getAddress(), staff.getPhone(), id });
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Staff getStaffById(int id) {
		String sql = "select * from Staffs where Id = '" + id + "'";
		Staff staff = (Staff) jdbcTemplateObject.queryForObject(sql, new StaffMapper());
		return staff;
	}

	@Override
	public Staff getStaffByEmail(String email) {
		String sql = "select * from Staffs where Email = '" + email + "'";
		try {
			Staff staff = (Staff) jdbcTemplateObject.queryForObject(sql, new StaffMapper());
			return staff;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int resetPasswordById(int id) {
		String sql = "update Staffs set Password = '123456' where Id = '" + id + "'";
		return jdbcTemplateObject.update(sql);
	}

	@Override
	public String getPasswordById(int id) {
		String sql = "select Password from Staffs where Id = '" + id + "'";
		try {
			Staff staff = (Staff) jdbcTemplateObject.queryForObject(sql, new StaffMapper());
			String pass = staff.getPassword();
			return pass;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int setPasswordById(int id, String pass){
		String sql = "update Staffs set Password = ? where Id = ?";
		try {
			return jdbcTemplateObject.update(sql, new Object[]{pass, id});
		} catch (Exception e) {
			return 0;
		}
	}
}
