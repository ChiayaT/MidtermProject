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
<form action="createAccount.do" method="post">
		<h3>Create an Account</h3>
		<br>
		User name:
		<input type="text" name="username"><br>
		Password:
		<input type="text" name="password"><br>
		First name:
		<input type="text" name="firstName"><br>
		Last name:
		<input type="text"  name="lastName"><br>
		Date of Birth:
		<input type="date"  name="dateOfBirth"><br> 
		Height In Inches:
		<input type="number"  name="heightInInches"><br>
		Weight In Pounds:
		<input type="number"  name="weightInPounds"><br>
		Description:
		<input type="text"  name="description"><br>
		Profile Image URL:
		<input type="text"  name="profileImageURL"><br>
		Address:<br>
		Street<input type="text"  name="address.street"><br>
		Street<input type="text"  name="address.street2"><br>
		City<input type="text"  name="address.city"><br>
		State<input type="text"  name="address.state"><br>
		Zip Code<input type="text"  name="address.zipCode"><br>
		Phone Number<input type="text"  name="address.phone"><br>
		<br><button>Create Your Account</button>
	</form>


    <jsp:include page="bootstrapScript.jsp" />
</body>
</html>