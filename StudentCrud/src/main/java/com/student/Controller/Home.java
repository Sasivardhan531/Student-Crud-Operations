package com.student.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DaoImpl.StudentDaoImpl;
import com.student.Model.Student;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDaoImpl stu = new StudentDaoImpl();
		List<Student> list = stu.getAllStudent();

		
		
		
		
		request.setAttribute("studentList", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
		

	}

}
