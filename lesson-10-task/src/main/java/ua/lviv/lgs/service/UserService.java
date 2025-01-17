package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.shared.AbstractCrud;

public interface UserService extends AbstractCrud<User> {
	User getUserByEmail(String email);

	boolean doesEmailExist(String email);
}
