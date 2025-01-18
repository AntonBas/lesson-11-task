package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.EmployeesDao;
import ua.lviv.lgs.dao.impl.EmployeesDaoImpl;
import ua.lviv.lgs.domain.Employees;
import ua.lviv.lgs.service.EmployeesService;

public class EmployeesServiceImpl implements EmployeesService {

	private EmployeesDao employeesDao;

	public EmployeesServiceImpl() {
		try {
			employeesDao = new EmployeesDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
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
