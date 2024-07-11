<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Details</title>

</head>
<body>

<form action="AddStudentServlet" method="post" class="form-container">
			
			
			<div class="form-group">
				<label for="InputName">Name</label>
				<input name="name" class="form-control" id="InputName" placeholder="Enter Name" required> 
			</div>
			<br>
			<div class="form-group">
				<label for="Email">Email</label>
				<input name="email" class="form-control" id="Email" placeholder="Enter Email" required> 
			</div>
			<br>
			<div class="form-group">
				<label for="Age">Age</label>
				<input name="age" class="form-control" id="Age" placeholder="Enter Age" required> 
			</div>
			<br>
			<button type = "submit">Add</button>
			
	</form>

</body>
</html>