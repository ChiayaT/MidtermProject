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
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h1>Account Details</h1>
		<c:choose>
			<c:when test="${not empty sessionScope.loggedInUser }">
				<div class="row">
					<div class="col">
						<div class="card" style="width: 20rem;">
							<img src="${loggedInUser.profileImageURL }" class="card-img-top"
								alt="profile picture">
							<div class="card-body">
								<h5 class="card-title">${loggedInUser.firstName}
									${loggedInUser.lastName}</h5>
								<p class="card-text">
									<strong>About Me: </strong><br>
									${loggedInUser.description}
								</p>
								<ul class="list-group">
									<li class="list-group-item"><strong>Username: </strong>${loggedInUser.username}</li>
									<li class="list-group-item"><strong>Date of
											Birth: </strong>${loggedInUser.dateOfBirth}</li>
									<li class="list-group-item"><strong>Height: </strong>${loggedInUser.heightInInches}
										inches</li>
									<li class="list-group-item"><strong>Weight: </strong>${loggedInUser.weightInPounds}
										pounds</li>
								</ul>

								<a href="update.do" class="btn btn-primary">Update Account</a> <a
									href="deletePage.do" class="btn btn-danger">Delete Account</a>
							</div>
						</div>
					</div>
					<div class="col">
						<h2 class="display-6">Upcoming Rumbles:</h2>

						<c:choose>
							<c:when test="${not empty allUserRumbles }">
								<table class="table table-striped">
									<thead class="table-dark">
										<tr>
											<th>ID </th>
											<th>RUMBLE</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="rumble" items="${allUserRumbles}">
											<tr>
												<td>${rumble.id}</td>
												<td><a href="Rumble.do?id=${rumble.id}">
														${rumble.title} @ ${rumble.location.name}</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:when>
							<c:otherwise>
								<p class="lead">No upcoming Rumbles scheduled.</p>
							</c:otherwise>
						</c:choose>

						<a href="makeRumble.do"> Create New Rumble</a>
					</div>
				</div>

			</c:when>
			<c:otherwise>
				<h2>Not logged in.</h2>
			</c:otherwise>

		</c:choose>
	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>