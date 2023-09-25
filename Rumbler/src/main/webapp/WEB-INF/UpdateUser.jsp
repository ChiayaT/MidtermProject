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

<form action="update.do" method="post">
		<h3>Update User</h3>
		<br>

		<input type="hidden" value=${user.id} name="id">
		Username:
		<input type="text" value="${user.username}" name="name" required="required field"><br>
		Password:
		<input type="text" value="${user.password}" name="password" required="required field"><br>
		First name:
		<input type="text" value="${user.firstName}" name="firstName"><br>
		Last name:
		<input type="text" value="${user.lastName}" name="lastName"><br>
		Date of Birth:
		<input type="date" value="${user.dateOfBirth}" name="dateOfBirth"><br>
		Address:
		<input type="text" value="${user.address}" name="address"><br>
		Height In Inches:
		<input type="number" value="${user.heightInInches}" name="heightInInches"><br>
		Weight In Pounds:
		<input type="number" value="${user.weightInPounds}" name="weightInPounds"><br>
		Description:
		<input type="text" value="${user.description}" name="description"><br>
		Profile Image URL:
		<input type="text" value="${user.profileImageUrl}" name="profileImageUrl"><br>
		
		<br><button>Update Your Account</button>
	</form>
<br>



	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>