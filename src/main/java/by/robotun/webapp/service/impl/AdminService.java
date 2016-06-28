package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.form.AddModeratorForm;
import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;
import by.robotun.webapp.service.IAdminService;
import by.robotun.webapp.service.ServiceParamConstant;

@Component
public class AdminService implements IAdminService {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private PropertyManager propertyManager;

	@Override
	public void addModerator(AddModeratorForm addModeratorForm) throws ServiceException {
		User user = new User();
		user.setLogin(addModeratorForm.getLogin());
		user.setIdCity(ServiceParamConstant.ID_CITY_MINSK);
		user.setIdRole(ServiceParamConstant.ID_ROLE_MODERATOR);
		user.setRegistrationDate(new Date());
		user.setNickname(addModeratorForm.getLogin());
		String md5Password = DigestUtils.md5Hex(propertyManager.getValue(PropertyName.MODERATOR_DEFAULT_PASSWORD));
		user.setPassword(md5Password);
		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getAllStaffs() throws ServiceException {
		List<User> users = new ArrayList<>();
		try {
			users = userDAO.selectAllStaffs();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public User getStaffById(int idUser) throws ServiceException {
		User user;
		try {
			user = userDAO.selectStaffUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public void deleteModerator(Integer id) throws ServiceException {
		try {
			userDAO.deleteUser(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}		
	}

	@Override
	public void resetModeratorPassword(Integer idUser) throws ServiceException {
		try {
			User user = userDAO.selectStaffUser(idUser);
			String md5Password = DigestUtils.md5Hex(propertyManager.getValue(PropertyName.MODERATOR_DEFAULT_PASSWORD));
			user.setPassword(md5Password);
			userDAO.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	@Transactional
	public void updatePasswordStaff(User userStaff) throws ServiceException {
		try {
			userDAO.updateUser(userStaff);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
