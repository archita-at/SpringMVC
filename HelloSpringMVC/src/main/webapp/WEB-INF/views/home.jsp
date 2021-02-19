<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>Hello World!</h1>
		<P>The time on the server is ${serverTime}.</P>
		<h2><a href="/HelloSpringMVC/download">Click here to download file</a></h2>
		<div align="center">
			<h1>Spring MVC with CSV File Download</h1>
			<p><a href="/HelloSpringMVC/downloadCSV">Download CSV</a></p>
			<p><a href="/HelloSpringMVC/viewCSV">View CSV</a></p>
		</div>
	</body>
</html>