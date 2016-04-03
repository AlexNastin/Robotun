package by.robotun.webapp.service;

import java.util.Date;
import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;

public interface IAutoloaderService {

	List<Lot> getLots(int offset, Date endDate) throws ServiceException;
	
	List<Lot> getMyLots(int offset, int idUser) throws ServiceException;
	
	List<Lot> getMyResponses(int offset, int idUser) throws ServiceException;

	List<Lot> getOnModeration(int offset) throws ServiceException;

	List<Lot> getLotsOnUpdate(Integer offset, int idUser) throws ServiceException;

}
