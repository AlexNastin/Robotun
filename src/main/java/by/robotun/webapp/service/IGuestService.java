package by.robotun.webapp.service;

import java.util.List;

import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.SignupUserLegalForm;
import by.robotun.webapp.form.SignupUserPhysicalForm;

public interface IGuestService {
	
	public List<City> getAllCities() throws ServiceException;
	
	public List<Subcategory> getAllSubcategories() throws ServiceException;
	
	public List<Category> getAllCategories() throws ServiceException;
	
	public List<Subcategory> getAllSubcategoryWithCategory(int idCategory) throws ServiceException;
	
	public void addUserPhysical(SignupUserPhysicalForm addUserPhysicalForm) throws ServiceException;

	public void addUserLegal(SignupUserLegalForm addUserLegalForm) throws ServiceException;
	
	public List<Lot> getAllLots() throws ServiceException;
	
	public List<Lot> getAllLotsByCategory() throws ServiceException;
	
	public List<Lot> getAllLotsByCategoryAndSubcategory() throws ServiceException;

	
	

}
