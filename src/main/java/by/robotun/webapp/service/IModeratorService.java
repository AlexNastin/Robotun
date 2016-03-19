package by.robotun.webapp.service;

import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.RejectMessageForm;

public interface IModeratorService {
	
	public List<Lot> getAllLotsOnModeration() throws ServiceException;

	public void addRejectMessage(RejectMessageForm rejectMessageForm, int idUser) throws ServiceException;
	
	public void confirmLot(Integer idLot) throws ServiceException;
}
