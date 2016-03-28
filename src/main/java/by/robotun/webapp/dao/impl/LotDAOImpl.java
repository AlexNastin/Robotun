package by.robotun.webapp.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;
import by.robotun.webapp.service.ServiceParamConstant;

@Repository("jpaLotDAO")
public class LotDAOImpl implements ILotDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PropertyManager propertyManager;
	
	@Override
	@Transactional
	public void insertLot(Lot lot) throws DaoException {
		entityManager.persist(lot);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectAllLots(Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllActiveLot").setParameter("endDate", endDate).setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER).setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE))).getResultList();
		return lots;
	}
	
	@Override
	@Transactional
	public void deleteLot(Integer id) throws DaoException {
		Lot lot = entityManager.find(Lot.class, id);
		entityManager.remove(lot);
	}
	
	@Override
	@Transactional
	public void updateLot(Lot lot) throws DaoException {
		entityManager.merge(lot);
		
	}

	@Override
	public Lot selectLotById(int idLot) throws DaoException {
		Lot lot = null;
		try {
			lot = (Lot) entityManager.createNamedQuery("Lot.findLotById").setParameter("id", idLot).getSingleResult();
		} catch (NoResultException e) {
			throw new DaoException(e);
			
		}
		
		return lot;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotByCategory(int idCategory, Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotByCategory").setParameter("idCategory", idCategory).setParameter("endDate", endDate).setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotByCategoryAndSubcategory(int idCategory, int idSubcategory, Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotByCategoryAndSubcategory").setParameter("idCategory", idCategory).setParameter("idSubcategory", idSubcategory).setParameter("endDate", endDate).setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER).setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE))).getResultList();
		return lots;
	}

	@Override
	public Date selectDateLotById(Integer idLot) throws DaoException {
		Date endDate = (Date) entityManager.createNamedQuery("Lot.findDateLotById").setParameter("idLot", idLot).getSingleResult();
		return endDate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsLimitOffset(int offset, Date date) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllActiveLot").setParameter("endDate", date).setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER).setFirstResult(offset*limit).setMaxResults(limit).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsOnModeration() throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllLotOnModeration").setParameter("isVisible", ServiceParamConstant.ON_MODERATION_NUMBER).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsCreatedUser(int idUser) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsCreatedUser").setParameter("id", idUser).setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE))).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsRespondedUser(int idUser) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsRespondedUser").setParameter("id", idUser).setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE))).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectMyLotsLimitOffset(int offset, int idUser) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsCreatedUser").setParameter("id", idUser).setFirstResult(offset*limit).setMaxResults(limit).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectMyResponsesLimitOffset(int offset, int idUser) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsRespondedUser").setParameter("id", idUser).setFirstResult(offset*limit).setMaxResults(limit).getResultList();
		return lots;
	}
}
