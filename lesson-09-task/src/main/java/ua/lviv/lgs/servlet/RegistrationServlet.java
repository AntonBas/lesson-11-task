package ua.lviv.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (userService.doesEmailExist(email)) {
			request.setAttribute("error", "Email already exists. Please use a different email.");
			request.setAttribute("showRegisterForm", true);
			return;
		}

		if (password.length() < 8) {
			request.setAttribute("error", "Password must be at least 8 characters long.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (!password.equals(confirmPassword)) {
			request.setAttribute("error", "Passwords do not match.");
			return;
		}

		String emailPattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		if (!email.matches(emailPattern)) {
			request.setAttribute("error", "Invalid email format.");
			return;
		}

		if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
			userService.create(new User(email, firstName, lastName, UserRole.USER.toString(), password));
			request.setAttribute("userEmail", email);
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}