<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumbler</title>
<jsp:include page="bootstrapHead.jsp" /><
</head>
<body>
	<jsp:include page="navbar.jsp" />

<form action="updateAccount.do" method="post">
		<h3>Update User</h3>
		<br>

		<input type="hidden" value="${loggedInUser.id}" name="id">
		
		
		First name:
		<input type="text" value="${loggedInUser.firstName}" name="firstName"><br>
		Last name:
		<input type="text" value="${loggedInUser.lastName}" name="lastName"><br>
		<%-- Date of Birth:
		<input type="date" value="${loggedInUser.dateOfBirth}" name="dateOfBirth"><br> --%>
		Height In Inches:
		<input type="number" value="${loggedInUser.heightInInches}" name="heightInInches"><br>
		Weight In Pounds:
		<input type="number" value="${loggedInUser.weightInPounds}" name="weightInPounds"><br>
		Description:
		<input type="text" value="${loggedInUser.description}" name="description"><br>
		Profile Image URL:
		<input type="text" value="${loggedInUser.profileImageURL}" name="profileImageURL"><br>
		Address:
		Street<input type="text" value="${loggedInUser.address.street}" name="address.street"><br>
		Street<input type="text" value="${loggedInUser.address.street2}" name="address.street2"><br>
		City<input type="text" value="${loggedInUser.address.city}" name="address.city"><br>
		State<input type="text" value="${loggedInUser.address.state}" name="address.state"><br>
		Zip Code<input type="text" value="${loggedInUser.address.zipCode}" name="address.zipCode"><br>
		Phone Number<input type="text" value="${loggedInUser.address.phone}" name="address.phone"><br>
		<br><button>Update Your Account</button>
	</form>
<br>



	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>