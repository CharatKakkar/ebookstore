<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">Here is the detail information of the product!</p>
		</div>

		<div class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-md-5">
					<img
						src="<c:url value="/resources/productImages/${product.productId}.png" /> "
						alt="image" style="width: 75%" />
				</div>

				<div class="col-md-5">
					<h3>${product.productName}</h3>
					<p>
						<strong>Description</strong> : ${product.productDescription}
					</p>

					<p>
						<strong>Category</strong> : ${product.productCategory}
					</p>
					<p>
						<strong>Condition</strong> : ${product.productCondition}
					</p>
					<p>
						<strong>Unit Price</strong> :${product.productPrice}CAD
					</p>
					<div ng-controller="cartCtrl">

						<p>
							<strong>Select Quantity if more than 1</strong> <select
								data-toggle="dropdown" class="btn btn-default dropdown-toggle"
								data-ng-model="qty">
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select> <br>
						</p>
						<!-- 
 <c:set var="role" scope="page" value="${param.role}" />
<c:out value = "${param.role}"/>
 <% System.out.println("role" + pageContext.findAttribute("role")); %>
                    <c:set var="url" scope="page" value="/product/productList" />
                    
                  <c:if test="${role='ROLE_ADMIN'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>
-->
						<p ng-controller="cartCtrl">
							<a href="<c:url value="/product/productList" />"
								class="btn btn-default">Back</a>
							<c:if test="${pageContext.request.userPrincipal.name !=null}">
								<c:if test="${pageContext.request.userPrincipal.name !='admin'}">

									<a href="#" class="btn btn-warning btn-large"
										ng-click="addToCart('${product.productId}','${product.productName}')"><span
										class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
									<a href="<spring:url value="/cart" />" class="btn btn-default"><span
										class="glyphicon glyphicon-hand-right"></span>View Cart</a>
								</c:if>
							</c:if>
						</p>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>