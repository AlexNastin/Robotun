package by.robotun.webapp.dao;

import by.robotun.webapp.exception.DaoException;

public interface IArchiveBetDAO {

	public long selectCountArchiveBetByLot(Integer idArchiveLot) throws DaoException;
	
	public long selectCountArchiveBetByLotByUser(Integer idArchiveLot, Integer idUser) throws DaoException;

}
