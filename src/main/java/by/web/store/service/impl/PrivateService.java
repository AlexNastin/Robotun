package by.web.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.web.store.dao.IUserDAO;
import by.web.store.domain.User;
import by.web.store.exeption.DaoException;
import by.web.store.exeption.ServiceException;
import by.web.store.service.IPrivateService;

@Component
public class PrivateService implements IPrivateService {
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<User> getUsersByRole(int idRole) throws ServiceException {
		List<User> users = new ArrayList<>();
		try {
			users = userDAO.selectUsersByRole(idRole);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteUser(Integer idUser) throws ServiceException {
		try {
			userDAO.removeUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
