<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 50%;
	margin: auto;
	padding: 20px;
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
}

p {
	font-size: 1.2rem;
	text-align: center;
}

.btn {
	display: block;
	width: 200px;
	margin: 20px auto;
	padding: 10px;
	text-align: center;
	background-color: #4CAF50;
	color: white;
	font-size: 1rem;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.btn:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Welcome, ${userEmail}</h1>
		<p>You have successfully registered. Now you can access your
			profile and start browsing our magazines.</p>
		<a href="index.jsp" class="btn">Go to Homepage</a>
	</div>

</body>
</html>
