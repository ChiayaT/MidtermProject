
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Rumble Message</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
		<form action="updateMessage.do" method="post">
		<h3>Update Rumble Message</h3>
		<br>
		Title:Message:
		<input type="text" name="content" value="${message.content }"><br>
		<input type="hidden" name="id" value="${message.id }">
		<input type="hidden" name="userId" value="${message.user.id }">
		<input type="hidden" name="rumbleId" value="${message.rumble.id }">
		<br><button>Update Your Message</button>
		
		</form>
		

	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>