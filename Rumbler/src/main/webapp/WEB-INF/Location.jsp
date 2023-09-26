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
    <h1>Locations</h1>
    <c:forEach var="location" items="${locations}">
	${location.name}<br>
	${location.description}<br>
	${location.image_url}<br>
	${location.name}<br>
	

	</c:forEach>
    <jsp:include page="bootstrapScript.jsp" />
</body>
</html>