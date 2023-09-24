<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumbler</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<h1>Rumbler</h1>
	<c:choose>
		<c:when test="${not empty sessionScope.loggedInUser }">
			<h2>
				Username:
				<c:out value="${loggedInUser.username}" />
			</h2>
			<h2>
				First Name:
				<c:out value="${loggedInUser.firstName}" />
			</h2>
			<h2>
				Last Name:
				<c:out value="${loggedInUser.lastName}" />
			</h2>
		</c:when>
		<c:otherwise>
			<h2>Not logged in.</h2>
		</c:otherwise>

	</c:choose>

</body>
</html>