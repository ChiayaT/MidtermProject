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
	<h1>Page Title Here</h1>

	<form action="updateLocation.do" method="POST" >
		<h3>Update Location</h3>
		
		<input type="hidden" value="${location.locationType.id}" name="locationType.id">
		<input type="hidden" value="${locationId}" name="id">
		<input type="hidden" value="${location.address.id}" name="address.id">
		<input type="hidden" value="${location.enabled}" name="enabled">
		Name: <input type="text" value="${location.name}" name="name">
			<br> Image Url: <input type="text" value="${location.image_url}" name="image_url"><br>
		Address<br>
		Street:<input type="text" value="${location.getAddress().getStreet()}" name="address.street"><br> 
		Street2:<input type="text" value="${location.getAddress().getStreet2()}" name="address.street2"><br> 
		City:<input type="text" value="${location.getAddress().getCity()}" name="address.city"><br> 
		State:<input type="text" value="${location.getAddress().getState()}" name="address.state"><br> 
		Zip Code:<input type="text" value="${location.getAddress().getZipCode()}" name="address.zipCode"><br> 
		Phone Number:<input type="number" value="${location.getAddress().getPhone()}" name="address.phone"><br> 
		Description:<input type="text" value="${location.description}" name="description"> 
		<br>
		<button>Update ${location.name}</button>
	</form>

	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>