document.addEventListener('DOMContentLoaded', () => {
	const toggleButton = document.getElementById('sidebar-toggle');
	const closeButton = document.getElementById('sidebar-close');
	const sidebar = document.getElementById('sidebar');

	toggleButton.addEventListener('click', () => {
		sidebar.classList.add('open');
	});

	closeButton.addEventListener('click', () => {
		sidebar.classList.remove('open');
	});

	document.addEventListener('click', (event) => {
		if (!sidebar.contains(event.target) && !toggleButton.contains(event.target)) {
			sidebar.classList.remove('open');
		}
	});
});
