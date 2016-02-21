package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exeption.DaoException;

public interface ISubcategoryDAO {

	public List<Subcategory> selectAllSubcategories() throws DaoException;

}
