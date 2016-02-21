package by.robotun.webapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.ICityDAO;
import by.robotun.webapp.domain.City;

@Component
public class CityDAOImpl implements ICityDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertCity(City city) {
		city.setTitle("TRST");
		em.persist(city);
	}
}
