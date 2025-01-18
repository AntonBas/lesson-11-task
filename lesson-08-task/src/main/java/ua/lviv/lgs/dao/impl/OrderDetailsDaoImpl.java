package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.OrderDetailsDao;
import ua.lviv.lgs.domain.OrderDetails;
import ua.lviv.lgs.utils.ConnectionUtils;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

	private static final String READ_ALL = "SELECT * FROM OrderDetails";
	private static final String CREATE = "INSERT INTO OrderDetails(`order_id`, `brick_id`, `quantity`, `price_per_unit`) VALUES (?, ?, ?, ?)";
	private static final String READ_BY_ID = "SELECT * FROM OrderDetails WHERE id = ?";
	private static final String UPDATE_BY_ID = "UPDATE OrderDetails SET order_id = ?, brick_id = ?, quantity = ?, price_per_unit = ? WHERE id = ?";
	private static final String DELETE_BY_ID = "DELETE FROM OrderDetails WHERE id = ?";

	private static Logger LOGGER = Logger.getLogger(OrderDetailsDaoImpl.class);
	private Connection connection;
	private PreparedStatement preparedStatement;

	public OrderDetailsDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public OrderDetails create(OrderDetails orderDetails) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, orderDetails.getOrderId());
			preparedStatement.setInt(2, orderDetails.getBrickId());
			preparedStatement.setInt(3, orderDetails.getQuantity());
			preparedStatement.setDouble(4, orderDetails.getPricePerUnit());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			orderDetails.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return orderDetails;
	}

	@Override
	public OrderDetails read(Integer id) {
		OrderDetails orderDetails = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				Integer orderId = result.getInt("order_id");
				Integer brickId = result.getInt("brick_id");
				Integer quantity = result.getInt("quantity");
				Double pricePerUnit = result.getDouble("price_per_unit");
				orderDetails = new OrderDetails(id, orderId, brickId, quantity, pricePerUnit);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return orderDetails;
	}

	@Override
	public OrderDetails update(OrderDetails orderDetails) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setInt(1, orderDetails.getOrderId());
			preparedStatement.setInt(2, orderDetails.getBrickId());
			preparedStatement.setInt(3, orderDetails.getQuantity());
			preparedStatement.setDouble(4, orderDetails.getPricePerUnit());
			preparedStatement.setInt(5, orderDetails.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return orderDetails;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<OrderDetails> readAll() {
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer id = result.getInt("id");
				Integer orderId = result.getInt("order_id");
				Integer brickId = result.getInt("brick_id");
				Integer quantity = result.getInt("quantity");
				Double pricePerUnit = result.getDouble("price_per_unit");
				orderDetailsList.add(new OrderDetails(id, orderId, brickId, quantity, pricePerUnit));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return orderDetailsList;
	}
}
