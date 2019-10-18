<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<title>Add a todo</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
	<h2> TODOS LIST </h2>
	</div>
</div>

<form action="LoginServlet" method="get">
		<input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type ="submit" value="Logout" style="margin-bottom: 20px;"/>
</form>

<div id="container">
	<h3>${sessionScope.username}, add a Todo</h3>
<form action="TodoControllerServlet" method="post">
	<div class="mdl-card mdl-shadow--4dp" style="margin-bottom:20px;">         			
							<div class="mdl-card__title">					            
					            <h2 class="mdl-card__title-text">CONTENT</h2>
					         </div>
					         <div class="mdl-card__supporting-text">
					         <textarea class="mdl-textfield__input" name="content" rows = "3"  cols = "80">Content</textarea>
						     </div>				              
					         <div class="mdl-card__actions">
					                <input  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" Value="Save"/>
					         </div>			         
			          </div>
</form>
</div>
<footer class="mdl-mini-footer">
  <div class="mdl-logo" style="clear:both;"></div>
	<a href="TodoControllerServlet">Back to TODOS</a>
	
</footer>

</body>
</html>