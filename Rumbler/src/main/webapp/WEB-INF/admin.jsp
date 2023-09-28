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
	<!-- ADMIN NAVBAR -->
	<nav class="navbar navbar-expand-lg fixed-top" id="navbarFormat">
		<div class="container-fluid">
			<a class="navbar-brand" href="adminPage.do" id="navbarFormat"> <img
				src="images/logoWhite.png" alt="logo" class="logo" height="30" /></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">


					<c:if test="${empty sessionScope.loggedInUser }">
						<li class="nav-item"><a class="nav-link nav-text"
							href="login.do">Login</a></li>
						<li class="nav-item"><a class="nav-link nav-text"
							aria-current="page" href="accountCreation.do">Create Account</a></li>
					</c:if>



					<c:if test="${not empty sessionScope.loggedInUser }">
						<li class="nav-item"><a class="nav-link nav-text"
							href="adminPage.do">Admin Dashboard</a></li>
						<li class="nav-item"><a class="nav-link nav-text"
							href="logout.do">Logout</a></li>
					</c:if>
				</ul>

			</div>
		</div>
	</nav>
	<div class="container">
		<h1>Admin Dashboard</h1>
		
		
		<c:if test="${not empty disabledRumble }">
			<p class="lead text-danger">Disabled Rumble: ${disabledRumble}</p>
		</c:if>
		
		<c:if test="${not empty disabledUser }">
			<p class="lead text-danger">Disabled User: ${disabledUser}</p>
		</c:if>
		
		<c:if test="${not empty disabledLocation }">
			<p class="lead text-danger">Disabled Location: ${disabledLocation}</p>
		</c:if>
		
		<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>TITLE</th>
						<th>DESCRIPTION</th>
						<th>LOCATION</th>
						<th>DATE</th>
						<th>HOST</th>
						<th>GUEST</th>
						<th>ENABLED</th>
						<th></th>
						<th></th>
						

					</tr>
				</thead>
				<tbody>
				<c:forEach var="rumble" items="${allRumbles}">
						<tr>
							<td class="align-middle">${rumble.id}</td>
							<td class="align-middle">${rumble.title}</td>
							<td class="align-middle">${rumble.description}</td>
							<td class="align-middle">${rumble.location.name}</td>
							<td class="align-middle">${rumble.rumbleDate}</td>
							<td class="align-middle">${rumble.host.firstName} ${rumble.host.lastName}</td>
							<td class="align-middle">${rumble.guest.firstName} ${rumble.guest.lastName}</td>
							<td class="align-middle">${rumble.enabled}</td>
							<td class="align-middle"><a href="#" class="btn btn-update">Enable Rumble</a></td>
							<td class="align-middle"><a href="disableRumble.do?id=${rumble.id}" class="btn btn-danger">Disable Rumble</a></td>
						</tr>
				</c:forEach>
			</tbody>
			</table>
			
			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>USERNAME</th>
						<th>PASSWORD</th>
						<th>FIRST NAME</th>
						<th>LAST NAME</th>
						<th>ADDRESS ID</th>
						<th>ENABLED</th>
						<th></th>
						<th></th>
						

					</tr>
				</thead>
				<tbody>
				<c:forEach var="user" items="${allUsers}">
						<tr>
							<td class="align-middle">${user.id}</td>
							<td class="align-middle">${user.username}</td>
							<td class="align-middle">${user.password}</td>
							<td class="align-middle">${user.firstName}</td>
							<td class="align-middle">${user.lastName}</td>
							<td class="align-middle">${user.address.id}</td>					
							<td class="align-middle">${user.enabled}</td>					
							<td class="align-middle"><a href="#" class="btn btn-update">Enable User</a></td>
							<td class="align-middle"><a href="disableUser.do?id=${user.id}" class="btn btn-danger">Disable User</a></td>
						</tr>
				</c:forEach>
			</tbody>
			</table>
			
			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>DESCRIPTION</th>
						<th>ADDRESS ID</th>
						<th>ENABLED</th>
						<th></th>
						<th></th>
						

					</tr>
				</thead>
				<tbody>
				<c:forEach var="location" items="${allLocations}">
						<tr>
							<td class="align-middle">${location.id}</td>
							<td class="align-middle">${location.name}</td>
							<td class="align-middle">${location.description}</td>
							<td class="align-middle">${location.address.id}</td>
							<td class="align-middle">${location.enabled}</td>					
							<td class="align-middle"><a href="#" class="btn btn-update">Enable Location</a></td>
							<td class="align-middle"><a href="disableLocation.do?id=${location.id}" class="btn btn-danger">Disable Location</a></td>
						</tr>
				</c:forEach>
			</tbody>
			</table>
	

	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>