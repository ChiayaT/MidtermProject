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
    <h1>${user.username} Account Deletion</h1>
	<p>Are You Sure You Want To Delete Your Account?</p>
	<br><br>    
	<a href="deleteUser.do"><button style="background-color: red; border-coler: black; color: white"> Delete ${user.username}</button></a>
	<br><a href="accountPage.do"><button>Do Not Delete My Account</button></a>

    <jsp:include page="bootstrapScript.jsp" />
</body>
</html>