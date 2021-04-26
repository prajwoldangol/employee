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

<title>Portal</title>
</head>
<body>


	<header>

		<h1>Welcome to User Portal . You Are ready to go</h1>
		<a href="logout" class="btn btn-logout">  Logout </a>
	
	</header>
	
<section class="results">
	<div class="tables">
	<header class="portal">
		<h2> Filter By Income </h2>
		<select name="filter" class="filter">
		<option selected disabled> Choose</option>
		<option value="<c:out value="${url}" />/userportal?filter=6000">6000</option>
		<option value="<c:out value="${url}" />/userportal?filter=7000">7000</option>
		<option value="<c:out value="${url}" />/userportal?filter=8000">8000</option>
		<option value="<c:out value="${url}" />/userportal?filter=9000">9000</option>
		</select>
	</header>
		<table>
			<tr>
				<th>Full Name</th>
				<th>SSN</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Bank</th>
				<th>Qualification</th>
				<th>Income</th>
			

			</tr>
			<c:forEach var="emp" items="${employee}">
				<tr>
					<td><c:out value="${emp.name}" /></td>
					<td><c:out value="${emp.ssn}" /></td>
					<td><c:out value="${emp.email}" /></td>
					<td><c:out value="${emp.phone}" /></td>
					<td><c:out value="${emp.bank}" /></td>
					<td><c:out value="${emp.qualification}" /></td>
					<td><c:out value="${emp.income}" /></td>
			
			

				</tr>
				</c:forEach>
		</table>
	
		</div>
	</section>


</body>
</html>
