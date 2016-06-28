package by.robotun.webapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IRejectMessageDAO;
import by.robotun.webapp.domain.RejectMessage;
import by.robotun.webapp.exception.DaoException;

@Repository("jpaRejectMessageDAO")
public class RejectMessageDAOImpl implements IRejectMessageDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insertRejectMessage(RejectMessage rejectMessage) throws DaoException {
		entityManager.persist(rejectMessage);

	}
}
