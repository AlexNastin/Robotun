package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.Bet;
import by.robotun.webapp.exeption.DaoException;

public interface IBetDAO {

	public List<Bet> selectAllBets() throws DaoException;
	
	public void updateBet(Bet bet) throws DaoException;
	
	public void deleteBet(Integer id) throws DaoException;
	
	public void insertBet(Bet bet) throws DaoException;

}