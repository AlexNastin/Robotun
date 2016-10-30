package by.web.store.dao;

import java.util.List;

import by.web.store.domain.User;
import by.web.store.exeption.DaoException;

public interface IUserDAO {
	
	User selectUser(String login) throws DaoException;
	
	List<User> selectUsersByRole(int idRole) throws DaoException;
	
	void insertUser(User user) throws DaoException;

	void removeUser(Integer idUser) throws DaoException;
}
