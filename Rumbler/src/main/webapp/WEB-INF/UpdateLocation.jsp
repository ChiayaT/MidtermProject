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

	<form action="updateLocation.do" >
		<h3>Update Location</h3>
		Name: <input type="text" value="${location.name}" name="name">
			<br> Image Url: <input type="text" value="${location.image_url}" name="imageUrl"><br>
		Address
		Street:<input type="text" value="${location.getAddress().getStreet()}" name="street"><br> 
		Street2:<input type="text" value="${location.getAddress().getStreet2()}" name="street2"><br> 
		City:<input type="text" value="${location.getAddress().getCity()}" name="city"><br> 
		State:<input type="text" value="${location.getAddress().getState()}" name="state"><br> 
		Zip Code:<input type="text" value="${location.getAddress().getZipCode()}" name="zipCode"><br> 
		Phone Number:<input type="number" value="${location.getAddress().getPhone()}" name="phone"><br> 
		<input type="hidden" value="${location.id}" name="id">
		<input type="hidden" value="${location.enabled}" name="enabled">
		<br>
		<button>Update ${location.name}</button>
	</form>

	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>