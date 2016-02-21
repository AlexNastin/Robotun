package by.robotun.webapp.dao;

import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;

public interface IUserDAO {

	public User selectUserById(int idUser) throws DaoException;

	public User selectUser(String login) throws DaoException;
	
	public void insertUser(User user) throws DaoException;

}
