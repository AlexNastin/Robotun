package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IAutoloaderService;

@Component
public class AutoloaderService implements IAutoloaderService {

	@Autowired
	private ILotDAO lotDAO;
	
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public List<Lot> getLots(int offset, Date date) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsLimitOffset(offset, date);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getMyLots(int offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectMyLotsLimitOffset(offset, idUser);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getMyResponses(int offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectMyResponsesLimitOffset(offset, idUser);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getOnModeration(int offset) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectOnModerationLimitOffset(offset);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getLotsOnUpdate(Integer offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsOnUpdateByUserLimitOffset(offset, idUser);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<User> getModerators(Integer offset) throws ServiceException {
		List<User> users = new ArrayList<User>();
		try {
			users = userDAO.selectAllModeratorsLimitOffset(offset);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public List<Lot> getLotsFiltering(String startDate, String endDate, Integer budgetFrom, Integer budgetTo,
			String desc) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsFiltering(startDate, endDate, budgetFrom, budgetTo, desc);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

}
