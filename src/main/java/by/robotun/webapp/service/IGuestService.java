package by.robotun.webapp.service;

import java.util.List;

import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddUserLegalForm;
import by.robotun.webapp.form.AddUserPhysicalForm;

public interface IGuestService {
	
	public List<City> getAllCities() throws ServiceException;
	
	public List<Subcategory> getAllSubcategories() throws ServiceException;
	
	public List<Category> getAllCategories() throws ServiceException;
	
	public List<Subcategory> getAllSubcategoryWithCategory(int idCategory) throws ServiceException;
	
	public void addUserPhysical(AddUserPhysicalForm addUserPhysicalForm) throws ServiceException;

	public void addUserLegal(AddUserLegalForm addUserLegalForm) throws ServiceException;

	
	

}
