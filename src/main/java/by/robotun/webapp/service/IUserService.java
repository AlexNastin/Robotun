package by.robotun.webapp.service;

import java.util.Date;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.LotFormAdd;

public interface IUserService {

	public void addLot(LotFormAdd addLotForm, int idUser) throws ServiceException;

	public Lot getLotById(Integer idLot) throws ServiceException;
	
	public void addBet(String cost, int idUser, int idLot) throws ServiceException;
	
	public Date getDateLotById(Integer idLot) throws ServiceException;

	
	

}
