<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumbler</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h1>Fellow Rumblers</h1>
	<table>
		<thead>
			<tr>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<c:if test="${user.id != loggedInUser.id }">
					<td>${user.username}</td>
						<td><br>
						<img width="150" src="${user.profileImageURL}"></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>