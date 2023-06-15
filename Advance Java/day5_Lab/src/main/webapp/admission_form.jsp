<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admission_form</title>
</head>
<body>
<form action="process_form.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="ln" /></td>
			</tr>
			<tr>
				<td>Enter Score</td>
				<td><input type="number" name="score" /></td>
			</tr>
			<tr>
				<td>Enter Course</td>
				<td><input type="text" name="course" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Student Admission" /></td>
			</tr>
		</table>
	</form>
</body>
</html>