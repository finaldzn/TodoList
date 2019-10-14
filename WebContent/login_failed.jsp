<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">

<title>Login</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>ESILV Engineering School</h2>
	</div>
</div>
<div id="container">
	<h2>Login failed (wrong username/password combination)</h2>
	<h3> Login </h3>	
	<form action="LoginServlet" method="post">
		<table>
			<tbody>				
				<tr>
					<td><label>Username:</label></td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="text" name="password"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" name="Save" value="Connect"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<div style="clear:both;"></div>
	<a href="TodoControllerServlet">Back to TODOS</a>
</div>
</body>
</html>