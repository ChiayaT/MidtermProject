
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
		<input type="text" name="description" value="${Rumble.description }"><br>
		Discipline:
		<select name="disciplineId" >
		<c:forEach var="discipline" items="${disciplines}" >
			<option value="${discipline.id}">${discipline.name }</option>
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
			<option value="${location.id }">${location.name }</option>
		</c:forEach>			
		</select><br>
		(If you chose a location, skip creating a location)<br>
		Create A Location:<br>
		Location Name:
		<input type="text" value="${Rumble.location.name }" name="name" required><br>
		Location Description:
		<input type="text" name="description" value="${Rumble.location.description }"><br>
		Location Image Url:
		<input type="url" name="imageUrl" value="${Rumble.location.image_url }"><br>
		Location Type:
		<select name="locationTypeId">
		<c:forEach var="locationType" items="${locationTypes}">
			<option value="${locationType.id}">${locationType.name }</option>
			<br>
		</c:forEach>
		</select><br>
		<h5>Address For Location</h5>
		<input type="hidden" name="address.enabled" value="true">
		Street<input type="text"  name="address.street" value="${Rumble.location.address.street }"required><br>
		Street<input type="text"  name="address.street2" value="${Rumble.location.address.street2 }"><br>
		City<input type="text"  name="address.city" required value="${Rumble.location.address.city }"><br>
		State<input type="text"  name="address.state" required value="${Rumble.location.address.state }"><br>
		Zip Code<input type="text"  name="address.zipCode" required value="${Rumble.location.address.zipCode }"><br>
		Phone Number<input type="text"  name="address.phone" value="${Rumble.location.address.phone }"><br>
		
		Open To Public? 
		<input type="checkbox"  name="openToPublics"><br>
		<br><button>Update Your Rumble</button>
		
		</form>


	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>