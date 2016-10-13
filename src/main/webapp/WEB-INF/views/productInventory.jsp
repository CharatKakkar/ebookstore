	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<script>
$(document).ready(function() {
	   $('#productInventoryAdmin').DataTable( {
	  "lengthMenu": [[5, 10, 25, 50, -1], [5,10, 25, 50, "All"]]
	  // "pagingType": "full_numbers"
       ,
    });   
} );


</script>

<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image"
                 src="<c:url value="/resources/images/back1.jpg" />"
                 alt="First slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to eBook Store</h1>

                    <p>Here you can browse and buy Books. Order Now for
                        Your Amazing New Kit!</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image"
                 src="<c:url value="/resources/productImages/1.png" />"
                 alt="Second slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Facts You Should Know About Music</h1>

                    <p>Music brings joy, to all of our hearts, It's one of those, emotional arts.</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image"
                 src="<c:url value="/resources/images/back3.jpg" />"
                 alt="Third slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>It's A Jazz Affair</h1>

                    <p>Through ups and downs, Somehow I manage to survive in life.</p>

                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<div class="container-wrapper">	
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory admin page!</p>
        </div>

         <table id="productInventoryAdmin" class="display nowrap dataTable dtr-inline collapsed" cellspacing="0" role="grid" style="width:90%;">  
                <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>Info</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td ><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                    > <img src="<c:url value="/resources/productImages/${product.productId}.png"  />" alt="image"
                             style="width:30%"/> </a></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                    >&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-info-sign"></span></a></td>
                    <td><a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}" />"
                    >&nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}" />"
                    >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-remove-sign"></span></a></td>
                </tr>
                   
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
