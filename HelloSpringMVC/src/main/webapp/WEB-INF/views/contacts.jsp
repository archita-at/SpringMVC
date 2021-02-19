<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Contact Manager Home</title>
	</head>
	<body>
		<div align="center">
			<h1>Contact List</h1>
			<h3><a href="/HelloSpringMVC/newContact">New Contact</a></h3>
			<table border="1">
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Telephone</th>
				<th>Action</th>
				
				<c:forEach var="contact" items="${listContact}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.telephone}</td>
					<td>
						<a href="/HelloSpringMVC/editContact?id=${contact.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/HelloSpringMVC/deleteContact?id=${contact.id}">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>