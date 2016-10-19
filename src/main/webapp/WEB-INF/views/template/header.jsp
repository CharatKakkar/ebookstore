<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>My eBook Store</title>

<!-- Angular JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"> </script>



<%--Jquery--%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.4.min.js"></script>



<%--Data Table--%>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Carousel CSS -->
<link href="<c:url value="/resources/css/carousel.css" />"
	rel="stylesheet">


<!-- Login CSS -->
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">


<!-- Main CSS -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">


</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<c:url value="/" /> ">eBookStore</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="<c:url value="/" /> ">Home</a></li>
							<li><a href="<c:url value="/product/productList/all" />">Products</a></li>
							<li><a href="<c:url value="/about" />">About Us</a></li>

						</ul>

						<ul class="nav navbar-nav pull-right">
						
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<li><a> Hello ${pageContext.request.userPrincipal.name }</a></li>
								<c:if test="${pageContext.request.userPrincipal.name =='admin'}">
								<li><a href="<c:url value="/admin/productInventory" />">Modify Inventory</a></li>
							</c:if>
								<c:if test="${pageContext.request.userPrincipal.name !='admin'}">
								<li><a href=" <c:url value="/cart"/>">Cart </a></li>
								</c:if>
								<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>								
							</c:if>							
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<li><a href="<c:url value="/login" />">Login</a></li>
								<li><a href="<c:url value="/registration/register" />">Register</a></li>
							</c:if>
						</ul>

					</div>
				</div>
			</nav>

		</div>
	</div>
	

</body>