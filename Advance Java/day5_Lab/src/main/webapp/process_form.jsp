<%@page import="pojos.Student"%>
<%@page import="pojos.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process_form</title>
</head>
<body>
<h4>Form process from page....</h4>
<% //1.read req param : student details
//out.flush();//exc
String firstName = request.getParameter("fn");
String lastName = request.getParameter("ln");
int score = Integer.parseInt(request.getParameter("score"));
Course selectedCourse = Course.valueOf(request.getParameter("course").toUpperCase());
//boolean admitted = Boolean.parseBoolean(request.getParameter("Student Admission"));

//2. wrap all the details under student object
//String firstName, String lastName, int score, Course selectedCourse
Student s1 = new Student(firstName,lastName,score,selectedCourse);
if(score > selectedCourse.getMinScore())
{
	s1.setAdmitted(true);
}
//server pull : forward
//min scope of attributes : page | request | session | application --req
//add attr
request.setAttribute("student_info", s1);
//RD
RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
rd.forward(request, response);
System.out.println("exec control come back ...");

%>
</body>
</html>