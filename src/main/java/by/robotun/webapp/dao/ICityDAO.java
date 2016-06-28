package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.City;
import by.robotun.webapp.exception.DaoException;

public interface ICityDAO {

	public List<City> selectAllCities() throws DaoException;
	
	public void updateCity(City city) throws DaoException;
	
	public void deleteCity(Integer id) throws DaoException;
	
	public void insertCity(City city) throws DaoException;

}
