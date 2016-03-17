package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddModeratorForm;
import by.robotun.webapp.service.IAdminService;
import by.robotun.webapp.service.ServiceParamConstant;

@Component
public class AdminService implements IAdminService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public void addModerator(AddModeratorForm addModeratorForm) throws ServiceException {
		User user = new User();
		user.setLogin(addModeratorForm.getLogin());
		user.setIdCity(ServiceParamConstant.ID_CITY_MINSK);
		user.setIdRole(ServiceParamConstant.ID_ROLE_MODERATOR);
		user.setRegistrationDate(new Date());
		String md5Password = DigestUtils.md5Hex(ServiceParamConstant.DEFAULT_PASSWORD);
		user.setPassword(md5Password);
		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getAllModerators() throws ServiceException {
		List<User> users = new ArrayList<>();
		try {
			users = userDAO.selectAllModerators();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public User getModeratorById(int idUser) throws ServiceException {
		return null;
	}

	
}
