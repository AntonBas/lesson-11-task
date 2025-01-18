$("button.buy-button").click(function() {
	var productId = $(this).data("id");
	$('#buyProductModal').modal('show');
	$(".buy-product").attr("product-id", productId);
});

$(".buy-product").click(function() {
	var productId = $(this).attr("product-id");

	$.post("bucket", { 'productId': productId }, function(data) {
		if (data == 'Success') {
			$('#buyProductModal').modal('hide');
			alert('Product successfully added to your bucket!');
		} else {
			alert('Error: Could not add the product.');
		}
	});
});
