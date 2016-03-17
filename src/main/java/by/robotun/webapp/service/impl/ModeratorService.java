package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IModeratorService;

@Component
public class ModeratorService implements IModeratorService {

	@Autowired
	private ILotDAO lotDAO;

	@Override
	public List<Lot> getAllLotsOnModeration() throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectLotsOnModeration();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return lots;
	}
	
}
