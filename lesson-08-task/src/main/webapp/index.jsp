<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login and Registration</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="container">
		<div class="form-container" id="login-form-container">
			<h1>Login</h1>
			<form class="form" action="login" method="post">
				<div class="form-group">
					<label for="login">Login :</label> <input type="text" name="login"
						required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						name="password" required>
				</div>
				<button type="submit">Login</button>
				<div class="switch-form">
					<button type="button" onclick="toggleForm('register')">Create
						an account</button>
				</div>
			</form>
		</div>

		<div class="form-container" id="register-form-container"
			style="display: none;">
			<h1>Register</h1>
			<form class="form" action="RegistrationServlet" method="post"
				onsubmit="return validateRegistrationForm()">
				<div class="form-group">
					<label for="firstName">First Name:</label> <input type="text"
						id="firstName" name="firstName" required>
				</div>
				<div class="form-group">
					<label for="lastName">Last Name:</label> <input type="text"
						id="lastName" name="lastName" required>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="form-group">
					<label for="confirmPassword">Confirm Password:</label> <input
						type="password" id="confirmPassword" name="confirmPassword"
						required>
				</div>
				<button type="submit">Register</button>
				<div class="switch-form">
					<button type="button" onclick="toggleForm('login')">Back
						to Login</button>
				</div>
			</form>
		</div>

	</div>

	<script src="js/login.js"></script>
</body>
</html>
