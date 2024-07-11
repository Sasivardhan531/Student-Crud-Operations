package com.student.Dao;

import java.util.List;

import com.student.Model.Student;

public interface StudentDao {
	public void addStudent(Student Student);
	
	public Student getStudent(int studentId);
	
	public List<Student> getAllStudent();
	
	public void updateStudent(Student s);
	
	public void deleteStudent(int sId);
	

}
