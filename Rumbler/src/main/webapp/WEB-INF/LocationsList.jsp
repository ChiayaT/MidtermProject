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
	<div class="container">
		<h1>Rumble Rings</h1>
		<table class="table">
			<tbody>
				<c:forEach var="location" items="${locations}">
					<tr class="location-list"
						onclick="window.location='getLocation.do?locationId=${location.id}'">

						<c:choose>
							<c:when test="${empty location.image_url}">
								<td class="align-middle"><a
									href="getLocation.do?locationId=${location.id}"> <img
										src="images/rumbleRing.png" class="rounded-big"></a></td>
							</c:when>
							<c:otherwise>
								<td class="align-middle"><a
									href="getLocation.do?locationId=${location.id}"> <img
										src="${location.image_url}" class="rounded-big"></a></td>
							</c:otherwise>
						</c:choose>
						<td class="align-middle"><h1 class="display-3">${location.name}</h1>
							<h2>${location.description}</h2></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="createLocation.do" method="post"
			class="row g-3 bg-light" style="padding: 10px;">
			<h3>Submit A New Rumble Ring:</h3>

			<div class="col-md-6">
				<label for="name" class="form-label">Location Name</label> <input
					type="text" class="form-control" name="name" required>
			</div>
			<div class="col-md-2">
				<label for="locationType" class="form-label">Location Type</label> <select
					name="locationTypeId" class="form-select">
					<c:forEach var="locationType" items="${locationTypes}">
						<option value="${locationType.id}">${locationType.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-12">
				<label for="description" class="form-label">Description</label> <input
					type="text" class="form-control" name="description">
			</div>
			<div class="col-12">
				<label for="image_url" class="form-label">Image URL</label> <input
					type="text" class="form-control" name="image_url">
			</div>



			<h3>Address:</h3>
			<input type="hidden" name="location.enabled" value="true"> <input
				type="hidden" name="address.enabled" value="true">
			<div class="col-12">
				<label for="address.street" class="form-label">Street</label> <input
					type="text" class="form-control" name="address.street" required>
			</div>
			<div class="col-12">
				<label for="address.street2" class="form-label">Street</label> <input
					type="text" class="form-control" name="address.street2">
			</div>
			<div class="col-md-2">
				<label for="address.city" class="form-label">City</label> <input
					type="text" class="form-control" name="address.city" required>
			</div>
			<div class="col-md-2">
				<label for="address.state" class="form-label">State</label> <input
					type="text" class="form-control" name="address.state" required>
			</div>
			<div class="col-md-2">
				<label for="address.zipCode" class="form-label">Zip Code</label> <input
					type="text" class="form-control" name="address.zipCode" required>
			</div>
			<div class="col-md-6">
				<label for="address.phone" class="form-label">Phone</label> <input
					type="text" class="form-control" name="address.phone">
			</div>
			<div class="col-12">
				<button class="btn btn-update">Submit</button>
			</div>
		</form>
	</div>
	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>