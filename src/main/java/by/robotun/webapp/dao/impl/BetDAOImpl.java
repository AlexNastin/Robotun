package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IBetDAO;
import by.robotun.webapp.domain.Bet;
import by.robotun.webapp.exeption.DaoException;

@Repository("jpaBetDAO")
public class BetDAOImpl implements IBetDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insertBet(Bet bet) throws DaoException {
		entityManager.persist(bet);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bet> selectAllBets() throws DaoException {
		List<Bet> bets = entityManager.createNamedQuery("Bet.findAll").getResultList();
		return bets;
	}

	@Override
	@Transactional
	public void deleteBet(Integer id) throws DaoException {
		Bet bet = entityManager.find(Bet.class, id);
		entityManager.remove(bet);
	}

	@Override
	@Transactional
	public void updateBet(Bet bet) throws DaoException {
		entityManager.merge(bet);
		
	}
}
