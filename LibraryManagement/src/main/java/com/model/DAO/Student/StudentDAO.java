package com.model.DAO.Student;

import java.util.List;

import com.model.Student;

public interface StudentDAO {
	public List<Student> getAll();

	public List<Student> getAll2();
	
	public Student getStudentById(int id);
	
	public Student getStudentByEmail(String email);

	public int addNewStudent(Student student);

	public int deleteStudentById(int id);
	
	public int deactivateStudentById(int id);
	
	public int reactiveStudentById(int id);
	
	public int resetPasswordById(int id);

	public int editStudentById(int id, Student student);
	
	public int setPasswordById(int id, String password);
}
