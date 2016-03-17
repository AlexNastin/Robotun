package by.robotun.webapp.service;

import java.util.List;

import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddModeratorForm;

public interface IAdminService {

	void addModerator(AddModeratorForm addModeratorForm) throws ServiceException;
	
	List<User> getAllModerators() throws ServiceException;
	
	User getModeratorById(int idUser) throws ServiceException;
	
	void deleteModerator(Integer id) throws ServiceException;

}
