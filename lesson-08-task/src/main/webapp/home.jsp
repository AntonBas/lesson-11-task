<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/home.css">
<title>Home</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="sidebar.jsp"%>

	<main>
		<h1>Welcome to Brick Factory ${userEmail}</h1>
		<p>This is the main content area.</p>
	</main>

	<%@ include file="footer.jsp"%>
</body>
</html>
