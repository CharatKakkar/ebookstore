<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<script>
$(document).ready(function() {
	
$('#unitNumberS,#streetNumberS,#cityS,#provinceS,#countryS,#zipCodeS').hide();
$('#shipAdd').hide();
//$('#unitNumberB').val("");
} );
function clearBFields(){
	  $('#unitNumberB').val("");
	  $('#streetNumberB').val("");
	  $('#cityB').val("");	 
	  $('#provinceB').val("");	 
	  $('#countryB').val("");	
	  $('#zipCodeB').val(""); 	  
}
function copyFields(){
	  $('#unitNumberS').val($('#unitNumberB').val());
	  $('#streetNumberS').val($('#streetNumberB').val());
	  $('#cityS').val($('#cityB').val());	 
	  $('#provinceS').val($('#provinceB').val());	 
	  $('#countryS').val($('#countryB').val());	
	  $('#zipCodeS').val($('#zipCodeB').val()); 
	  $('#shipAdd').show();
	  $('#unitNumberS,#streetNumberS,#cityS,#provinceS,#countryS,#zipCodeS').show();
}
function clearSFields(){
	  $('#unitNumberS').val("");
	  $('#streetNumberS').val("");
	  $('#cityS').val("");	 
	  $('#provinceS').val("");	 
	  $('#countryS').val("");	
	  $('#zipCodeS').val(""); 
	  $('#shipAdd').show();
	  $('#unitNumberS,#streetNumberS,#cityS,#provinceS,#countryS,#zipCodeS').show();
}
function disableFields(){
	  $("#unitNumberS").attr("readonly", "readonly");
	  $("#streetNumberS").attr("readonly", "readonly");
	  $("#cityS").attr("readonly", "readonly");
	  $("#provinceS").attr("readonly", "readonly");
	  $("#countryS").attr("readonly", "readonly");
	  $("#zipCodeS").attr("readonly", "readonly");
}
function enableFields(){
	    $("#unitNumberS").removeAttr("readonly"); 
		$("#streetNumberS").removeAttr("readonly"); 
		$("#cityS").removeAttr("readonly"); 
		$("#provinceS").removeAttr("readonly"); 
		$("#countryS").removeAttr("readonly"); 
		$("#zipCodeS").removeAttr("readonly");
		$('#unitNumberS,#streetNumberS,#cityS,#provinceS,#countryS,#zipCodeS').show();
  		$('#shipAdd').show();
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
	<body onload='document.registerForm.name.focus();'>
		<div class="container">
	<div class="row" id="pwd-container">
		<div class="col-md-4"></div>
			<div class="col-md-4">
				<section class="login-form">
				<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<form:form action="${pageContext.request.contextPath}/registration/registrationData" name="registerForm" method="post" commandName="customer" role="login">
						<img src="<c:url value="/resources/images/bookstore_logo.png" />" class="img-responsive" alt="" /> 
				<a>User Details :</a><br>		
				<form:input path="userName" type="text" name="name"  placeholder="Username"  value=""  required="" class="form-control" /> <span style="color: #ff0000">${userError}</span><form:errors
                path="userName" cssStyle="color: #ff0000"/>
				<form:input type="email" name="email" path="emailId" placeholder="EmailId" required="" value=""  class="form-control" /><span style="color: #ff0000">${emailError}</span><form:errors
                path="emailId" cssStyle="color: #ff0000"/>
				<form:input name="firstPassword" type="password" path="password"  id="password" placeholder="Password" class="form-control"/><span style="color: #ff0000">${passwordError}</span><form:errors
                path="password" cssStyle="color: #ff0000"/><form:errors  path= "containsUsername" cssStyle="color: #ff0000"/>
				<form:input type="password" path="confirmPassword"  id="confirm" placeholder="Confirm Password"  class="form-control" /> <span style="color: #ff0000">${passwordError}</span><form:errors
                path="conditionTrue" cssStyle="color: #ff0000"/>
		       	<!-- <div class="pwstrength_viewport_progress" id="pwstrength"> </div> -->
				<a>Billing Address :</a><a class="glyphicon glyphicon-scissors" onclick="clearBFields()"></a>
				<form:input type="text" id="unitNumberB"  path ="billingAddress.apartmentNumber" name="unitNumberB" placeholder="Unit #" class="form-control" />
				<form:input type="text" id="streetNumberB" path ="billingAddress.streetAddress" name="streetNumberB" placeholder="Street #" class="form-control" required="" value="" />
				<form:input type="text" id="cityB" name="cityB" path ="billingAddress.city" placeholder="City" class="form-control" required="" value="" />
				<form:input type="text" id="provinceB" path ="billingAddress.state" name="provinceB" placeholder="Province" class="form-control" required="" value="" />
				<form:input type="text" id="countryB"  path ="billingAddress.country" name="countryB" placeholder="Country" class="form-control" required="" value="" />
				<form:input type="text" id="zipCodeB" path ="billingAddress.zipCode" name="zipCodeB" placeholder="Zip Code" class="form-control" required="" value="" />	<br>			
				<a>Is your Shipping & Billing address the same? </a>
				<a id="answerIsYes" class="glyphicon glyphicon-thumbs-up" onclick="copyFields(), disableFields()"></a>
				<a id="answerIsNo" class="glyphicon glyphicon-thumbs-down" onclick="clearSFields(), enableFields()" ></a>
			 <!--    <input id="answerIsYes" type="radio" name="answer" value="Yes"> Yes <input type="radio" id="answerIsNo" name="answer" value="No"> No<br>--> 
			    <a id="shipAdd">Shipping Address :</a><br>
				<form:input type="text" id="unitNumberS" path ="shippingAddress.apartmentNumber" name="unitNumberS" placeholder="Unit #" class="form-control" required="" value="" />
				<form:input type="text" id="streetNumberS" path ="shippingAddress.streetAddress" name="streetNumberS" placeholder="Street #" class="form-control" required="" value="" />
				<form:input type="text" id="cityS" path ="shippingAddress.city" name="cityS" placeholder="City" required="" class="form-control" value="" />
				<form:input type="text" id="provinceS" path ="shippingAddress.state" name="provinceS" placeholder="Province" class="form-control" required="" value="" />
				<form:input type="text" id="countryS" path ="shippingAddress.country" name="countryS" placeholder="Country" class="form-control" required="" value="" />
				<form:input type="text" id="zipCodeS" path ="shippingAddress.zipCode" name="zipCodeS" placeholder="Zip Code" class="form-control" required="" value="" />			
				<button type="submit" name="go"	class="btn btn-lg btn-primary btn-block">Sign Up</button>
				</form:form>
				</section>
			</div>
			<div class="col-md-4"></div>
	</div>
	</div>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>
	</body>
	

</html>