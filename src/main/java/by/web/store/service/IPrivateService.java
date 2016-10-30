package by.web.store.service;

import java.util.List;

import by.web.store.domain.User;
import by.web.store.exeption.ServiceException;

public interface IPrivateService {
	
	List<User> getUsersByRole(int idRole) throws ServiceException;
	
	void addUser(User user) throws ServiceException;

	void deleteUser(Integer idUser) throws ServiceException;

}
