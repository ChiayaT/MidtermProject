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
    <h1>Rumble Ring</h1>
	${location.name}<br>
	${location.description}<br>
	<img width="150" src="${location.image_url}">
	${location.name}<br>
	<h2>Rumbler Ring Ratings and Reviews</h2>
	<c:forEach var="rating" items="${location.locationRatings}">
	${rating.user.username} gives a ${rating.ratingScale} out of 5 <br>
	<img width="150" src="${rating.user.profileImageURL}">
	${rating.ratingComment}<br>
	</c:forEach>
    <jsp:include page="bootstrapScript.jsp" />
</body>
</html>