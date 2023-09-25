<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rumbler</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg" id="navbarFormat">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.do" id="navbarFormat">
			<img src="images/logoWhite.png" alt="logo" height="30"/></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>

					<c:if test="${empty sessionScope.loggedInUser }">
						<li class="nav-item"><a class="nav-link" href="login.do">Login</a>
						</li>
					</c:if>



					<c:if test="${not empty sessionScope.loggedInUser }">
						<li><a href="account.do">Account</a></li>
						<li class="nav-item"><a class="nav-link" href="logout.do">Logout</a>
						</li>
					</c:if>




					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Drop Down We
							Might Want </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Link to Something</a></li>
							<li><a class="dropdown-item" href="#">Link to Something
									Else</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Another Thing</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">IGNORE
						THIS</button>
				</form>
			</div>
		</div>
	</nav>


	<a href="index.do">Home</a>
	<a href="login.do">Login</a>

</body>
</html>