<%@page import="pojos.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<h5>Hello , ${requestScope.student_info.firstName} ${param.ln}</h5> 
	<%
		//get student details from request scope
		Student s = (Student) request.getAttribute("student_info");
	if(s.isAdmitted()) {
		%>
			<h5 style="color: green;">Congratulations, You are admitted in ${requestScope.student_info.selectedCourse}</h5>
		<%
	} else {
	%>
		<h5 style="color: red;">Sorry !!!, You are not admitted in ${requestScope.student_info.selectedCourse}</h5>
	<%
	}
	%>
</body>
</html>