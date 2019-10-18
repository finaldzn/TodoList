<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<title>Login</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>ESILV Engineering School</h2>
	</div>
</div>
<div id="container">
	<h3> Login </h3>
	
	<form action="LoginServlet" method="post">
	<div class="mdl-card mdl-shadow--4dp" style="margin-bottom:20px; margin-left:20px;">         			
							
					         <div class="mdl-card__supporting-text">
					         <label>Username:</label>
					         <input class="mdl-textfield__input" name="username" value = "${username}"/>
					         <label>Password:</label>
					         <input class="mdl-textfield__input"  name="password"/>
						     </div>				              
					         <div class="mdl-card__actions">
					                <input  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" name="Save" Value="Connect"/>
					         </div>			         
			          </div>
		
	</form>
</div>
</body>
</html>