package by.robotun.webapp.dao;

import by.robotun.webapp.domain.RejectMessage;
import by.robotun.webapp.exeption.DaoException;

public interface IRejectMessageDAO {
	
	public void insertRejectMessage(RejectMessage rejectMessage) throws DaoException;

}
