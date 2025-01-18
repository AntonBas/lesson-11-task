function toggleForm(formType) {
	const loginForm = document.getElementById('login-form-container');
	const registerForm = document.getElementById('register-form-container');

	if (formType === 'register') {
		loginForm.style.display = 'none';
		registerForm.style.display = 'block';
	} else {
		loginForm.style.display = 'block';
		registerForm.style.display = 'none';
	}
}

function validateRegistrationForm() {
	const password = document.getElementById('password').value;
	const confirmPassword = document.getElementById('confirmPassword').value;
	const email = document.getElementById('email').value;


	if (password.length < 8) {
		alert('Password must be at least 8 characters long.');
		return false;
	}

	if (password !== confirmPassword) {
		alert("Passwords do not match!");
		return false;
	}

	const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	if (!emailPattern.test(email)) {
		alert("Please enter a valid email address.");
		return false;
	}

	return true;
}
