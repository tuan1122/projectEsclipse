<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thong tin Person</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>
		<h3>
			<a href="form">New Employee</a>
		</h3>
		<table border="1">

			<th>PersonID</th>
			<th>Name</th>
			<th>Address</th>

			<c:forEach var="person" items="${listPerson}">
				<tr>
					<td>${person.articleId}</td>
					<td>${person.name}</td>
					<td>${person.address}</td>
					<td><a href="editEmployee?id=${person.articleId}">Edit</a> 
					<a href="delete?id=${person.articleId}">Delete</a>
					<a href="getById?id=${person.articleId}">Detail</a></td>

				</tr>
			</c:forEach>
		</table>
		<c:if test="${person!=null}">
			<p>${person.name}</p>
		</c:if>
	</div>
</body>
</html>