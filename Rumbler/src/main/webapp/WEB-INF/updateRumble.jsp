
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
		<option value="" >Create a location</option>
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
		</select><br>
		(If you chose a location, skip creating a location)<br>
		Create A Location:<br>
		Location Name:
		<input type="text" value="Only Change If Creating" name="name" required><br>
		Location Description:
		<input type="text" name="descriptionLoco" value="Only Change If Creating"><br>
		Location Image Url:
		<input type="url" name="imageUrl" value=""><br>
		Location Type:
		<select name="locationTypeId" >
		<c:forEach var="locationType" items="${locationTypes}">
			<option  value="${locationType.id}">${locationType.name }</option>
			<br>
		</c:forEach>
		</select><br>
		<h5>Address For Location</h5>
		<input type="hidden" name="Rumble.enabled" value="true">
		<input type="hidden" name="location.enabled" value="true">
		<input type="hidden" name="address.enabled" value="true">
		<input type="hidden" name="id" value="${Rumble.id }">
		Street<input type="text"  name="address.street" value="Only Change If Creating"required><br>
		Street<input type="text"  name="address.street2" value="Only Change If Creating"><br>
		City<input type="text"  name="address.city" required value="Only Change If Creating"><br>
		State<input type="text"  name="address.state" required value="Only Change If Creating"><br>
		Zip Code<input type="text"  name="address.zipCode" required value="Only Change If Creating"><br>
		Phone Number<input type="text"  name="address.phone" value="Only Change If Creating"><br>
		
		Open To Public? 
		<input type="checkbox"  name="openToPublics"><br>
		<br><button>Update Your Rumble</button>
		
		</form>


	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>