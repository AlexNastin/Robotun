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
	public List<Lot> getLots(int limit, int offset, Date date) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectLotsLimitOffset(limit, offset, date);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	
}
