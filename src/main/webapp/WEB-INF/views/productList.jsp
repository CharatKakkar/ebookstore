<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<script>
$(document).ready(function() {
	   $('#allProductListTable').DataTable( {
       "pagingType": "full_numbers",
    });   
} );
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

        <table id="allProductListTable" class="display nowrap dataTable dtr-inline collapsed" cellspacing="0" width="100%" role="grid" style="width: 100%;">  
                <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"
                             style="width:10%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} CAD</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
                   
            </c:forEach>
        </table>
        
       
</table>

 </div>
  </div>
  <menupopup id="m1">
	<menuitem label="Action" />
	<menuitem label="Another action" />
	<menuitem label="Something else here" />
	<menuseparator />
	<menuitem label="Separated link" />
</menupopup>
<div class="btn-group">
	<button dir="reverse" class="btn-default dropdown-toggle"
		popup="m1, after_start" iconSclass="caret">
		Action
	</button>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
