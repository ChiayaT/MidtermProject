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
	<div class="container">
		<h1>Rumble Ring</h1>
		<hr>

		<h2 class="display-6 text-center">Name: ${location.name}</h2>
		<br>
		<div class="text-center">
			<c:choose>
				<c:when test="${empty location.image_url}">
					<img class="rounded-biggest" src="images/rumbleRing.png">
					<br>
				</c:when>
				<c:otherwise>
					<img class="rounded-biggest" src="${location.image_url}">
					<br>
				</c:otherwise>
			</c:choose>
		</div>
		<br>
		<h3 class="text-center">Description: ${location.description}</h3>
		<c:choose>
			<c:when test="${!loggedInUser.hasRatedLocation(location.id)}">
				<a class="btn btn-update"
					href="giveLocationRating.do?locationId=${location.id}"> Rate
					This Rumble Ring</a>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>
		<br> <a class="btn btn-success"
			href="updateLocationPage.do?locationId=${location.id}">Update
			This Rumble Ring</a>

		<h2>Rumbler Ring Ratings and Reviews</h2>
		<c:forEach var="rating" items="${location.locationRatings}">
	${rating.user.username} gives a ${rating.ratingScale} out of 5 <br>
			<img width="150" src="${rating.user.profileImageURL}">
			<br>
	${rating.ratingComment}<br>
		</c:forEach>
	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>