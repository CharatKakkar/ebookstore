<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>

</head>
<body onload='document.loginForm.username.focus();'>
	<div class="container">
		<div class="row" id="pwd-cntainer">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<section class="login-form">					
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					<c:if test="${not empty logout}">
						<div class="msg">${logout}</div>
					</c:if>
					<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST' role="login">
						<img src="<c:url value="/resources/images/bookstore_logo.png" />" class="img-responsive" alt="" /> 
						<input type="text" name="username" placeholder="Username (Case Sensitive)"class="form-control input-lg" required="">
						<input type='password' name='password' placeholder="Password" class="form-control input-lg" required="" />
						<button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
			<div>	<a href="<c:url value="/registration/register"/>">Create account</a> &nbsp&nbsp&nbsp 
				<a href="<c:url value="/forgotPassword"/>">Forgot password?</a></div>
	
						<!-- 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />  -->
					</form>
				</section>
			<%@include file="/WEB-INF/views/template/footer.jsp"%>		
			</div>			
		</div>
	</div>
</body>
</html>