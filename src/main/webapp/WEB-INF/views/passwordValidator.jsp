<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row" id="pwd-container">
		<div class="col-md-4"></div>
			<div class="col-md-4">
				<section class="login-form">
				<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
<form:form action="<c:url value='/j_spring_security_check' />" method="post" commandName="currentCustomer" role="login">
<form:input path="userName" type="text" name="name"  placeholder="Username"  value=""  required="" class="form-control" /> <span style="color: #ff0000">${userError}</span><form:errors
                path="userName" cssStyle="color: #ff0000"/>
<form:input name="firstPassword" type="password" path="password"  id="password" placeholder="Password" required="" class="form-control"/><span style="color: #ff0000">${userError}</span><form:errors
                path="password" cssStyle="color: #ff0000"/>                
</form:form>
			</section>
			</div>
			<div class="col-md-4"></div>
	</div>
	</div>
</body>
</html>