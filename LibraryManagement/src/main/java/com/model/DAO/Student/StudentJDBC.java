package com.model.DAO.Student;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Student;
import com.model.DAO.Student.StudentMapper;

public class StudentJDBC implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Student> getAll() {
		String sql = "select * from Students where status = '1'";
		try {
			List<Student> studentList = jdbcTemplateObject.query(sql, new StudentMapper());
			return studentList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Student> getAll2() {
		String sql = "select * from Students where status = '0'";
		try {
			List<Student> studentList = jdbcTemplateObject.query(sql, new StudentMapper());
			return studentList;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Student getStudentById(int id){
		String sql = "select * from Students where Id = '"+id+"'";
		try {
			Student student = (Student) jdbcTemplateObject.queryForObject(sql, new StudentMapper());
			return student;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Student getStudentByEmail(String email){
		String sql = "select * from Students where Email = '"+email+"'";
		try {
			Student student = (Student) jdbcTemplateObject.queryForObject(sql, new StudentMapper());
			return student;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int deactivateStudentById(int id){
		String sql = "update Students set Status = '0' where Id ='"+id+"'";
		return jdbcTemplateObject.update(sql);
	}
	
	@Override
	public int reactiveStudentById(int id){
		String sql = "update Students set Status = '1' where Id ='"+id+"'";
		return jdbcTemplateObject.update(sql);
	}
	
	@Override
	public int resetPasswordById(int id){
		String sql = "update Students set Password = '123456' where Id = '"+id+"'";
		return jdbcTemplateObject.update(sql);
	}
	@Override
	public int addNewStudent(Student student) {
		String sql = "insert into Students ( Name, DateOfBirth, Gender, Email, Password, Address, Phone, Status)"
				+ "values(?,?,?,?,'123456',?,?,'1')";
		try {
			return jdbcTemplateObject.update(sql,
					new Object[] {student.getName(),student.getDateOfBirth(),student.isGender(),student.getEmail(),student.getAddress(),student.getPhone()});
		} catch (Exception e) {
			return 0;
		}
}

	@Override
	public int deleteStudentById(int id) {
		String sql = "delete from Students where Id = ?";
		try {
			return jdbcTemplateObject.update(sql, new Object[]{id});
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int editStudentById(int id, Student student) {
		String sql = "update Students set Name = ? , DateOfBirth = ? , Gender = ? , Email = ?  , Address = ? , Phone = ? where id = ?";
		try {
			return jdbcTemplateObject.update(sql, new Object[] { student.getName(), student.getDateOfBirth(), student.isGender(),
					student.getEmail(), student.getAddress(), student.getPhone(),id });
		} catch (Exception e) {
			return 0;
		}
	}
}
