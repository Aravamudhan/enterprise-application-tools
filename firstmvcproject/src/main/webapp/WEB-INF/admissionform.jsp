<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission form</title>
	<style>
		.error {
			color: #ff0000;
		}
	
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
</head>
<body>
	<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
	<p><a href="/firstmvcproject/admissionForm.htm?siteTheme=red">Red</a> | <a href="/firstmvcproject/admissionForm.htm?siteTheme=green">Green</a></p>
	<a href="/firstmvcproject/admissionForm.htm?siteLanguage=en">English</a> | <a href="/firstmvcproject/admissionForm.htm?siteLanguage=fr">French</a>
	
	<h1>${headerMessage}</h1>
	<h2><spring:message code="label.headerMessage"/></h2>
	<form:errors path="student.*" cssClass="errorBlock" element="div"/>
	<form action="/firstmvcproject/submitAdmissionForm.htm" method="post">
		<table>
			<tr>
				<td><spring:message code="label.studentName"/></td>
				<td><input type="text" name="studentName"/></td>
				<td><form:errors path="student.studentName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentHobby"/></td>
				<td><input type="text" name="studentHobby"/></td>
				<td><form:errors path="student.studentHobby" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentMobile"/></td>
				<td><input type="text" name="studentMobile"/></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentDOB"/></td> 
				<td><input type="text" name="studentDOB"/></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentSkills"/></td>
				<td><select name="studentSkills" multiple>
						<option value="Java">Java</option>
						<option value="Spring">Spring</option>
						<option value="Hibernate">Hibernate</option>
					</select>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><spring:message code="label.studentAddress"/></td>
			</tr>
			<tr>
				<td><spring:message code="label.country"/> <input type="text" name="studentAddress.country"/></td>
				<td><spring:message code="label.city"/> <input type="text" name="studentAddress.city"/></td>
				<td><spring:message code="label.street"/> <input type="text" name="studentAddress.street"/></td>
				<td><spring:message code="label.pinCode"/> <input type="text" name="studentAddress.pinCode"/></td>
			</tr>
			<tr>
				<td><input type="submit" value='<spring:message code="label.submit.admissionForm"/>'/></td>
			</tr>
		</table>
		
	</form>
</body>
</html>