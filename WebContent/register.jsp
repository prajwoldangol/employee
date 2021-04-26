<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300;500;600;700;900&display=swap" rel="stylesheet">
<link href="css/style.css" type="text/css" rel="stylesheet" >
	
<title>Register Employee</title>
</head>
<body>

	<form name="details" method="post" action="doregister">
		<header>
			<span>Already Registered?</span><a href="login" class="btn"> Login</a>
			<h1>New Employee Registration</h1>
			<c:forEach var="err" items="${error }">
			<span class="error"><c:out value="${err.message }" /></span>
			</c:forEach>
		</header>
		<div class="wrap">
	
		
		
			<div class="fwrapper">
				
				<div class="field">
					<label for="fname">Full Name</label> <input type="text"
						name="name" placeholder="Full Name" value="<c:out value="${formdata[0] }" />" required>
				</div>
				<div class="field">
					<label for="password">Password </label> <input type="password" name="password" required>
				</div>
				<div class="field">
					<label for="ssn">Ssn</label> <input type="text" name="ssn" value="<c:out value="${formdata[1] }" />"
						placeholder="SSN" required>
				</div>
				
				<div class="field">
					<label for="email">Email</label> <input type="email" name="email" value="<c:out value="${formdata[2] }" />"
						placeholder="Email@email.com" required>
				</div>
				<div class="field">
					<label for="phone">Phone</label> <input type="tel" name="phone" value="<c:out value="${formdata[3] }" />"
						placeholder="0000000000" required>
				</div>

			</div>
			<h2>Additional Informations</h2>

			<div class="fwrapper">

				
				<div class="field">
					<label for="bank">Bank Account Number</label> <input type="text" name="bank" value="<c:out value="${formdata[4] }" />"
						placeholder="Bank Account Number">
				</div>
				<div class="field">
					<label for="qualification">Qualification</label> <input type="text" name="qualification" value="<c:out value="${formdata[5] }" />"
						placeholder="Qualification">
				</div>
					<div class="field">
					<label for="income">Income</label> <input type="text" name="income" value="<c:out value="${formdata[6] }" />"
						placeholder="Income"> 
				</div>
			</div>
	

			<div class="submitbtn">
				<input type="submit" name="submit" value="Enter">
			</div>
		</div>

	</form>
	
</body>
</html>
