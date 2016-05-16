package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;

public interface IUserDAO {

	public User selectUserById(int idUser) throws DaoException;
	
	public User selectModeratorById(int idUser) throws DaoException;

	public User selectUser(String login) throws DaoException;
	
	public void insertUser(User user) throws DaoException;
	
	public void deleteUser(Integer id) throws DaoException;
	
	public void updateUser(User user) throws DaoException;
	
	public List<User> selectAllModerators() throws DaoException;

	public List<User> selectAllModeratorsLimitOffset(int offset) throws DaoException;

	public User selectUserByIdWithCity(int idUser) throws DaoException;

}
