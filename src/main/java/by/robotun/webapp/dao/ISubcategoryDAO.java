package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exception.DaoException;

public interface ISubcategoryDAO {

	public List<Subcategory> selectAllSubcategories() throws DaoException;
	
	public List<Subcategory> selectAllSubcategoriesByCategory(int idCategory) throws DaoException;

}
