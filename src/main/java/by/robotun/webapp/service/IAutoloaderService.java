package by.robotun.webapp.service;

import java.util.Date;
import java.util.List;

import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.ServiceException;

public interface IAutoloaderService {

	List<Lot> getLots(int offset, Date endDate) throws ServiceException;
	
	List<Lot> getLotsByCategoryAndSubcategory(Integer offset, Date endDate, Integer idCategory, Integer idSubcategory) throws ServiceException;
	
	List<Lot> getMyLots(int offset, int idUser) throws ServiceException;
	
	List<ArchiveLot> getArchiveLots(int offset, int idUser) throws ServiceException;
	
	List<Lot> getMyResponses(int offset, int idUser) throws ServiceException;

	List<Lot> getOnModeration(int offset) throws ServiceException;

	List<Lot> getLotsOnUpdate(Integer offset, int idUser) throws ServiceException;

	List<User> getModerators(Integer offset) throws ServiceException;

	List<Lot> getLotsFiltering(String endDate, Integer budgetFrom, Integer budgetTo, String desc, Integer idCity) throws ServiceException;

	List<Lot> getLotsFilteringOffset(String endDate, Integer budgetFrom, Integer budgetTo, String desc, Integer idCity, 
			Integer offset, Date date) throws ServiceException;

}
