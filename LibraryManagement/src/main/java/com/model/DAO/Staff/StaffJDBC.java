package com.model.DAO.Staff;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Staff;

public class StaffJDBC implements StaffDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<Staff> getAll(){
		String sql="select * from Staffs where status = '1'";
		try {
			List<Staff> staffList =  jdbcTemplateObject.query(sql, new StaffMapper());
			return staffList;
		} catch (Exception e) {
			return null;
		}
	}
}
