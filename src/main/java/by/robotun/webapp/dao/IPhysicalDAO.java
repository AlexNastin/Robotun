package by.robotun.webapp.dao;

import by.robotun.webapp.domain.Physical;
import by.robotun.webapp.exception.DaoException;

public interface IPhysicalDAO {
	
	public void insertPhysical(Physical physical) throws DaoException;

}
