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
		<h1>Fellow Rumblers</h1>

			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th></th>
						<th>FIRST NAME</th>
						<th>LAST NAME</th>
						<th>USERNAME</th>
						<th>HEIGHT</th>
						<th>WEIGHT</th>

					</tr>
				</thead>
				<tbody>
				<c:forEach var="user" items="${users}">
					<c:if test="${user.id != loggedInUser.id }">
						<tr>
							<td class="align-middle text-center"><img src="${user.profileImageURL}" class="rounded"></td>
							<td class="align-middle">${user.firstName}</td>
							<td class="align-middle">${user.lastName}</td>
							<td class="align-middle">${user.username}</td>
							<td class="align-middle">${user.heightInInches} inches</td>
							<td class="align-middle">${user.weightInPounds} pounds</td>
							<c:forEach var="userDiscipline" items="${user.userDisciplines}">
							<td class="align-middle"><strong>Discipline:</strong> ${userDiscipline.discipline.name}<br>
							<strong>Experience Level:</strong> ${userDiscipline.experienceLevel.name}<br>
							<strong>Fighting Stance:</strong> ${userDiscipline.fightingStance.stance}<br>
							</td>
							</c:forEach>
							
							
							
							<td class="align-middle"><a href="makeRumble.do" class="btn btn-update">Create Rumble</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			</table>

	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>