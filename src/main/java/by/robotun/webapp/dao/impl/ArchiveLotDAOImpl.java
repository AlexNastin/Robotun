package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.IArchiveLotDAO;
import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;

@Repository("jpaArchiveLotDAO")
public class ArchiveLotDAOImpl implements IArchiveLotDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PropertyManager propertyManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArchiveLot> selectArchiveLotsCreatedUser(int idUser) throws DaoException {
		List<ArchiveLot> archiveLots = entityManager.createNamedQuery("ArchiveLot.findLotsCreatedUser").setParameter("id", idUser)
				.setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE)))
				.getResultList();
		return archiveLots;
	}
	
	@Override
	public ArchiveLot selectArchiveLotById(Integer idArchiveLot) throws DaoException {
		ArchiveLot archiveLot = null;
		try {
			archiveLot = (ArchiveLot) entityManager.createNamedQuery("ArchiveLot.findLotById").setParameter("id", idArchiveLot).getSingleResult();
		} catch (NoResultException e) {
			throw new DaoException(e);

		}
		return archiveLot;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArchiveLot> selectArchiveLotsLimitOffset(int offset, int idUser) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<ArchiveLot> archiveLots = entityManager.createNamedQuery("ArchiveLot.findLotsCreatedUser").setParameter("id", idUser)
				.setFirstResult(offset).setMaxResults(limit).getResultList();
		return archiveLots;
	}
}
