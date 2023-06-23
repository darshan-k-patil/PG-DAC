<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add_Player_form</title>
</head>
<%--getServletContext().setAttribute("ipl", new IPLBean()); --%>
<jsp:useBean id="ipl" class="beans.IPLBean" scope="application"/>
<body>
	<%--display team details --%>
	<%--getServletContext().getAttribute("ipl"): IPLBean --> getAllTeams() --%>
	<h5>Team : ${applicationScope.ipl.fetchAllTeams()}</h5>
	<%--<h5>Team : ${applicationScope.ipl.allTeams}</h5> --%>
	<%--for getAllTeams --%>
</body>
</html>