package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bricks;
import ua.lviv.lgs.service.BricksService;
import ua.lviv.lgs.service.impl.BricksServiceImpl;

@WebServlet("/bricks")
public class BricksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BricksService bricksService = BricksServiceImpl.getBricksService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Bricks> bricks = bricksService.readAll();
		String json = new Gson().toJson(bricks);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}