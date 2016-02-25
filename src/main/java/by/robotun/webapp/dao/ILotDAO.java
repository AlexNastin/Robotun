package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;

public interface ILotDAO {

	public List<Lot> selectAllLots() throws DaoException;
	
	public void updateLot(Lot lot) throws DaoException;
	
	public void deleteLot(Integer id) throws DaoException;
	
	public void insertLot(Lot lot) throws DaoException;
	
	public Lot selectLotById(int idLot) throws DaoException;

}
