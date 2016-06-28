package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.dao.IRejectMessageDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.RejectMessage;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.form.RejectMessageForm;
import by.robotun.webapp.service.IModeratorService;
import by.robotun.webapp.service.ServiceParamConstant;

@Component
public class ModeratorService implements IModeratorService {

	@Autowired
	private ILotDAO lotDAO;
	
	@Autowired
	private IRejectMessageDAO rejectMessageDAO;

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

	@Override
	public void addRejectMessage(RejectMessageForm rejectMessageForm, int idUser) throws ServiceException {
		RejectMessage rejectMessage = new RejectMessage();
		rejectMessage.setIdUser(idUser);
		System.err.println(rejectMessageForm.getIdLot());
		rejectMessage.setIdLot(rejectMessageForm.getIdLot());
		rejectMessage.setDate(new Date());
		rejectMessage.setMessage(rejectMessageForm.getText());
		try {
			rejectMessageDAO.insertRejectMessage(rejectMessage);
			Lot lot = lotDAO.selectLotById(rejectMessageForm.getIdLot());
			lot.setIsVisible(ServiceParamConstant.ON_UPDATE_NUMBER);
			lotDAO.updateLot(lot);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void confirmLot(Integer idLot) throws ServiceException {
		try {
			Lot lot = lotDAO.selectLotById(idLot);
			lot.setIsVisible(ServiceParamConstant.ON_PUBLIC_NUMBER);
			lotDAO.updateLot(lot);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
	}
	
}
