<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Brick Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/singleProduct.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%@ include file="sidebar.jsp"%>

	<div class="product-container">
		<div class="product-card">
			<h2 class="product-title">${bricks.type}</h2>
			<p class="product-price">Price per unit: $${bricks.pricePerUnit}</p>
			<p class="product-stock">Available stock: ${bricks.stock}</p>
			<button class="buy-button btn btn-primary" data-id="${bricks.id}">Buy
				Now</button>
		</div>
	</div>

	<!-- Modal for confirmation -->
	<div class="modal fade" id="buyProductModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Are you sure you want to buy this
					product?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary buy-product">Buy</button>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>

	<script src="js/singleProduct.js"></script>
</body>
</html>
