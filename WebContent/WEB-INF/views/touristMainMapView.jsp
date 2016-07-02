<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>EverTour</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<spring:url value="/resources/css/bootstrap.min.css" var="boostrap" />
<link href="${boostrap}" rel="stylesheet" />
<!--<link href="css/bootstrap.min.css" rel="stylesheet">  -->


<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<spring:url value="/resources/css/styles.css" var="testCSS" />
<link href="${testCSS}" rel="stylesheet" />

<!--  The following two are required to make pretty drop down select lists!!! -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>


</head>
<body>
	<!-- begin template -->
	<div class="navbar navbar-custom navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">EverTour</a> <a
				class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="register">Register</a></li>
				<li><a href="#">Link</a></li>
				<li>&nbsp;</li>
			</ul>
			<form class="navbar-form">
				<div class="form-group" style="display: inline;">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<span class="glyphicon glyphicon-chevron-down"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Category 1</a></li>
								<li><a href="#">Category 2</a></li>
								<li><a href="#">Category 3</a></li>
								<li><a href="#">Category 4</a></li>
								<li><a href="#">Category 5</a></li>
							</ul>
						</div>
						<input type="text" class="form-control"
							placeholder="What are searching for?"> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-search"></span> </span>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div id="map-canvas"></div>

	<div class="container-fluid" id="main">
		<div class="row">
			<div class="col-xs-4 col-md-4" id="left">

				<h2>EverTour Information</h2>

				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="">Buttons might go here</a>
					</div>
				</div>
				<p>
					<button onclick="getAllTours()">See what is around</button>
				</p>

				<hr>



				<div class="panel panel-default">
					<div class="panel-heading">Filter Tours</div>
				</div>

				<c:if test="${not empty tourCategories}">
					<div class="btn-group btn-input clearfix">
						<button type="button"
							class="btn btn-primary dropdown-toggle form-control"
							data-toggle="dropdown">
							<span data-bind="label">Select One</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu " role="menu">
							<c:forEach var="listValue" items="${tourCategories}">
								<li><a href="filterToursByCategory?catId=${listValue.id}">${listValue.name}</a></li>
								
							</c:forEach>
						</ul>
					</div>
				</c:if>


				<hr>


			</div>
			<div class="col-xs-8 col-md-8">
				<!--map-canvas will be postioned here-->
			</div>




		</div>
	</div>
	<!-- end template -->

	<!-- script references -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>

	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<script type="text/javascript" src="${bootstrapJs}"></script>
	<!-- <script src="js/bootstrap.min.js"></script> -->


	<spring:url value="/resources/js/map.js" var="mapjs" />
	<script src="${mapjs}"></script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDAmlVnV67VJg8y2x3Wu-LxedwvbIbiXZg&callback=initMap"
		async defer></script>

	<spring:url value="/resources/js/BootstrapDropdownscript.js"
		var="dropdown" />
	<script type="text/javascript" src="${dropdown}"></script>
	<!--  <script src="js/scripts.js"></script> -->

</body>
</html>