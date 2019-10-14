<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css"rel="stylesheet"href="css/add-todo-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Add a todo</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
	<h2> TODOS LIST </h2>
	</div>
</div>
<div id="container">
	<h3>Add a Todo</h3>
<form action="TodoControllerServlet" method="post">
	<table>
		<tbody>
			<tr>
			<td><label>CONTENT</label></td>
			<td><textarea name="content" rows = "3"  cols = "80">Content</textarea>
			</tr>
			<tr>
			<td><label></label></td>
			<td><input  type="submit" Value="Save"/></td>
		</tbody>
	</table>
</form>
<div style="clear:both;"></div>
	<a href="TodoControllerServlet">Back to TODOS</a>
</div>
</body>
</html>