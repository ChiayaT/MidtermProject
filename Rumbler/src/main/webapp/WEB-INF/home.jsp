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
	<%@ include file="navbar.jsp"%>
	<h1>Rumbler</h1>
	<p>Let's get ready to Rumbleeeeeeee!</p>
	<jsp:include page="bootstrapScript.jsp" />
<c:if test="${deleted == true}"> 
		<H1> ${userName} has been deleted </H1>
	 	</c:if> 
</body>
</html>