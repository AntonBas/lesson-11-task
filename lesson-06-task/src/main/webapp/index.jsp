<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f5f5f5;
}

.registration-form {
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 400px;
}

.registration-form h1 {
	text-align: center;
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.form-group input {
	width: 100%;
	padding: 8px;
	border: 1px solid #ddd;
	border-radius: 4px;
}

.form-group input:focus {
	border-color: #007bff;
	outline: none;
}

button {
	width: 100%;
	padding: 10px;
	border: none;
	background-color: #007bff;
	color: #fff;
	font-size: 16px;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<form class="registration-form" action="RegistrationServlet"
		method="post">
		<h1>Register</h1>
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
		<button type="submit">Register</button>
	</form>
</body>
</html>
