<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>

</head>
<body onload='document.forgotPAsswordForm.username.focus();'>
	<div class="container">
		<div class="row" id="pwd-cntainer">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<section class="login-form">					
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<form:form name='forgotPAsswordForm' action="${pageContext.request.contextPath}/validateUsernameEmail" method='POST' commandName="customer" role="login">
						<img src="<c:url value="/resources/images/bookstore_logo.png" />" class="img-responsive" alt="" /> 
						<form:input path="userName" type="text" name="name"  placeholder="Username"  value=""  required="" class="form-control" /> <span style="color: #ff0000">${userError}</span><form:errors
                path="userName" cssStyle="color: #ff0000"/>
                		<form:input type="password" path="securityPhrase"  id="securityPhrase" placeholder="securityPhrase"  class="form-control" /> <span style="color: #ff0000">${passwordError}</span><form:errors
                path="securityPhrase" cssStyle="color: #ff0000"/>			
						<form:input name="firstPassword" type="password" path="password"  id="password" placeholder="Password" class="form-control"/><span style="color: #ff0000">${passwordError}</span><form:errors
                path="password" cssStyle="color: #ff0000"/><form:errors  path= "containsUsername" cssStyle="color: #ff0000"/>
				<form:input type="password" path="confirmPassword"  id="confirm" placeholder="Confirm Password"  class="form-control" /> <span style="color: #ff0000">${passwordError}</span><form:errors
                path="conditionTrue" cssStyle="color: #ff0000"/>
                
                				<form:input type="email" name="email" path="emailId" placeholder="EmailId" required="" value=""  class="form-control" /><span style="color: #ff0000">${emailError}</span><form:errors
                path="emailId" cssStyle="color: #ff0000"/>
			
						<button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Reset Password</button>

	
						<!-- 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />  -->
					</form:form>
				</section>
			<%@include file="/WEB-INF/views/template/footer.jsp"%>		
			</div>			
		</div>
	</div>
</body>
</html>