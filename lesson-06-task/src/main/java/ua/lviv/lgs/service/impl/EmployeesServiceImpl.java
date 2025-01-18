package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.EmployeesDao;
import ua.lviv.lgs.dao.impl.EmployeesDaoImpl;
import ua.lviv.lgs.domain.Employees;
import ua.lviv.lgs.service.EmployeesService;

public class EmployeesServiceImpl implements EmployeesService {

	private static Logger LOGGER = Logger.getLogger(EmployeesServiceImpl.class);
	private static EmployeesServiceImpl employeesServiceImpl;
	private EmployeesDao employeesDao;

	public EmployeesServiceImpl() {
		try {
			employeesDao = new EmployeesDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static EmployeesService getEmployeesService() {
		if (employeesServiceImpl == null) {
			employeesServiceImpl = new EmployeesServiceImpl();
		}
		return employeesServiceImpl;
	}

	@Override
	public Employees create(Employees t) {
		return employeesDao.create(t);
	}

	@Override
	public Employees read(Integer id) {
		return employeesDao.read(id);
	}

	@Override
	public Employees update(Employees t) {
		return employeesDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		employeesDao.delete(id);
	}

	@Override
	public List<Employees> readAll() {
		return employeesDao.readAll();
	}

}
