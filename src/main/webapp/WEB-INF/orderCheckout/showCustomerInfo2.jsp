<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>

</head>
<body>
	<form:form commandName="order" class="form-horizontal">


		<div class="container">
			<div class="row" id="pwd-container">
				<br> <br> <br> <br> <br> <br>
				<p>Order is</p>

				<p>${cart.customer.userName}</p>

				<p></p>

				
				<form:input type="text" id="state"
					path="cart.customer.billingAddress.state" name="countryB"
					placeholder="Country" class="form-control" required="" />
					
						</form:form>
				<input type="hidden" name="_flowExecutionKey" />
				
	<button class="btn btn-default" name="_eventId_next">Next</button>



	<%@include file="/WEB-INF/views/template/footer.jsp"%>

	</div>
	</div>
</body>
</html>