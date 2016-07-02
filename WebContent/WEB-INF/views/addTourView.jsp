<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page to insert a new Tour</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<div style="width:80%; margin-left:5%">
		<form method="POST" action="../../../add/tour/new">
		  <fieldset class="form-group">
		    <label for="emailInput">Email address</label>
		    <input type="email" class="form-control" id="emailInput" placeholder="Enter email">
		    <small class="text-muted">We'll never share your email with anyone else.</small>
		  </fieldset>
		  <fieldset class="form-group">
		    <label for="description">Description</label>
		    <textarea class="form-control" id="description" name="description" rows="3"></textarea>
		  </fieldset>
		  <fieldset class="form-group">
		  	 <label>Address</label>
		  	 <input type="text" id="address" value="${address}">
		  </fieldset>

			<input type="hidden" id="lat" name="lat" value="${lat}">
			<input type="hidden" id="lng" name="lng" value="${lng}">
					  
		  <fieldset class="form-group">
		  	 <label>Tour Name</label>
		  	 <input type="text" id="tourName" name="tourName">
		  </fieldset>
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>