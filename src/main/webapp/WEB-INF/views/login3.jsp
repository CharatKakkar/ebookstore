<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container">
	<div class="row" id="pwd-container">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<section class="login-form">
				<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
					<img src="<c:url value="/resources/images/bookstore_logo.png" />"
						class="img-responsive" alt="" /> 
						<input type="text" name="username" placeholder="Username"  pattern="^\S{6,}$" class="form-control input-lg" /> 
						
						<input type="password"  placeholder="Password" pattern="^\S{6,}$" class="form-control input-lg" />
					<div class="pwstrength_viewport_progress"></div>
					<c:if test="${not empty error }" >
					<div class="error"> ${error}</div>
					</c:if>
					<button type="submit" name="go"
						class="btn btn-lg btn-primary btn-block">Sign in</button>
					<div>
						<a href="<c:url value="/registration" />">Create account</a> or <a
							href="#">reset password</a>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
					</div>
				</form>
			</section>
			<%@include file="/WEB-INF/views/template/footer.jsp"%>
		</div>
	</div>
</div>

