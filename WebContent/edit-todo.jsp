<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE htmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<title>Edit a todo</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>TODOS LIST</h2>
</div>
</div>
<h3>${sessionScope.username}, edit a Todo</h3>

<form action="LoginServlet" method="get">
		<input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type ="submit" value="Logout" style="margin-bottom: 20px;"/>
</form>


<form action="editTodo"method="post">
<div class="mdl-card mdl-shadow--4dp" style="margin-bottom:20px;">         			
							<div class="mdl-card__title">					            
					            <h2 class="mdl-card__title-text">CONTENT</h2>
					         </div>
					         <div class="mdl-card__supporting-text">
					         <textarea class="mdl-textfield__input" name="content" rows = "3"  cols = "80">${Todo.content }</textarea>
						     </div>				              
					         <div class="mdl-card__actions">
					                <input  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" Value="Save"/>
					         </div>			         
			          </div>
			          
		
</form>
<footer class="mdl-mini-footer">
  <div class="mdl-logo" style="clear:both;"></div>
  <c:url var="TodosLink" value="TodoControllerServlet">		
	<c:param name="username" value ="${sessionScope.username}"/>
	<c:param name="role" value ="${sessionScope.role }"/>
  </c:url>
	<a href="${TodosLink }">Back to TODOS</a>
	
</footer>
</body>
</html>
