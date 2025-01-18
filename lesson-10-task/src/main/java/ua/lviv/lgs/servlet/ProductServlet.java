package ua.lviv.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.Bricks;
import ua.lviv.lgs.service.BricksService;
import ua.lviv.lgs.service.impl.BricksServiceImpl;

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	BricksService bricksService = BricksServiceImpl.getBricksService();

	// to create resource
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String pricePerUnit = request.getParameter("price_per_unit");
		String stock = request.getParameter("stock");

		Bricks bricks = new Bricks(type, getVallidatedPrice(pricePerUnit), getVallidatedStock(stock));
		bricksService.create(bricks);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	private double getVallidatedPrice(String pricePerUnit) {
		if (pricePerUnit == null || pricePerUnit.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(pricePerUnit);
	}

	private Integer getVallidatedStock(String stock) {
		if (stock == null || stock.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(stock);
	}

	// to get resource
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bricksId = request.getParameter("id");
		Bricks bricks = bricksService.read(Integer.parseInt(bricksId));

		request.setAttribute("bricks", bricks);
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
	}

	// to update resource
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
	}

	// to delete resource
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
	}

}
