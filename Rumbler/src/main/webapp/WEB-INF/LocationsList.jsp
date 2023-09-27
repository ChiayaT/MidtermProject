<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumbler Locations</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h1>Rumble Rings</h1>
	<!--Might need a little tweekage-->
	<c:forEach var="location" items="${locations}">
	${location.name}<br>
	${location.description}<br>
	<a href="getLocation.do?locationId=${location.id}"> <img width="150" src="${location.image_url}"></td></a><br>
	<!--${location.address}<br>-->


	</c:forEach>


	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>