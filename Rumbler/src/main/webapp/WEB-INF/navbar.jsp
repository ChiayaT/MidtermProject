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

	<nav class="navbar navbar-expand-lg fixed-top" id="navbarFormat">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.do" id="navbarFormat"> <img
				src="images/logoWhite.png" alt="logo" height="30" /></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">


					<c:if test="${empty sessionScope.loggedInUser }">
						<li class="nav-item"><a class="nav-link nav-text"
							href="login.do">Login</a></li>
						<li class="nav-item"><a class="nav-link nav-text"
							aria-current="page" href="accountCreation.do">Create Account</a></li>
					</c:if>



					<c:if test="${not empty sessionScope.loggedInUser }">
						<li class="nav-item"><a class="nav-link nav-text"
							href="accountPage.do">Account</a></li>
						<li class="nav-item"><a class="nav-link nav-text"
							href="logout.do">Logout</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle nav-text" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Search for
								Rumbler </a>
							<ul class="dropdown-menu" id="navbarFormat">
								<li>
									<form class="d-flex" role="search" action="#">
										<input class="form-control me-2" type="search"
											placeholder="Search by Name or Username" aria-label="Search">
										<button class="btn btn-danger" type="submit">Search</button>
									</form>
								</li>
								<li><hr class="dropdown-divider"></li>
								<li>
									<form class="d-flex" role="search" action="#">
										<input class="form-control me-2" type="search"
											placeholder="Search by Zip Code" aria-label="Search">
										<button class="btn btn-danger" type="submit">Search</button>
									</form>
								</li>
								<li><hr class="dropdown-divider"></li>
								<li>
									<form class="d-flex" role="search" action="#">
										<input class="form-control me-2" type="search"
											placeholder="Search by Discipline" aria-label="Search">
										<button class="btn btn-danger" type="submit">Search</button>
									</form>
								</li>
							</ul></li>
					</c:if>
				</ul>

			</div>
		</div>
	</nav>

</body>
</html>