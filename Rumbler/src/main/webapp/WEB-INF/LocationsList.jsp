<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumbler Locations</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h1>Rumble Rings</h1>
	<c:forEach var="location" items="${locations}">
	${location.name}<br>
	${location.description}<br>
		<a href="getLocation.do?locationId=${location.id}"> <img
			width="150" src="${location.image_url}">
		</td></a>
		<br>
		<!--${location.address}-->
	</c:forEach>
	<form action="createLocation.do" method="post">
		Create A Location:<br> Location Name: <input type="text"
			 name="name" required><br> Location
		Description: <input type="text" name="description"><br>
		Location Image Url: <input type="url" name="imageUrl"><br>
		Location Type: <select name="locationTypeId">
			<c:forEach var="locationType" items="${locationTypes}">
				<option value="${locationType.id}" name="locationTypeId">${locationType.name }</option>
				<br>
			</c:forEach>
		</select><br>
		<h5>Address For Location</h5>
		<input type="hidden" name="location.enabled" value="true">
		<input type="hidden" name="address.enabled" value="true">
		Street<input type="text" name="address.street" required><br>
		Street<input type="text" name="address.street2"><br>
		City<input type="text" name="address.city" required><br>
		State<input type="text" name="address.state" required><br>
		Zip Code<input type="text" name="address.zipCode" required><br>
		Phone Number<input type="text" name="address.phone"><br>
		<button class="btn btn-update">Submit</button>
	</form>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>