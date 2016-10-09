
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<script>
$(document).ready(function() {
	
$('#unitNumberS,#streetNumberS,#cityS,#provinceS,#countryS,#zipCodeS').hide();
$('#shipAdd').hide();

 	$('#answerIsYes').click(function(){
	 	  $('#unitNumberS,#streetNumberS,#cityS,#provinceS,#countryS,#zipCodeS').show();
	 	  $('#shipAdd').show();
	 	 copyFields();
	 	disableFields();
	  });	
  	$('#answerIsNo').click(function(){
  		$('#unitNumberS,#streetNumberS,#cityS,#provinceS,#countryS,#zipCodeS').show();
  		$('#shipAdd').show();
  		enableFields();
	  });  
} );

function copyFields(){
	  $('#unitNumberS').val($('#unitNumberB').val());
	  $('#streetNumberS').val($('#streetNumberB').val());
	  $('#cityS').val($('#cityB').val());	 
	  $('#provinceS').val($('#provinceB').val());	 
	  $('#countryS').val($('#countryB').val());	
	  $('#zipCodeS').val($('#zipCodeB').val()); 
}
function disableFields(){
	  $("#unitNumberS").attr("disabled", "disabled");
	  $("#streetNumberS").attr("disabled", "disabled");
	  $("#cityS").attr("disabled", "disabled");
	  $("#provinceS").attr("disabled", "disabled");
	  $("#countryS").attr("disabled", "disabled");
	  $("#zipCodeS").attr("disabled", "disabled");
}
function enableFields(){
	    $("#unitNumberS").removeAttr("disabled"); 
		$("#streetNumberS").removeAttr("disabled"); 
		$("#cityS").removeAttr("disabled"); 
		$("#provinceS").removeAttr("disabled"); 
		$("#countryS").removeAttr("disabled"); 
		$("#zipCodeS").removeAttr("disabled");   
}
</script>
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
				<a>User Details :</a>
				<input type="text" name="name"	placeholder="Username" required class="form-control input-lg" value="" /> 
				<input type="email" name="email" placeholder="Email" required class="form-control input-lg" value="" />
				<input name="firstPassword" type="password" class="form-control" id="password" placeholder="Password" required="" />
				<input type="password" class="form-control input-lg" id="confirm" placeholder="Confirm Password" required="" />
			<!--  	<div class="pwstrength_viewport_progress" id="pwstrength"></div> -->
				<a>Billing Address :</a><a class="glyphicon glyphicon-refresh" onclick="copyFields()"></a>
				<input type="text"id="unitNumberB"  name="unitNumberB" placeholder="Unit #" required class="form-control input-lg" value="" />
				<input type="text" id="streetNumberB" name="streetNumberB" placeholder="Street #" required class="form-control input-lg" value="" />
				<input type="text" id="cityB" name="cityB" placeholder="City" required class="form-control input-lg" value="" />
				<input type="text" id="provinceB" name="provinceB" placeholder="Province" required class="form-control input-lg" value="" />
				<input type="text" id="countryB"  name="countryB" placeholder="Country" required class="form-control input-lg" value="" />
				<input type="text" id="zipCodeB" name="zipCodeB" placeholder="Zip Code" required class="form-control input-lg" value="" />				
				<a>Are your Shipping & Billing address same? </a>
				<a id="answerIsYes" class="glyphicon glyphicon-thumbs-up" onclick="copyFields() disableFields()"></a>
				<a id="answerIsNo" class="glyphicon glyphicon-thumbs-down" onclick="enableFields()"></a>
			 <!--    <input id="answerIsYes" type="radio" name="answer" value="Yes"> Yes <input type="radio" id="answerIsNo" name="answer" value="No"> No<br>--> 
			    <a id="shipAdd">Shipping Address :</a>
				<input type="text" id="unitNumberS" name="unitNumberS" placeholder="Unit #" required class="form-control input-lg" value="" />
				<input type="text" id="streetNumberS" name="streetNumberS" placeholder="Street #" required class="form-control input-lg" value="" />
				<input type="text" id="cityS" name="cityS" placeholder="City" required class="form-control input-lg" value="" />
				<input type="text" id="provinceS" name="provinceS" placeholder="Province" required class="form-control input-lg" value="" />
				<input type="text" id="countryS" name="countryS" placeholder="Country" required class="form-control input-lg" value="" />
				<input type="text" id="zipCodeS" name="zipCodeS" placeholder="Zip Code" required class="form-control input-lg" value="" />
				
				<button type="submit" name="go"	class="btn btn-lg btn-primary btn-block">Sign Up</button>
				<div><a href="<c:url value="/registration" />">Create account</a> or <a	href="#">reset password</a> </div>
				</form>
				</section>
			</div>

			<div class="col-md-4"></div>
		

	</div>
	</div>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>
	</body>
	

</html>