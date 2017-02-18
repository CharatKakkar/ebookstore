<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page session="true"%>
<html>
<head>
<title>Edit Address Information</title>

</head>
	<body onload='document.registerForm.name.focus();'>
		<div class="container">
	<div class="row" id="pwd-container">
		<div class="col-md-4"></div>
			<div class="col-md-4">
				<section class="login-form">
					<form:form  commandName="customer" role="login" class="form-horizontal">
						<img src="<c:url value="/resources/images/bookstore_logo.png" />" class="img-responsive" alt="" /> 
				<a>User Details :</a><br>		
				<form:input path="userName" type="text" name="name"  placeholder="Username"  class="form-control" readonly="true" />
				<form:input type="email" name="email" path="emailId" placeholder="EmailId" required="" value=""  class="form-control" readonly="true"  />
				
				<a>Billing Address :</a>
				<form:input type="text" id="unitNumberB"  path ="billingAddress.apartmentNumber" name="unitNumberB" placeholder="Unit #" class="form-control"  readonly="true"/>
				<form:input type="text" id="streetNumberB" path ="billingAddress.streetAddress" name="streetNumberB" placeholder="Street #" class="form-control" readonly="true" />
				<form:input type="text" id="cityB" name="cityB" path ="billingAddress.city" placeholder="City" class="form-control" readonly="true"/>
				<form:input type="text" id="provinceB" path ="billingAddress.state" name="provinceB" placeholder="Province" class="form-control" readonly="true" />
				<form:input type="text" id="countryB"  path ="billingAddress.country" name="countryB" placeholder="Country" class="form-control" readonly="true"/>
				<form:input type="text" id="zipCodeB" path ="billingAddress.zipCode" name="zipCodeB" placeholder="Zip Code" class="form-control" readonly="true" />	<br>			
			
			 <!--    <input id="answerIsYes" type="radio" name="answer" value="Yes"> Yes <input type="radio" id="answerIsNo" name="answer" value="No"> No<br>--> 
			    <a id="shipAdd">Shipping Address :</a><br>
				<form:input type="text" id="unitNumberS" path ="shippingAddress.apartmentNumber" name="unitNumberS" placeholder="Unit #" class="form-control" readonly="true" />
				<form:input type="text" id="streetNumberS" path ="shippingAddress.streetAddress" name="streetNumberS" placeholder="Street #" class="form-control" readonly="true" />
				<form:input type="text" id="cityS" path ="shippingAddress.city" name="cityS" placeholder="City" required="" class="form-control" readonly="true"/>
				<form:input type="text" id="provinceS" path ="shippingAddress.state" name="provinceS" placeholder="Province" class="form-control" readonly="true" />
				<form:input type="text" id="countryS" path ="shippingAddress.country" name="countryS" placeholder="Country" class="form-control" readonly="true" />
				<form:input type="text" id="zipCodeS" path ="shippingAddress.zipCode" name="zipCodeS" placeholder="Zip Code" class="form-control" readonly="true" />			
				<button id="editDetails" class="btn btn-default" name="_eventId_edit">Edit</button>
						<button id="Next" class="btn btn-default" name="_eventId_next">Next</button>
				</form:form>
				</section>
			</div>
			<div class="col-md-4"></div>
	</div>
	</div>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>
	</body>
</html>