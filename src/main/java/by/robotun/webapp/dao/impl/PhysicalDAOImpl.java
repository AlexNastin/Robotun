package by.robotun.webapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IPhysicalDAO;
import by.robotun.webapp.domain.Physical;
import by.robotun.webapp.exception.DaoException;

@Repository("jpaPhysicalDAO")
public class PhysicalDAOImpl implements IPhysicalDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insertPhysical(Physical physical) throws DaoException {
		entityManager.persist(physical);
	}

}
