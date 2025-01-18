package ua.lviv.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("login");
		String password = request.getParameter("password");
		User user = userService.getUserByEmail(email);

		if (user == null) {
			request.setAttribute("error", "User not found. Please check your email.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		if (user.getPassword().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getId());
			session.setAttribute("role", user.getRole().toString());
			request.setAttribute("userEmail", email);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Incorrect password. Please try again.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
