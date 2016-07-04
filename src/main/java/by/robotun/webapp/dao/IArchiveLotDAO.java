package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.exception.DaoException;

public interface IArchiveLotDAO {

	public List<ArchiveLot> selectArchiveLotsCreatedUser(int idUser) throws DaoException;

	public ArchiveLot selectArchiveLotById(Integer idArchiveLot) throws DaoException;

	public List<ArchiveLot> selectArchiveLotsLimitOffset(int offset, int idUser) throws DaoException;
	
	

	

}
