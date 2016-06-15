package by.robotun.webapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.IArchiveBetDAO;
import by.robotun.webapp.exeption.DaoException;

@Repository("jpaArchiveBetDAO")
public class ArchiveBetDAOImpl implements IArchiveBetDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long selectCountArchiveBetByLot(Integer idArchiveLot) throws DaoException {
		long count = (long) entityManager.createNamedQuery("ArchiveBet.findCountBetByLot").setParameter("id", idArchiveLot).getSingleResult();
		return count;
	}

	@Override
	public long selectCountArchiveBetByLotByUser(Integer idArchiveLot, Integer idUser) throws DaoException {
		long count = (long) entityManager.createNamedQuery("ArchiveBet.findCountBetByUserByLot").setParameter("idLot", idArchiveLot).setParameter("idUser", idUser).getSingleResult();
		return count;
	}
}
