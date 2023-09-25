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

		<div class="banner-area">
			<h2 class="text-center">Get Ready to Rumble!</h2>
		</div>

		<div class="content-area">
			<div class="wrapper">

				<p>Add a lil description about the app here.</p>

			</div>
		</div>
	</div>

	<c:if test="${deleted == true}">
		<h1>${userName} has been deleted</h1>
	</c:if>


	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>