<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumble</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
		<div class="container">
		<h1>Rumble Details</h1>
		<c:choose>
			<c:when test="${not empty sessionScope.Rumble }">

			Title: ${Rumble.title }<br>
			
			Rumblers: ${Rumble.host } VS ${Rumble.guest }<br>
			<img src="${Rumble.host.profileImageURL }"
						alt="host picture"> VS <img src="${Rumble.guest.profileImageURL }"
						alt="guest picture"><br>
			Description ${Rumble.description }<br>
			Date: ${Rumble.rumbleDate }<br>
			Time: ${Rumble.startTime }<br>
			Discipline: ${Rumble.discipline }<br>
			Location: ${Rumble.location.name }<br>
			Address: ${Rumble.location.address.street }<br>
			


			</c:when>
			<c:otherwise>
				<h2>Rumble does not Exist.</h2>
			</c:otherwise>

		</c:choose>
	</div>

	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>