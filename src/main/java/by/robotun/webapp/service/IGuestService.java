package by.robotun.webapp.service;

import java.util.Date;
import java.util.List;

import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.PasswordResetToken;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.SignupUserLegalForm;
import by.robotun.webapp.form.SignupUserPhysicalForm;

public interface IGuestService {

	List<City> getAllCities() throws ServiceException;

	List<Subcategory> getAllSubcategories() throws ServiceException;

	List<Category> getAllCategories() throws ServiceException;

	List<Subcategory> getAllSubcategoryWithCategory(int idCategory) throws ServiceException;

	void addUserPhysical(SignupUserPhysicalForm addUserPhysicalForm) throws ServiceException;

	void addUserLegal(SignupUserLegalForm addUserLegalForm) throws ServiceException;

	List<Lot> getAllLots(Date endDate) throws ServiceException;

	List<Lot> getAllLotsByCategory(int idCategory, Date endDate) throws ServiceException;

	List<Lot> getAllLotsByCategoryAndSubcategory(int idCategory, int idSubcategory, Date endDate)
			throws ServiceException;

	User getUserById(int idUser) throws ServiceException;

	User getUser(String login) throws ServiceException;

	boolean createPasswordResetTokenForUser(User user, String token) throws ServiceException;

	void updateForgotPassword(User user, String password) throws ServiceException;

	PasswordResetToken getPasswordResetToken(String token) throws ServiceException;

	User getUser(int idUser) throws ServiceException;

	void updatePassword(String password, int idUser) throws ServiceException;
	
	long getCountBetByLot(Integer idLot) throws ServiceException;

	
}
