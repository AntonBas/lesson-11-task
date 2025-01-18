package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.OrdersDao;
import ua.lviv.lgs.domain.Orders;
import ua.lviv.lgs.utils.ConnectionUtils;

public class OrdersDaoImpl implements OrdersDao {

	private static String READ_ALL = "select * from orders";
	private static String CREATE = "insert into orders(`customer_first_name`, `customer_last_name`, `order_date`, `total_price`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from orders where id =?";
	private static String UPDATE_BY_ID = "update orders set customer_first_name = ?, customer_last_name = ?, order_date=?, total_price = ?,  where id = ?";
	private static String DELETE_BY_ID = "delete from orders where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public OrdersDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();

	}

	@Override
	public Orders create(Orders orders) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, orders.getCustomerFirstName());
			preparedStatement.setString(2, orders.getCustomerLastName());
			preparedStatement.setDate(3, new Date(orders.getOrderDate().getTime()));
			preparedStatement.setDouble(4, orders.getTotalPrice());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			orders.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public Orders read(Integer id) {
		Orders orders = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer ordersId = result.getInt("id");
			String customerFirstName = result.getString("customer_first_name");
			String customerLastName = result.getString("customer_last_name");
			java.util.Date orderDate = result.getDate("order_date");
			Double totalPrice = result.getDouble("total_price");
			orders = new Orders(ordersId, customerFirstName, customerLastName, orderDate, totalPrice);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public Orders update(Orders orders) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, orders.getCustomerFirstName());
			preparedStatement.setString(2, orders.getCustomerLastName());
			preparedStatement.setDate(3, new Date(orders.getOrderDate().getTime()));
			preparedStatement.setDouble(4, orders.getTotalPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;

	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> ordersRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer ordersId = result.getInt("id");
				String customerFirstName = result.getString("customer_first_name");
				String customerLastName = result.getString("customer_last_name");
				java.util.Date orderDate = result.getDate("order_date");
				Double totalPrice = result.getDouble("total_price");
				ordersRecords.add(new Orders(ordersId, customerFirstName, customerLastName, orderDate, totalPrice));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ordersRecords;
	}
}