
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Rumble</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
		<form action="updateRumble.do" method="post">
		<h3>Update Rumble</h3>
		<br>
		Title:
		<input type="text" name="title" value="${Rumble.title }"><br>
		Description:
		<input type="text" name="descriptionRum" value="${Rumble.description }"><br>
		Discipline:
		<select name="disciplineId" >
		
		<c:forEach var="discipline" items="${disciplines}" >
			<c:choose>
						<c:when test="${Rumble.discipline.id == discipline.id }">
			<option selected value="${discipline.id}">${discipline.name }</option>
						</c:when>
						<c:otherwise>
			<option value="${discipline.id}">${discipline.name }</option>
						</c:otherwise>
			</c:choose>
		</c:forEach>			
		</select><br>
		
		Rumble Date:
		<input type="date"  name="rumbleDate" value="${Rumble.rumbleDate }"><br>
		Start Time:
		<input type="time"  name="startTime" value="${Rumble.startTime }"><br> 
		Approximate End Time:
		<input type="time"  name="endTime" value="${Rumble.endTime }"><br>
		<select name="locationId">
		Location:
		<c:forEach var="location" items="${locations}">
			<c:choose>
						<c:when test="${Rumble.location.id == location.id }">
			<option selected value="${location.id }">${location.name }</option>
						</c:when>
						<c:otherwise>
			<option value="${location.id }">${location.name }</option>
						</c:otherwise>
			</c:choose>
		</c:forEach>			
		</select>
		<br>
		<button>Update Your Rumble</button>
		
		</form>


	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>