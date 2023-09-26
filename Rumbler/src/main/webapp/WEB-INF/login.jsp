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
	<div class="container">
		<h1>Log In</h1>

		<form action="login.do" method="post">

			<div class="col-md-4">
				<label for="username" class="form-label">Username</label> <input
					type="text" class="form-control" name="username">
			</div>
			<div class="col-md-4">
				<label for="password" class="form-label">Password</label> <input
					type="password" class="form-control" name="password">
			</div>
			<br>
			<div class="col-12">
				<button type="submit" class="btn btn-update">Login</button>
			</div>
		</form>
	</div>


	<jsp:include page="bootstrapScript.jsp" />
</body>
</html>