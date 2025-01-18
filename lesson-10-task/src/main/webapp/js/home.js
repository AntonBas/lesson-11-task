var bricks = null;

$.get("bricks", function(data) {
	if (data !== '') {
		bricks = data;
	}
}).done(function() {

	var cardsContent = "";
	jQuery.each(bricks, function(i, value) {

		cardsContent += "<div class='col'>" +
			"<div class='card'>" +
			"<div class='card-body'>" +
			"<h5 class='card-title'>" + value.type + "</h5>" +
			"<h6 class='card-subtitle mb-2 text-muted'>" + value.pricePerUnit + "</h6>" +
			"<p class='card-text'>" + value.stock + "</p>" +
			"<a href='Product?id=" + value.id + "' class='card-link'>link</a>" +
			"</div>" +
			"</div>" +
			"</div>" +
			"</div>"
	});

	$('#productCards').html(cardsContent);

});