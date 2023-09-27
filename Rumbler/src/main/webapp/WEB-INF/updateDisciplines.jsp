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
		<h1>Update Disciplines</h1>

		<c:forEach var="userDiscipline" items="${userDisciplines}">
			<h2 class="display-6">Update ${userDiscipline.discipline.name}:</h2>
			<form action="updateSpecificDiscipline.do" method="post"
				class="row g-3 bg-light">
				<input type="hidden" name="id" value="${userDiscipline.id}">
				<div class="col-md-2">
					<label for="userDiscipline.fightingStance.stance"
						class="form-label">Fighting Stance</label> <select
						name="userDiscipline.fightingStance.stance" class="form-select">
						<option selected>${userDiscipline.fightingStance.stance}</option>

						<c:forEach var="stance" items="${allStances}">
							<option>${stance.stance}</option>
						</c:forEach>
					</select>
				</div>

				<div class="col-md-2">
					<label for="userDiscipline.experienceLevel.name" class="form-label">Experience
						Level</label> <select name="userDiscipline.experienceLevel.name"
						class="form-select">
						<option selected>${userDiscipline.experienceLevel.name}</option>

						<c:forEach var="level" items="${allLevels}">
							<option>${level.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-2">
					<br>
					<!-- FIX ME -->
					<!-- <button type="submit" class="btn btn-update">Update Discipline</button>-->
					<br> <a href="#" class="btn btn-update">Update Discipline</a>
				</div>
				<div class="col-md-2">
					<br> <a href="#" class="btn btn-danger">Delete Discipline</a>
				</div>

			</form>
			<br>
		</c:forEach>






	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>