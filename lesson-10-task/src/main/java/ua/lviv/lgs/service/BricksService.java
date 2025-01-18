package ua.lviv.lgs.service;

import java.util.Map;

import ua.lviv.lgs.domain.Bricks;
import ua.lviv.lgs.shared.AbstractCrud;

public interface BricksService extends AbstractCrud<Bricks> {
	public Map<Integer, Bricks> readAllMap();
}
