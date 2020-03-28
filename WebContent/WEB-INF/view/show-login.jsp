<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style type="text/css">
body {
	min-height: 100vh;
	position: relative;
}
</style>
<title>Log In Page</title>
</head>
<body>
	<h3>
		<b>Log In Page</b>
	</h3>

	<br />
	<br /> Please log in !
	<br />
	<br />
	<!-- to action antistoixei sto mapping tou servlet  method="post"         /DistributedSystems/employee-login/employee-menu   -->
	${error} ${log_out_message} 
	<br />
	<c:if test="${param.error != null}">
		<i>Sorry! Invalid username/password!</i>
	</c:if>       
	<div id=" login for all in order to see the menu">
		<form:form  action="/DistributedSystems/login/main-menu-for-all"  method="POST"> 
		
	Username : <input name="username" id="username" type="text" required />
			<br />
	Password: <input name="password" id="password" type="password" required />
			<br />
			<input type="submit" value="Login" />
		</form:form>
	</div>


	<br />
	<br />