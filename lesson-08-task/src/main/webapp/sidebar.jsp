<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/sidebar.css">
</head>
<body>
	<aside id="sidebar" class="sidebar">
		<button id="sidebar-close" class="close-button">×</button>
		<ul>
			<li><a href="home.jsp">Home</a></li>
			<li><a
				href="${pageContext.request.contextPath}/createProduct.jsp">Add
					Product</a></li>
			<li><a href="${pageContext.request.contextPath}/orders.jsp">Orders</a></li>
			<li><a href="#">Bricks</a></li>
			<li><a href="#">Employees</a></li>
			<li><a href="#">Settings</a></li>
		</ul>
	</aside>
	<script src="js/sidebar.js"></script>
</body>
</html>
