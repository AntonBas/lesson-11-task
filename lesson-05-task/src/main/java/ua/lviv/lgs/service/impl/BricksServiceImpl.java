package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.BricksDao;
import ua.lviv.lgs.dao.impl.BricksDaoImpl;
import ua.lviv.lgs.domain.Bricks;
import ua.lviv.lgs.service.BricksService;

public class BricksServiceImpl implements BricksService {

	private BricksDao bricksDao;

	public BricksServiceImpl() {
		try {
			bricksDao = new BricksDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Bricks create(Bricks t) {
		return bricksDao.create(t);
	}

	@Override
	public Bricks read(Integer id) {
		return bricksDao.read(id);
	}

	@Override
	public Bricks update(Bricks t) {
		return bricksDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bricksDao.delete(id);
	}

	@Override
	public List<Bricks> readAll() {
		return bricksDao.readAll();
	}
}
