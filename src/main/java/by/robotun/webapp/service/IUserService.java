package by.robotun.webapp.service;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddLotForm;

public interface IUserService {

	public void addLot(AddLotForm addLotForm, int idUser) throws ServiceException;

	public Lot getLotById(Integer idLot) throws ServiceException;

	
	

}
