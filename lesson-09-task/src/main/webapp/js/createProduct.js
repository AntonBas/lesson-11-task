document.getElementById("add-brick-form").addEventListener("submit", function(event) {
	var type = document.getElementById("type").value;
	var pricePerUnit = document.getElementById("price_per_unit").value;
	var stock = document.getElementById("stock").value;

	if (type === "" || pricePerUnit === "" || stock === "") {
		alert("All fields are required!");
		event.preventDefault();
		return;
	}

	if (parseFloat(pricePerUnit) <= 0) {
		alert("Price per unit must be a positive number.");
		event.preventDefault();
		return;
	}

	if (parseInt(stock) <= 0 || isNaN(stock)) {
		alert("Stock quantity must be a positive integer.");
		event.preventDefault();
		return;
	}

	var product = {
		type: type,
		price_per_unit: pricePerUnit,
		stock: stock
	};

	fetch("Product", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: new URLSearchParams(product)
	})
		.then(response => response.text())
		.then(data => {
			if (data === "Success") {
				alert("Product added successfully!");
				document.getElementById("add-brick-form").reset();
			} else {
				alert("An error occurred, please try again.");
			}
		})
		.catch(error => {
			alert("An error occurred: " + error);
		});

	event.preventDefault();
});