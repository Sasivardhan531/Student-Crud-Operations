package com.student.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DaoImpl.StudentDaoImpl;
import com.student.Model.Student;

@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDaoImpl student = new StudentDaoImpl();
	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Student s = new Student(name,email,age);
		student.updateStudent(s);
		
		resp.sendRedirect("updateSuccess.jsp");
		
	}

}
