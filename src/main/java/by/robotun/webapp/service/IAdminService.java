package by.robotun.webapp.service;

import java.util.List;

import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.form.AddModeratorForm;

public interface IAdminService {

	void addModerator(AddModeratorForm addModeratorForm) throws ServiceException;
	
	List<User> getAllStaffs() throws ServiceException;
	
	User getStaffById(int idUser) throws ServiceException;
	
	void deleteModerator(Integer id) throws ServiceException;

	void resetModeratorPassword(Integer idUser) throws ServiceException;
	
	void updatePasswordStaff(User userStaff) throws ServiceException;

}
