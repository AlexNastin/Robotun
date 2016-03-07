package by.robotun.webapp.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;

@Repository("jpaLotDAO")
public class LotDAOImpl implements ILotDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertLot(Lot lot) throws DaoException {
		entityManager.persist(lot);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectAllLots(Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllActiveLot").setParameter("endDate", endDate).getResultList();
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
			System.out.println(lot.toString());
			
		}
		
		return lot;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotByCategory(int idCategory, Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotByCategory").setParameter("idCategory", idCategory).setParameter("endDate", endDate).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotByCategoryAndSubcategory(int idCategory, int idSubcategory, Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotByCategoryAndSubcategory").setParameter("idCategory", idCategory).setParameter("idSubcategory", idSubcategory).setParameter("endDate", endDate).getResultList();
		return lots;
	}
}
