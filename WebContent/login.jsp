<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300;500;600;700;900&display=swap"
	rel="stylesheet">
<link href="css/style.css" type="text/css" rel="stylesheet">

<title>Register Employee</title>
</head>
<body>

	<form name="details" method="post" action="dologin">
		<header>
			<span>Not Registered ?</span><a href="register" class="btn">  Register Now </a>
			<h1>Login To Access Portal</h1>
			<c:forEach var="err" items="${error }">
			<span class="error error-login"><c:out value="${err.message }" /></span>
			</c:forEach>
		</header>
		<div class="wrap login-wrap">
			<div class="fwrapper">

				<div class="field field-login">
					<input type="text" name="username" placeholder="Username">
				</div>
			</div>


			<div class="fwrapper">


				<div class="field field-login">
					<input type="password" name="password" placeholder="Password">
				</div>


			</div>

			<div class="submitbtn">
				<input type="submit" name="submit" value="Login">
			</div>
		</div>

	</form>

</body>
</html>
