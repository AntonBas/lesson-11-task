package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.OrdersDao;
import ua.lviv.lgs.dao.impl.OrdersDaoImpl;
import ua.lviv.lgs.domain.Orders;
import ua.lviv.lgs.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	private static Logger LOGGER = Logger.getLogger(OrdersServiceImpl.class);
	private static OrdersServiceImpl ordersServiceImpl;
	private OrdersDao ordersDao;

	public OrdersServiceImpl() {
		try {
			ordersDao = new OrdersDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static OrdersService getOrdersService() {
		if (ordersServiceImpl == null) {
			ordersServiceImpl = new OrdersServiceImpl();
		}
		return ordersServiceImpl;
	}

	@Override
	public Orders create(Orders t) {
		return ordersDao.create(t);
	}

	@Override
	public Orders read(Integer id) {
		return ordersDao.read(id);
	}

	@Override
	public Orders update(Orders t) {
		return ordersDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		ordersDao.delete(id);
	}

	@Override
	public List<Orders> readAll() {
		return ordersDao.readAll();
	}

}
