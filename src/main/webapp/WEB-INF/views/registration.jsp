
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>  
    
    	
		<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">  -->

		<!-- Website CSS style 
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">-->

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>   
    <%@include file="/WEB-INF/views/template/header.jsp"%>    
		<title>Registration</title>
	</head>
	<body>
		<div class="container">

	<div class="row" id="pwd-container">
		<div class="col-md-4"></div>

		<div class="col-md-4">
			<section class="login-form">
				<form method="post" action="#" role="login">
					<img src="<c:url value="/resources/images/bookstore_logo.png" />" class="img-responsive" alt="" /> 
					    <input type="text" name="name" placeholder="Username"
						required class="form-control input-lg"
						value="" /> 
						<input type="email" name="email" placeholder="Email"
						required class="form-control input-lg"	value="" /> 
											
						<input type="password"	class="form-control" id="password" placeholder="Password"
						required="" />
					
					<input type="password" class="form-control input-lg" id="confirm" placeholder="Confirm Password"
						required="" />
						<div class="pwstrength_viewport_progress" id="pwstrength"></div>
					<button type="submit" name="go"
						class="btn btn-lg btn-primary btn-block">Sign Up</button>
					<div>
						<a href="<c:url value="/registration" />">Create account</a> or <a href="#">reset password</a>
					</div>

				</form>

			</section>
		</div>

		<div class="col-md-4"></div>
		

	</div>
	</div>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>
	</body>
	

</html>