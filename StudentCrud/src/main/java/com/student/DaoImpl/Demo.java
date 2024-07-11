package com.student.DaoImpl;

import java.util.List;

import com.student.Model.Student;

public class Demo {
	public static void main(String[] args) {
		StudentDaoImpl s = new StudentDaoImpl();
//		List<Student> list = s.getAllStudent();
//		
//		for(Student l:list) {
//			System.out.println(l);
//		}
////		Student stu = s.getStudent(3);
////		System.out.println(stu);
//		s.deleteStudent(7);
		Student stu = new Student(3,"sasi","sasi@gmail.com",22);
		s.updateStudent(stu);
		
	}

}
