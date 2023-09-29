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
		<div class="text-center">
			<a class="btn btn-update"
				href="updateLocationPage.do?locationId=${location.id}">Update
				This Rumble Ring</a>
		</div>

		<h2>Rumbler Ring Ratings and Reviews</h2>
		<c:choose>
		<c:when test="${empty location.locationRatings }">
		<p class="lead">No Rumblers have rated this location... yet!</p>
			<a class="btn btn-update"
				href="giveLocationRating.do?locationId=${location.id}"> Rate
				This Rumble Ring</a>
		</c:when>
			<c:otherwise>
				<table class="table">
					<tbody>
						<c:forEach var="rating" items="${location.locationRatings}">
							<tr>
								<td class="align-middle text-center"><img
									src="${rating.user.profileImageURL}" class="rounded"></td>
								<td class="align-middle text-center"><strong>${rating.user.username}
								</strong>gives a ${rating.ratingScale} out of 5</td>
								<td class="align-middle text-center">${rating.ratingComment}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${!loggedInUser.hasRatedLocation(location.id)}">
					<a class="btn btn-update"
						href="giveLocationRating.do?locationId=${location.id}"> Rate
						This Rumble Ring</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>