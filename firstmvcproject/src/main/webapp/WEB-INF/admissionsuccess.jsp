<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission success</title>
</head>
<body>
	<h1>${headerMessage}</h1><br/>
	<table>
		<tr>
			<td>Student name:</td>
			<td>${student.studentName}</td>
		</tr>
		<tr>
			<td>Student hobby:</td>
			<td>${student.studentHobby}</td>
		</tr>
		<tr>
			<td>Student mobile:</td>
			<td>${student.studentMobile}</td>
		</tr>
		<tr>
			<td>Student DOB:</td>
			<td>${student.studentDOB}</td>
		</tr>
		<tr>
			<td>Student hobby:</td>
			<td>${student.studentSkills}</td>
		</tr>
		<tr>
			<td>Student Address:</td>
			<td>Country : ${student.studentAddress.country}
				City    : ${student.studentAddress.city}
				Street  : ${student.studentAddress.street}
				Pin code: ${student.studentAddress.pinCode}
		</tr>
	</table>
	
</body>
</html>