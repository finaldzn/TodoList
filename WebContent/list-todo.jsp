<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Todos List</title>
<link type="text/css"rel="stylesheet"href="css/style.css">
<link type="text/css"rel="stylesheet"href="css/add-todo-style.css">
</head>

<body>
<!--  ${TODOS_LIST}-->
<div id="wrapper">
	<div id="header">
	<h2> TODOS LIST </h2>
	</div>
</div>
<div id="container">
	<div id="content">
		<form action="AddTodoControllerServlet" method="get">
		<input type ="submit" value="Add Todo"/>
		</form>
		<table>
			<tr>
				<th>ID</th>
				<th>CONTENT</th>
			</tr>
		<c:forEach var = "todos" items="${TODOS_LIST}">
			<c:url var="EditLink" value="editTodo">		
			<c:param name="id" value ="${todos.id}"/>
			</c:url>
			<c:url var="DeleteLink" value="DeleteTodoServlet">		
			<c:param name="id" value ="${todos.id}"/>
			</c:url>
				<tr>
					<td > ${todos.id}</td>
					<td> ${todos.content}</td>
					<td><a href="${EditLink }">Edit</a>|<a href="${DeleteLink }">Delete</a></td>
		</c:forEach>
		</table>
	</div>
</div>

</body>
</html>