package by.robotun.webapp.service;

import java.util.Date;
import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.LotFormAdd;
import by.robotun.webapp.form.UpdatePersonalUserLegalForm;
import by.robotun.webapp.form.UpdatePersonalUserPhysicalForm;

public interface IUserService {

	public void addLot(LotFormAdd addLotForm, int idUser) throws ServiceException;

	public Lot getLotById(Integer idLot) throws ServiceException;
	
	public void addBet(String cost, int idUser, int idLot) throws ServiceException;
	
	public Date getDateLotById(Integer idLot) throws ServiceException;

	public void updatePersonalUserPhysical(UpdatePersonalUserPhysicalForm updatePersonalUserPhysicalForm, Integer idUser) throws ServiceException;

	public User getUserById(Integer idUser) throws ServiceException;

	public void updatePersonalUserLegal(UpdatePersonalUserLegalForm updatePersonalUserLegalForm, Integer idUser) throws ServiceException;

	public List<String> getPhonesStringByIdUser(Integer idUser) throws ServiceException;

	public List<Lot> getLotsCreatedUser(int idUser) throws ServiceException;
	
	public List<Lot> getLotsRespondedUser(int idUser) throws ServiceException;
	
	public Lot getLotByIdForModeration(Integer idLot) throws ServiceException;
	
	
	

}
