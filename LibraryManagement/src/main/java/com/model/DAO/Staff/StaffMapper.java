package com.model.DAO.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Staff;

public class StaffMapper implements RowMapper<Staff>{
	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff staff = new Staff();
		staff.setId(rs.getInt("Id"));
		staff.setName(rs.getString("Name"));
		staff.setDateOfBirth(rs.getString("DateOfBirth"));
		staff.setGender(rs.getBoolean("Gender"));
		staff.setEmail(rs.getString("Email"));
		staff.setPassword(rs.getString("Password"));
		staff.setAddress(rs.getString("Address"));
		staff.setPhone(rs.getString("Phone"));
		staff.setStatus(rs.getBoolean("Status"));
		return staff;
	}

}
