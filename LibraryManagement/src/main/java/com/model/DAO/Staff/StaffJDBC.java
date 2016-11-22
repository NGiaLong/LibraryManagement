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
		return 1;
	}

	@Override
	public int deleteStaffById(int id) {
		return 1;
	}

	@Override
	public int editStaffById(int id) {
		return 1;
	}
	
	@Override
	public Staff getStaffById(int id) {
		Staff st = new Staff();
		return st;
	}
}
