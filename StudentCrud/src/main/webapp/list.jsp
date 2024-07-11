<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Information page</title>
</head>
<body>
<%out.print("List of students"); %>
<%@page import = "java.util.List , com.student.Model.Student" %>
<%
List<Student> student =(List<Student>) request.getAttribute("studentList");
for(Student s:student){
		
%>
<h1><%= s.getId()+" "+s.getName() +"   "+s.getEmail()+"   "+s.getAge()+" "%><a href="update.jsp?id=<%=s.getId()%>"> Update</a> 
<a href="DeleteServlet?id=<%=s.getId()%>">Delete</a>
</h1>

<%} %>

</body>
</html>
	