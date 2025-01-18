package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.BricksDao;
import ua.lviv.lgs.domain.Bricks;
import ua.lviv.lgs.utils.ConnectionUtils;

public class BricksDaoImpl implements BricksDao {

	private static String READ_ALL = "select * from bricks";
	private static String CREATE = "insert into bricks(`type`, `price_per_unit`, `stock`) values (?,?,?)";
	private static String READ_BY_ID = "select * from bricks where id =?";
	private static String UPDATE_BY_ID = "update bricks set type = ?, price_per_unit = ?, stock=?,  where id = ?";
	private static String DELETE_BY_ID = "delete from stock where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BricksDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Bricks create(Bricks bricks) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, bricks.getType());
			preparedStatement.setDouble(2, bricks.getPricePerUnit());
			preparedStatement.setInt(3, bricks.getStock());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			bricks.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bricks;
	}

	@Override
	public Bricks read(Integer id) {
		Bricks bricks = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer bricksId = result.getInt("id");
			String type = result.getString("type");
			Double pricePerUnit = result.getDouble("price_per_unit");
			Integer stock = result.getInt("stock");
			bricks = new Bricks(bricksId, type, pricePerUnit, stock);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bricks;
	}

	@Override
	public Bricks update(Bricks bricks) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, bricks.getType());
			preparedStatement.setDouble(2, bricks.getPricePerUnit());
			preparedStatement.setInt(3, bricks.getStock());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bricks;

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
	public List<Bricks> readAll() {
		List<Bricks> bricksRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer bricksId = result.getInt("id");
				String type = result.getString("type");
				Double pricePerUnit = result.getDouble("price_per_unit");
				Integer stock = result.getInt("stock");
				bricksRecords.add(new Bricks(bricksId, type, pricePerUnit, stock));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bricksRecords;
	}

}
