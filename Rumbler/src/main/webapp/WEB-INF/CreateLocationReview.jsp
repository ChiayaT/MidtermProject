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
   <form action="giveLocationRating" method="post">
		<h3>Rate This Rumble Ring</h3>
		<br>
		<input type="hidden" value=${loggedInUser.id} name="userId">
		 <input type="hidden" value=${location.id} name="locationId">
		Rate From 1 to 5:
		<input type="number"  name="ratingScale"><br>
		Leave A Short Ramble About This Location:
		<input type="text"  name="ratingComment"><br>
		
		<br><button>Rate ${location.name}</button>
	</form>



    <jsp:include page="bootstrapScript.jsp" />
</body>
</html>