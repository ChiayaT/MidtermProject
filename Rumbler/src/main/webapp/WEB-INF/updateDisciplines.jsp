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
		<c:if test="${not empty updatedDiscipline }">
			<p class="lead text-success">Updated: ${updatedDiscipline}</p>
		</c:if>
		<c:if test="${not empty deletedDiscipline }">
			<p class="lead text-danger">Deleted: ${deletedDiscipline}</p>
			
			<a href="undoDelete.do?userId=${userDisciplineId.userId}&disciplineId=${userDisciplineId.disciplineId}" class="btn btn-update">Undo</a>
			
		</c:if>

		<c:forEach var="userDiscipline" items="${userDisciplines}">
			<h2 class="display-6">Update ${userDiscipline.discipline.name}:</h2>
			<form action="updateSpecificDiscipline.do" method="post"
				class="row g-3 bg-light">
				<input type="hidden" name="userId" value="${loggedInUser.id}">
				<input type="hidden" name="disciplineId"
					value="${userDiscipline.discipline.id}">
				<div class="col-md-2">
					<label for="fightingStance.id" class="form-label">Fighting
						Stance</label> <select name="fightingStance.id" class="form-select">

						<c:forEach var="stance" items="${allStances}">

							<c:choose>
								<c:when test="${userDiscipline.fightingStance.id == stance.id}">
									<option selected value="${stance.id}">${stance.stance}</option>
								</c:when>
								<c:otherwise>
									<option value="${stance.id}">${stance.stance}</option>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</select>
				</div>

				<div class="col-md-2">
					<label for="experienceLevel.id" class="form-label">Experience
						Level</label> <select name="experienceLevel.id" class="form-select">

						<c:forEach var="level" items="${allLevels}">
							<c:choose>
								<c:when test="${userDiscipline.experienceLevel.id == level.id }">
									<option selected value="${level.id}">${level.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${level.id }">${level.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>


					</select>
				</div>
				<div class="col-md-2">
					<br>
					<button type="submit" class="btn btn-update">Update
						Discipline</button>
				</div>
				<div class="col-md-2">
					<!-- FIX ME -->
					<br> <a href="deleteDiscipline.do?userId=${loggedInUser.id}&disciplineId=${userDiscipline.discipline.id}" class="btn btn-danger">Delete Discipline</a>
				</div>

			</form>
			<br>
		</c:forEach>

		<hr>
		<h2 class="display-6">Add New Discipline:</h2>
		<form action="addNewDiscipline.do" method="POST"
			class="row g-3 bg-light">
			<input type="hidden" name="userId" value="${loggedInUser.id}">


			<div class="col-md-2">
				<label for="discipline.id" class="form-label">Discipline</label> <select
					name="disciplineId" class="form-select">
					<c:forEach var="discipline" items="${allDisciplines}">
						<c:if test="${!loggedInUser.hasDiscipline(discipline.id)}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:if>

					</c:forEach>
				</select>
			</div>
			<div class="col-md-2">
				<label for="fightingStance.id" class="form-label">Fighting
					Stance</label> <select name="fightingStance.id" class="form-select">
					<c:forEach var="stance" items="${allStances}">
						<option value="${stance.id}">${stance.stance}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-2">
				<label for="experienceLevel.id" class="form-label">Experience
					Level</label> <select name="experienceLevel.id" class="form-select">
					<c:forEach var="level" items="${allLevels}">
						<option value="${level.id}">${level.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-md-2">
				<br>
				<button type="submit" class="btn btn-update">Add Discipline</button>
			</div>


		</form>



	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>