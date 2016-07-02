<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page to insert a new Tour</title>
	<!-- All the files that are required -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
	<link rel="stylesheet"
		href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link href='http://fonts.googleapis.com/css?family=Varela+Round'
		rel='stylesheet' type='text/css'>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1" />
	
	
	<spring:url value="/resources/css/loginRegister.css" var="testCSS" />
	<link href="${testCSS}" rel="stylesheet" />
	
	<spring:url value="/resources/js/loginRegister.js" var="register" />
	<script type="text/javascript" src="${register}"></script>
	
</head>
<body>



	<!-- Where all the magic happens -->
	<!-- LOGIN FORM -->
	<div id= "login" class="text-center" style="padding: 50px 0">
		<div class="logo">login on EverTour</div>
		<!-- Main Form -->
		<div class="login-form-1">
			<form id="login-form" class="text-left">
				<div class="login-form-main-message"></div>
				<div class="main-login-form">
					<div class="login-group">
						<div class="form-group">
							<label for="lg_username" class="sr-only">Username</label> <input
								type="text" class="form-control" id="lg_username"
								name="lg_username" placeholder="username">
						</div>
						<div class="form-group">
							<label for="lg_password" class="sr-only">Password</label> <input
								type="password" class="form-control" id="lg_password"
								name="lg_password" placeholder="password">
						</div>
						<div class="form-group login-group-checkbox">
							<input type="checkbox" id="lg_remember" name="lg_remember">
							<label for="lg_remember">remember</label>
						</div>
					</div>
					<button type="submit" class="login-button">
						<i class="fa fa-chevron-right"></i>
					</button>
				</div>
				<div class="etc-login-form" >
					<p>
						new user? <a href="#" id="createAccount"> create new account </a>
					</p>
				</div>
			</form>
		</div>
		<!-- end:Main Form -->
	</div>

	<!-- REGISTRATION FORM -->
	<div id="register" class="text-center" style="padding: 50px 0">
		<div class="logo">register as an EverTour guide</div>
		<!-- Main Form -->
		<div class="login-form-1">
			<form id="register-form" class="text-left" method="POST" action="register">
				<div class="login-form-main-message"></div>
				<div class="main-login-form">
					<div class="login-group">
						<div class="form-group">
							<label for="reg_username" class="sr-only">Email address</label> <input
								type="text" class="form-control" id="reg_username"
								name="reg_username" placeholder="username">
						</div>
						<div class="form-group">
							<label for="reg_password" class="sr-only">Password</label> <input
								type="password" class="form-control" id="reg_password"
								name="reg_password" placeholder="password">
						</div>
						<div class="form-group">
							<label for="reg_password_confirm" class="sr-only">Password
								Confirm</label> <input type="password" class="form-control"
								id="reg_password_confirm" name="reg_password_confirm"
								placeholder="confirm password">
						</div>

						<div class="form-group">
							<label for="reg_email" class="sr-only">Email</label> <input
								type="text" class="form-control" id="reg_email" name="reg_email"
								placeholder="email">
						</div>
						<div class="form-group">
							<label for="reg_fullname" class="sr-only">Full Name</label> <input
								type="text" class="form-control" id="reg_fullname"
								name="reg_fullname" placeholder="full name">
						</div>

						<div class="form-group login-group-checkbox">
							<input type="checkbox" class="" id="reg_agree" name="reg_agree">
							<label for="reg_agree">i agree with <a href="#">terms</a></label>
						</div>
					</div>
					<button type="submit" class="login-button">
						<i class="fa fa-chevron-right"></i>
					</button>
				</div>
				<div class="etc-login-form">
					<p>
						already have an account? <a href="#" id="alreadyHaveAccount">login here</a>
					</p>
				</div>
			</form>
		</div>
		<!-- end:Main Form -->
	</div>

</body>