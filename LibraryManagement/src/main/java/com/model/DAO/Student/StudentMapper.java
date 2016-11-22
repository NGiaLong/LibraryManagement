package com.model.DAO.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Student;

public class StudentMapper implements RowMapper<Student>{
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("Id"));
		student.setName(rs.getString("Name"));
		student.setDateOfBirth(rs.getString("DateOfBirth"));
		student.setGender(rs.getBoolean("Gender"));
		student.setEmail(rs.getString("Email"));
		student.setPassword(rs.getString("Password"));
		student.setAddress(rs.getString("Address"));
		student.setPhone(rs.getString("Phone"));
		student.setStatus(rs.getBoolean("Status"));
		return student;
	}

}
