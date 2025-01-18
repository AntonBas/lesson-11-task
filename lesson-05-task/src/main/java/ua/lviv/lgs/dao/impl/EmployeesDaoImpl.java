package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.EmployeesDao;
import ua.lviv.lgs.domain.Employees;
import ua.lviv.lgs.utils.ConnectionUtils;

public class EmployeesDaoImpl implements EmployeesDao {

	private static String READ_ALL = "select * from employees";
	private static String CREATE = "insert into employees(`first_name`, `last_name`, `position`, `salary`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from employees where id =?";
	private static String UPDATE_BY_ID = "update employees set first_name = ?, last_name = ?, position=?, salary = ?,  where id = ?";
	private static String DELETE_BY_ID = "delete from employees where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public EmployeesDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Employees create(Employees employees) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, employees.getFirstName());
			preparedStatement.setString(2, employees.getLastName());
			preparedStatement.setString(3, employees.getPosition());
			preparedStatement.setDouble(4, employees.getSalary());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			employees.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public Employees read(Integer id) {
		Employees employees = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer employeeId = result.getInt("id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String position = result.getString("position");
			Double salary = result.getDouble("salary");
			employees = new Employees(employeeId, firstName, lastName, position, salary);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public Employees update(Employees employees) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, employees.getFirstName());
			preparedStatement.setString(2, employees.getLastName());
			preparedStatement.setString(3, employees.getPosition());
			preparedStatement.setDouble(4, employees.getSalary());
			preparedStatement.setInt(5, employees.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;

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
	public List<Employees> readAll() {
		List<Employees> employeesRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer employeeId = result.getInt("id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String position = result.getString("position");
				Double salary = result.getDouble("salary");
				employeesRecords.add(new Employees(employeeId, firstName, lastName, position, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeesRecords;
	}
}