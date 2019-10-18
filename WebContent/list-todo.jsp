<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Todos List</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<style>
    #view-source {
      position: fixed;
      display: block;
      right: 0;
      bottom: 0;
      margin-right: 40px;
      margin-bottom: 40px;
      z-index: 900;
    }
</style>

</head>

    
<body>
<!--  ${TODOS_LIST}-->
<div id="wrapper">
	<div id="header">
	<h2> TODOS LIST </h2>
	<h3>Welcome ${username}</h3>
	</div>
</div>
<div class="mdl-grid" id="container">
	<div class="mdl-cell mdl-cell--6-col" id="content">

		<form action="AddTodoControllerServlet" method="get">
		<input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type ="submit" value="Add Todo" style="margin-bottom: 20px;"/>
		</form>
            
            <c:forEach var = "todos" items="${TODOS_LIST}">
					<c:url var="EditLink" value="editTodo">		
					<c:param name="id" value ="${todos.id}"/>
					</c:url>
					<c:url var="DeleteLink" value="DeleteTodoServlet">		
					<c:param name="id" value ="${todos.id}"/>
					</c:url>
					
						<div class="mdl-card mdl-shadow--4dp" style="margin-bottom:20px;">         			
							<div class="mdl-card__title">					            
					            <h2 class="mdl-card__title-text">${todos.id }</h2>
					         </div>
					         <div class="mdl-card__supporting-text">					                
					                ${todos.content }
						     </div>				              
					         <div class="mdl-card__actions">
					                <a href="${EditLink }" class="mdl-button">Edit</a>
					                <a href="${DeleteLink }" class="mdl-button">Delete</a>
					         </div>			         
			          </div>
				</c:forEach>
	</div>
	<form action="LoginServlet" method="get">
		<input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type ="submit" value="Logout" style="margin-bottom: 20px;"/>
	</form>
</div>

</body>
</html>