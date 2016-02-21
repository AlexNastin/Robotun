package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.ICityDAO;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.exeption.DaoException;

@Repository("jpaCityDAO")
public class CityDAOImpl implements ICityDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Insert the object of type "City" to the database
	 * @param city object of type "City"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertCity(City city) throws DaoException {
		entityManager.persist(city);

	}

	/**
	 * Receipt of all elements of the table "cities" from the database
	 * @return cities collection of objects of type "City"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> selectAllCities() throws DaoException {
		List<City> cities = entityManager.createNamedQuery("City.findAll").getResultList();
		return cities;
	}

	/**
	 * Delete the object of type "City" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteCity(Integer id) throws DaoException {
		City city = entityManager.find(City.class, id);
		entityManager.remove(city);
	}

	/**
	 * Update the object of type "City" in the database
	 * @param city object of type "City"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateCity(City city) throws DaoException {
		entityManager.merge(city);
		
	}
}
