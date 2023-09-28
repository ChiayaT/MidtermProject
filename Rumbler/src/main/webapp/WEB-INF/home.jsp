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

	<div class="box-area">

		<div class="banner-area text-center">
			<h1 class="display-1 ">Get Ready to Rumble!</h1><br>
			<c:if test= "${loggedInUser == null}">
			<a href="accountCreation.do" class="btn btn-update">Create Account</a>
			</c:if>
			<a href="getLocationsList.do" class="btn btn-update">See All Rumble Rings</a>
		</div>

		<div class="content-area">
			<div class="wrapper">
				<p>Having trouble finding a sparing partner? Rumbler is here to help you connect with other 
				combat sport practitioners.</p>

			</div>
		</div>
	</div>

	<c:if test="${deleted == true}">
		<h1>${userName} has been deleted</h1>
	</c:if>


	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>