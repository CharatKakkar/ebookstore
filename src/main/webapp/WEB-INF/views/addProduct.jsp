<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

       <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="productName" id="productName" class="form-Control" />
			</div>

			<div class="form-group">
				<label for="author">Author</label>
				<form:input path="author" id="author" class="form-Control" />
			</div>

<!-- 			<div class="form-group"> -->
<!--             <label for="category">Category</label> -->
<%--             <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" --%>
<%--                                                             value="Fiction" checked="checked"/>Fiction</label> --%>
<%--             <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" --%>
<%--                                                           value="AutoBiography" />AutoBiography</label> --%>
<%--             <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" --%>
<%--                                                            value="Encyclopedia" />Encyclopedia</label> --%>
<!--         </div> -->

 
<br>

        
        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="new" checked="checked" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="used" />Used</label>
        </div>

<!--         <div class="form-group"> -->
<!--             <label for="status">Status</label> -->
<%--             <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" --%>
<%--                                                              value="active" checked="checked" />Active</label> --%>
<%--             <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" --%>
<%--                                                              value="inactive" />Inactive</label> --%>
<!--         </div> -->

       

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
        </div>

        <br><br>
          <input type="submit" value="Submit" class="btn btn-success">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-warning">Cancel</a>
        </form:form>
                <%@include file="/WEB-INF/views/template/footer.jsp" %>
</div>
</div>

