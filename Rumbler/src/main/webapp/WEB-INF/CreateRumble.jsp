<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create A New Rumble</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />

	<form action="makeRumble.do" method="post">
		<h3>Create a new Rumble</h3>
		<br>
		Title:
		<input type="text" name="title"><br>
		Description:
		<input type="text" name="description"><br>
		Discipline:
		<select name="disciplineId">
		<c:forEach var="discipline" items="${disciplines}">
			<option value="${discipline.id}">${discipline.name }</option>
		</c:forEach>			
		</select><br>
		
		Rumble Date:
		<input type="date"  name="rumbleDate"><br>
		Start Time:
		<input type="time"  name="startTime"><br> 
		Approximate End Time:
		<input type="time"  name="endTime"><br>
		<select name="locationId">
		Location:
			<option value="" >Create a location</option>
		<c:forEach var="location" items="${locations}">
			<option value="${location.id }">${location.name }</option>
		</c:forEach>			
		</select><br>
		<%-- (If you chose a location, skip creating a location)<br>
		Create A Location:<br>
		Location Name:
		<input type="text"  name="name" required><br>
		Location Description:
		<input type="text" name="description"><br>
		Location Image Url:
		<input type="url" name="imageUrl"><br>
		Location Type:
		<select name="locationTypeId">
		<c:forEach var="locationType" items="${locationTypes}">
			<option value="${locationType.id}">${locationType.name }</option>
			<br>
		</c:forEach>
		</select><br>
		<h5>Address For Location</h5>
		<input type="hidden" name="address.enabled" value="true">
		Street<input type="text"  name="address.street" required><br>
		Street<input type="text"  name="address.street2" ><br>
		City<input type="text"  name="address.city" required><br>
		State<input type="text"  name="address.state" required><br>
		Zip Code<input type="text"  name="address.zipCode" required><br>
		Phone Number<input type="text"  name="address.phone"><br> --%>
		
		
		
		<!--  Location:<br>
		Name:<input type="text" name="location.name" required><br>
		Location Description:<input type="text" name="location.description" required><br>
		Location Image URL:<input type="url" name="location.image_url" ><br>
		Location Type:<input type="text" name="location.type" ><br>
		Location Address:<br>
		Street<input type="text"  name="location.address.street"><br>
		Street<input type="text"  name="location.address.street2"><br>
		City<input type="text"  name="location.address.city"><br>
		State<input type="text"  name="location.address.state"><br>
		Zip Code<input type="text"  name="location.address.zipCode"><br>
		Phone Number<input type="text"  name="location.address.phone"><br>-->
		<!-- Open To Public? 
		<input type="checkbox"  name="openToPublics"><br> -->
		<br><button>Create Your Rumble</button>
	</form>

<jsp:include page="bootstrapScript.jsp" />
</body>
</html>