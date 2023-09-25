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
	<h1>Update Account Details</h1>
		<form action="updateAccount.do" method="POST" class="row g-3 bg-light"
			style="padding: 10px;">
			<h3>My Profile</h3>
			<input type="hidden" name="id" value="${loggedInUser.id}">
			<div class="col-md-6">
				<label for="firstName" class="form-label">First Name</label> <input
					type="text" class="form-control" name="firstName"
					value="${loggedInUser.firstName}">
			</div>
			<div class="col-md-6">
				<label for="lastName" class="form-label">Last Name</label> <input
					type="text" class="form-control" name="lastName"
					value="${loggedInUser.lastName}">
			</div>

			<div class="col-md-2">
				<label for="heightInInches" class="form-label">Height In
					Inches</label> <input type="number" class="form-control"
					name="heightInInches" value="${loggedInUser.heightInInches}">
			</div>
			<div class="col-md-2">
				<label for="weightInPounds" class="form-label">Weight In
					Pounds</label> <input type="number" class="form-control"
					name="weightInPounds" value="${loggedInUser.weightInPounds}">
			</div>
			<div class="col-12">
				<label for="description" class="form-label">About Me</label> <input
					type="text" class="form-control" name="description"
					value="${loggedInUser.description}">
			</div>
			<div class="col-12">
				<label for="profileImageURL" class="form-label">Profile
					Image URL</label> <input type="text" class="form-control"
					name="profileImageURL" value="${loggedInUser.profileImageURL}">
			</div>
			<hr>
			<h3>Address</h3>
			<div class="col-12">
				<label for="address.street" class="form-label">Street</label> <input
					type="text" class="form-control" name="address.street"
					value="${loggedInUser.address.street}">
			</div>
			<div class="col-12">
				<label for="address.street2" class="form-label">Street</label> <input
					type="text" class="form-control" name="address.street2"
					value="${loggedInUser.address.street2}">
			</div>
			<div class="col-md-2">
				<label for="address.city" class="form-label">City</label> <input
					type="text" class="form-control" name="address.city"
					value="${loggedInUser.address.city}">
			</div>
			<div class="col-md-2">
				<label for="address.state" class="form-label">State</label> <input
					type="text" class="form-control" name="address.state"
					value="${loggedInUser.weightInPounds}">
			</div>

			<div class="col-md-2">
				<label for="address.zipCode" class="form-label">Zip Code</label> <input
					type="text" class="form-control" name="address.zipCode"
					value="${loggedInUser.address.zipCode}">
			</div>
			<div class="col-md-6">
				<label for="address.phone" class="form-label">Phone</label> <input
					type="text" class="form-control" name="address.phone"
					value="${loggedInUser.address.phone}">
			</div>


			<div class="col-12">
				<button type="submit" class="btn btn-update">Update
					Account Details</button>
			</div>
		</form>


	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>