package by.robotun.webapp.dao;

import java.util.Date;
import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;

public interface ILotDAO {

	List<Lot> selectAllLots(Date endDate) throws DaoException;

	void updateLot(Lot lot) throws DaoException;

	void deleteLot(Integer id) throws DaoException;

	void insertLot(Lot lot) throws DaoException;

	Lot selectLotById(int idLot) throws DaoException;

	int selectIdOwnerLot(int idLot) throws DaoException;

	List<Lot> selectLotByCategory(int idCategory, Date endDate) throws DaoException;

	List<Lot> selectLotByCategoryAndSubcategory(int idCategory, int idSubcategory, Date endDate) throws DaoException;

	Date selectDateLotById(Integer idLot) throws DaoException;

	List<Lot> selectLotsLimitOffset(int offset, Date date) throws DaoException;

	List<Lot> selectLotsOnModeration() throws DaoException;

	List<Lot> selectLotsCreatedUser(int idUser) throws DaoException;

	List<Lot> selectLotsRespondedUser(int idUser) throws DaoException;

	List<Lot> selectMyLotsLimitOffset(int offset, int idUser) throws DaoException;

	List<Lot> selectMyResponsesLimitOffset(int offset, int idUser) throws DaoException;

	Lot selectLotByIdForModeration(int idLot) throws DaoException;

	List<Lot> selectOnModerationLimitOffset(int offset) throws DaoException;

	List<Lot> selectLotsOnUpdateByUser(int idUser) throws DaoException;

	List<Lot> selectLotsOnUpdateByUserLimitOffset(int offset, int idUser) throws DaoException;

	List<Lot> selectLotsFiltering(String endDate, Integer budgetFrom, Integer budgetTo, String desc, Integer idCity)
			throws DaoException;

	List<Lot> selectLotsFilteringOffset(String endDate, Integer budgetFrom, Integer budgetTo, String desc,
			Integer idCity, Integer offset, Date date) throws DaoException;

	List<Lot> selectLotsByCategoryAndSubcategoryLimitOffset(int offset, Date endDate, int idCategory, int idSubcategory)
			throws DaoException;

	void callFunctionDeleteLotForTime() throws DaoException;
}
