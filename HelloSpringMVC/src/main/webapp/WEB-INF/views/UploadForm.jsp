<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC File Upload Demo</title>
	</head>
	<body>
	    <center>
	        <h1>Spring MVC File Upload Demo</h1>
	        <form method="post" action="uploadFile.do" enctype="multipart/form-data">
	            <table border="0">
	                <tr>
	                    <td>Description:</td>
	                    <td><input type="text" name="description" size="50"/></td>
	                </tr>
	                <tr>
	                    <td>Pick file #1:</td>
	                    <td><input type="file" name="fileUpload" size="50" /></td>
	                </tr>
	                <tr>
	                    <td>Pick file #2:</td>
	                    <td><input type="file" name="fileUpload" size="50" /></td>
	                </tr>
	                <tr>
	                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
	                </tr>
	            </table>
	        </form>
	    </center>
	</body>
</html>