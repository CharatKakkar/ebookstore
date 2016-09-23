<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<c:if test="${pageContext.request.userPrincipal.name != null }" >
			<p class="lead">Welcome : ${pageContext.request.userPrincipal.name}</p>
		</c:if>
			<a href="<c:url value="/j_spring_security_logout" />"> Logout </a>
				<a href="<spring:url value="/admin/productInventory" />">  Product Inventory </a>
		</div>

		<script src="<c:url value="/resources/js/controller.js" /> "></script>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>