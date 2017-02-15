<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<html>
<head>
<title>Edit Address Information</title>

</head>
<body>

	<div class="container-wrapper">
		<div class="container">			
			<div class="jumbotron text-xs-center">
							<h1 class="display-3">Thank You for shopping with us!</h1>
				<hr>
<p class=" text-center">
					Here is your Order ID for future reference : <strong
						class="text-success">ORDER ID: ${order.orderId} </strong>
						
					</p>				
			<div class="col-md-25 text-center"><a class="btn btn-primary" href="<c:url value="/" />"
						role="button">Continue to homepage</a>
	
			</div>
			</div>	


<%@include file="/WEB-INF/views/template/footer.jsp"%>
	</div>
		</div>		
	
</body>
</html>