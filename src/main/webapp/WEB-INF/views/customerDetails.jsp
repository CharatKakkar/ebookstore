<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to edit a product:</p>
        </div>

		<form:form	action="${pageContext.request.contextPath}/admin/productInventory/updateProduct"
			method="post" commandName="myOrder" >
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="customer.userName" id="userName" class="form-Control"
					value="${myOrder.customer.userName}" />

			</div>

			
		</form:form>


		<%@include file="/WEB-INF/views/template/footer.jsp" %>\
        </div>
        </div>
