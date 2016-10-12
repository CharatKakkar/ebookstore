<%@include file="/WEB-INF/views/template/header.jsp" %>



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

						<p>Here you can browse and buy Books. Order Now for Your
							Amazing New Kit!</p>

					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide home-image"
					src="<c:url value="/resources/images/back2.jpg" />"
					alt="Second slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>Facts You Should Know About Books</h1>

						<p>Books brings joy, to all of our hearts, It's one of those,
							written arts.</p>

					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide home-image"
					src="<c:url value="/resources/images/back3.jpg" />"
					alt="Third slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>It's A Book Affair</h1>

						<p>Through Knowledge from the books, Somehow I manage to survive in life.</p>

					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            

            <h2>Instrument</h2>
            <p>Well crafted and delicate instruments.</p>

        </div><!-- /.col-lg-4 -->



    <div class="row">
        <div class="col-lg-4">
           

            <h2>Discography</h2>
            <p>An exceptional collections of music records in favor of the traditional and modern genre of jazz.</p>

        </div><!-- /.col-lg-4 -->

    <div class="row">
        <div class="col-lg-4">
          

            <h2>Accessories</h2>
            <p>All musical and related geeky goods..</p>

        </div><!-- /.col-lg-4 -->


    </div><!-- /.row -->

    <%@include file="/WEB-INF/views/template/footer.jsp" %>

