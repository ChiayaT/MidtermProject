<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create A New Rumble</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />

	<form action="createdMessage.do" method="post">
		<input type="hidden" name="userId" value="${user.id }">
		<input type="hidden" name="rumbleId" value="${Rumble.id }">
		<input type="hidden" name="enabled" value="true">
		<h3>Create a new Rumble</h3>
		<br>
		Message:
		<input type="text" name="content"><br>
		<br><button>Send Rumble Message</button>
	</form>

<jsp:include page="bootstrapScript.jsp" />
</body>
</html>