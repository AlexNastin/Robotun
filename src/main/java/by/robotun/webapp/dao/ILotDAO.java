package by.robotun.webapp.dao;

import java.util.Date;
import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;

public interface ILotDAO {

	public List<Lot> selectAllLots(Date endDate) throws DaoException;
	
	public void updateLot(Lot lot) throws DaoException;
	
	public void deleteLot(Integer id) throws DaoException;
	
	public void insertLot(Lot lot) throws DaoException;
	
	public Lot selectLotById(int idLot) throws DaoException;
	
	public List<Lot> selectLotByCategory(int idCategory, Date endDate) throws DaoException;
	
	public List<Lot> selectLotByCategoryAndSubcategory(int idCategory, int idSubcategory, Date endDate) throws DaoException;

	public Date selectDateLotById(Integer idLot) throws DaoException;
	
	public List<Lot> selectLotsLimitOffset(int offset, Date date) throws DaoException;
	
	public List<Lot> selectLotsOnModeration() throws DaoException;

	public List<Lot> selectLotsCreatedUser(int idUser) throws DaoException;
	
	public List<Lot> selectLotsRespondedUser(int idUser) throws DaoException;
	
	public List<Lot> selectMyLotsLimitOffset(int offset, int idUser) throws DaoException;
	
	public List<Lot> selectMyResponsesLimitOffset(int offset, int idUser) throws DaoException;
	
	public Lot selectLotByIdForModeration(int idLot) throws DaoException;

	public List<Lot> selectOnModerationLimitOffset(int offset) throws DaoException;
	
	public List<Lot> selectLotsOnUpdateByUser(int idUser) throws DaoException;
	
	public List<Lot> selectLotsOnUpdateByUserLimitOffset(int offset, int idUser) throws DaoException;

	public List<Lot> selectLotsFiltering(String startDate, String endDate, Integer budgetFrom, Integer budgetTo,
			String desc) throws DaoException;

}
