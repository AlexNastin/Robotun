package by.robotun.webapp.dao.impl;

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
	public List<Lot> selectAllLots() throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAll").getResultList();
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
}
