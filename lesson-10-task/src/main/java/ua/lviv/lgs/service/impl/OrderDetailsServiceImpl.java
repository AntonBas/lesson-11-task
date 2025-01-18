package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.OrderDetailsDao;
import ua.lviv.lgs.dao.impl.OrderDetailsDaoImpl;
import ua.lviv.lgs.domain.OrderDetails;
import ua.lviv.lgs.service.OrderDetailsService;

public class OrderDetailsServiceImpl implements OrderDetailsService {

	private static Logger LOGGER = Logger.getLogger(OrderDetailsServiceImpl.class);
	private static OrderDetailsServiceImpl orderDetailsServiceImpl;
	private OrderDetailsDao orderDetailsDao;

	public OrderDetailsServiceImpl() {
		try {
			orderDetailsDao = new OrderDetailsDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static OrderDetailsService getOrderDetailsService() {
		if (orderDetailsServiceImpl == null) {
			orderDetailsServiceImpl = new OrderDetailsServiceImpl();
		}
		return orderDetailsServiceImpl;
	}

	@Override
	public OrderDetails create(OrderDetails t) {
		return orderDetailsDao.create(t);
	}

	@Override
	public OrderDetails read(Integer id) {
		return orderDetailsDao.read(id);
	}

	@Override
	public OrderDetails update(OrderDetails t) {
		return orderDetailsDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		orderDetailsDao.delete(id);
	}

	@Override
	public List<OrderDetails> readAll() {
		return orderDetailsDao.readAll();
	}

}