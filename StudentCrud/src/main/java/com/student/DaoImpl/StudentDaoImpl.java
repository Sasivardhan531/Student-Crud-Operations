package com.student.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.Dao.StudentDao;
import com.student.Model.Student;



public class StudentDaoImpl implements StudentDao{
	
	final static String INSERT_QUERY = "INSERT INTO `student`(`name`,`email`,`age`) values (?,?,?)";
	final static String SELECT_ALL_QUERY = "SELECT * FROM `student`";
	final static String SELECT_QUERY = "SELECT * FROM `student` WHERE `id` = ?";
	final static String UPDATE_QUERY = "UPDATE `student` set `name` =?,`email` = ?,`age` = ? WHERE `id`=?";
	final static String DELETE_QUERY = "DELETE FROM `student` WHERE `id` = ?";
	
	Connection con;
	String url = "jdbc:mysql://localhost:3306/student";
	String uname = "root";
	String password= "root";
	
	public StudentDaoImpl() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,password);
		} 
		catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}	
		
	}
	

	@Override
	public void addStudent(Student student) {
		PreparedStatement prepareStatement;

		try {
			
			prepareStatement = con.prepareStatement(INSERT_QUERY);
			
			
			prepareStatement.setString(1, student.getName());
			prepareStatement.setString(2,student.getEmail());
			prepareStatement.setInt(3, student.getAge());
			
			
			
		
			prepareStatement.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Student getStudent(int studentId) {
		PreparedStatement statement;
		ResultSet res = null;
		Student student = null;
		
		
		try {
			statement = con.prepareStatement(SELECT_QUERY);
			
			statement.setInt(1, studentId);
			
			res = statement.executeQuery();
			
			
			if(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				int age = res.getInt("age");
				
								
				
				student = new Student(id,name,email,age);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return student;
		
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<Student>();
		PreparedStatement stmt = null;
		Student student = null;
		try {
			stmt = con.prepareStatement(SELECT_ALL_QUERY);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				int age = res.getInt("age");
				
				
				student = new Student(id,name,email,age);
				list.add(student);
				

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return list;
	}

	@Override
	public void updateStudent(Student s) {
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(UPDATE_QUERY);
			stmt.setString(1, s.getName());
			stmt.setString(2,s.getEmail());
			stmt.setInt(3,s.getAge());
			
			stmt.setInt(4, s.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteStudent(int sId) {
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(DELETE_QUERY);
			
			stmt.setInt(1, sId);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
