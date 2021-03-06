package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.IArchiveLotDAO;
import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.service.IAutoloaderService;

@Component
public class AutoloaderService implements IAutoloaderService {

	static final Logger LOGGER = Logger.getLogger(AutoloaderService.class);
	
	@Autowired
	private ILotDAO lotDAO;
	
	@Autowired
	private IArchiveLotDAO archiveLotDAO;

	@Autowired
	private IUserDAO userDAO;

	@Deprecated
	@Override
	public List<Lot> getLots(int offset, Date date) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsLimitOffset(offset, date);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Deprecated
	@Override
	public List<Lot> getLotsByCategoryAndSubcategory(Integer offset, Date endDate, Integer idCategory,
			Integer idSubcategory) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsByCategoryAndSubcategoryLimitOffset(offset, endDate, idCategory, idSubcategory);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getMyLots(int offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectMyLotsLimitOffset(offset, idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}
	
	@Override
	public List<ArchiveLot> getArchiveLots(int offset, int idUser) throws ServiceException {
		List<ArchiveLot> archiveLots = new ArrayList<ArchiveLot>();
		try {
			archiveLots = archiveLotDAO.selectArchiveLotsLimitOffset(offset, idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return archiveLots;
	}

	@Override
	public List<Lot> getMyResponses(int offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectMyResponsesLimitOffset(offset, idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getOnModeration(int offset) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectOnModerationLimitOffset(offset);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getLotsOnUpdate(Integer offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsOnUpdateByUserLimitOffset(offset, idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<User> getModerators(Integer offset) throws ServiceException {
		List<User> users = new ArrayList<User>();
		try {
			users = userDAO.selectAllModeratorsLimitOffset(offset);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public List<Lot> getLotsFiltering(String endDate, Integer budgetFrom, Integer budgetTo, String desc, Integer idCity)
			throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsFiltering(endDate, budgetFrom, budgetTo, desc, idCity);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getLotsFilteringOffset(String endDate, Integer budgetFrom, Integer budgetTo, String desc,
			Integer idCity, Integer offset, Date date) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsFilteringOffset(endDate, budgetFrom, budgetTo, desc, idCity, offset, date);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}
}
