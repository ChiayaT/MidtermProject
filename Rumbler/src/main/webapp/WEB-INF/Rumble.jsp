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
		<c:choose>
			<c:when test="${not empty sessionScope.Rumble }">
				<div class="row align-items-center">
					<div class="col text-center">
						<h3 class="display-6">${Rumble.title }</h3>
						<p class="lead">Rumblers: ${Rumble.host.firstName }
							${Rumble.host.lastName } VS ${Rumble.guest.firstName }
							${Rumble.guest.lastName }</p>
					</div>
				</div>
				<div class="row align-items-center">
					<div class="col">
						<img src="${Rumble.host.profileImageURL }" class="img-thumbnail"
							alt="host picture"> VS <img
							src="${Rumble.guest.profileImageURL }" class="img-thumbnail"
							alt="guest picture">
					</div>
					<div class="col">
						<strong>Description: </strong> ${Rumble.description }<br> <strong>Date:
						</strong>${Rumble.rumbleDate }<br> <strong>Time: </strong>${Rumble.startTime }<br>
						<strong>Discipline: </strong>${Rumble.discipline.name }<br> <strong>Location:
						</strong>${Rumble.location.name }<br> <strong>Address: </strong>${Rumble.location.address.street }<br>
					</div>
				</div>
				<a href="goToDeleteRumble.do?rumbleId=${Rumble.id }" class="btn btn-danger">Delete Rumble</a>
				<a href="createMessage.do?rumbleId=${Rumble.id }&userId=${loggedInUser.id}" class="btn btn-update">Add Rumble Message</a>
				<div class="">
					<table>
					<c:forEach var="message" items="${Rumble.rumbleMessages}" >
					<c:if test="${message.enabled == true }">
						<tr>
						<c:choose>
							<c:when test="${message.user.id == loggedInUser.id }">
								<td class="align-middle text-center"><img src="${message.user.profileImageURL}" class="rounded"></td>
								<td><strong>${message.user.username }</strong></td>
								<td>${message.content }</td>
								<td><a href="updateMessage.do?messageId=${message.id }" class="btn btn-update">Update Message</a></td>
								<td><a href="deleteMessage.do?messageId=${message.id }" class="btn btn-danger">Delete Message</a></td>
								<br><br>
							</c:when>
							<c:otherwise>
								<td>${message.content }</td>
								<td class="align-middle text-center"><img src="${message.user.profileImageURL}" class="rounded"></td>
								<td><strong>${message.user.username }</strong></td>
								
							</c:otherwise>
							
						</c:choose>
						</tr>
						</c:if>
						<br>
					</c:forEach>	
					</table>
				
				</div>



			</c:when>
			<c:otherwise>
				<h2>Rumble does not Exist.</h2>
			</c:otherwise>

		</c:choose>
	</div>

	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>