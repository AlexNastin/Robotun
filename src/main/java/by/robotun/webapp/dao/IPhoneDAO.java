package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.exception.DaoException;

public interface IPhoneDAO {

	public List<String> selectPhonesStringByIdUser(Integer idUser) throws DaoException;

}
