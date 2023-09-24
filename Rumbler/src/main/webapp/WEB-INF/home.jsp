<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumbler</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h1>Rumbler</h1>
	<form action="login.do" method="post">
		<input type="text" name="userName"> <input type="password"
			name="password" /> <input type="submit" value="Log In">
	</form>
	<jsp:include page="bootstrapScript.jsp" />
	<%@ include file="navbar.jsp"%>
	<h1>Rumbler</h1>
	<form action="login.do" method="post">
		<h3>Login To Your Account</h3>
		<br> User Name: <input type="text" name="username"
			required="required field"><br> Height In Inches: <input
			type="password" name="password" required="required field"><br>
	</form>
</body>
</html>