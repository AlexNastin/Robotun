package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IAutoloaderService;

@Component
public class AutoloaderService implements IAutoloaderService {

	@Autowired
	private ILotDAO lotDAO;
	
	@Override
	public List<Lot> getLots(int offset, Date date) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectLotsLimitOffset(offset, date);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getMyLots(int offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectMyLotsLimitOffset(offset, idUser);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getMyResponses(int offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectMyResponsesLimitOffset(offset, idUser);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getOnModeration(int offset) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectOnModerationLimitOffset(offset);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getLotsOnUpdate(Integer offset, int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectLotsOnUpdateByUserLimitOffset(offset, idUser);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

}
