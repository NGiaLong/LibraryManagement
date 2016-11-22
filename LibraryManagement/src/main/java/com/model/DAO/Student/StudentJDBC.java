package com.model.DAO.Student;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Student;
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
		Student student = (Student) jdbcTemplateObject.queryForObject(sql, new StudentMapper());
		return student;
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
		return 1;
	}

	@Override
	public int deleteStudentById(int id) {
		return 1;
	}

	@Override
	public int editStudentById(int id) {
		return 1;
	}
}
