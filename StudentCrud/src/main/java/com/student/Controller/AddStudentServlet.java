package com.student.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DaoImpl.StudentDaoImpl;
import com.student.Model.Student;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDaoImpl stu = new StudentDaoImpl();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Student s = new Student(name,email,age);
		stu.addStudent(s);
		
		resp.sendRedirect("success.jsp");
		
		
		
		
	}
	

}
