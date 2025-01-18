<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/createProduct.css">
<title>Add Brick</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="sidebar.jsp"%>

	<main>
		<div class="form-container">
			<h1>Add New Brick</h1>
			<p>Fill out the form below to add a new brick to the inventory.</p>

			<form id="add-brick-form" action="Product" method="POST"
				class="brick-form">
				<div class="form-group">
					<label for="type">Brick Type:</label> <input type="text" id="type"
						name="type" placeholder="Enter brick type" required />
				</div>
				<div class="form-group">
					<label for="price_per_unit">Price per Unit:</label> <input
						type="number" id="price_per_unit" name="price_per_unit"
						placeholder="Enter price" step="0.01" required />
				</div>
				<div class="form-group">
					<label for="stock">Stock Quantity:</label> <input type="number"
						id="stock" name="stock" placeholder="Enter stock quantity"
						required />
				</div>
				<div class="form-group">
					<button type="submit" class="submit-btn">Add Brick</button>
				</div>
			</form>
		</div>
	</main>

	<%@ include file="footer.jsp"%>
	<script src="js/createProduct.js"></script>
</body>
</html>
