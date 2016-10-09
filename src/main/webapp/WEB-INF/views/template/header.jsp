<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
								<li><a> Hi ${pageContext.request.userPrincipal.name }</a></li>
								<li><a href=" <c:url value="/cart"/>">Cart </a></li>
								<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name =='Admin'}">
								<li><a href="<c:url value="/admin/adminPage" />">Admin</a></li>
								<li><a href="<c:url value="/j_spring_security_logout"/>"></a></li>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<li><a href="<c:url value="/login" />">Login</a></li>
								<li><a href="<c:url value="registration" />">Register</a></li>
							</c:if>
						</ul>

					</div>
				</div>
			</nav>

		</div>
	</div>
	<!-- Carousel
================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide home-image"
					src="<c:url value="/resources/images/back1.jpg" />"
					alt="First slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>Welcome to eBook Store</h1>

						<p>Here you can browse and buy Books. Order Now for Your
							Amazing New Kit!</p>

					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide home-image"
					src="<c:url value="/resources/images/back2.jpg" />"
					alt="Second slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>Facts You Should Know About Music</h1>

						<p>Music brings joy, to all of our hearts, It's one of those,
							emotional arts.</p>

					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide home-image"
					src="<c:url value="/resources/images/back3.jpg" />"
					alt="Third slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>It's A Jazz Affair</h1>

						<p>Through ups and downs, Somehow I manage to survive in life.</p>

					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->

</body>