package com.model.DAO.Student;

import java.util.List;

import com.model.Student;

public interface StudentDAO {
	public List<Student> getAll();

	public List<Student> getAll2();

	public int addNewStudent(Student student);

	public int deleteStudentById(int id);

	public int editStudentById(int id);
}
