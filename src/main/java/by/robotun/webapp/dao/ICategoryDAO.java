package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.Category;
import by.robotun.webapp.exeption.DaoException;

public interface ICategoryDAO {
	
	public List<Category> selectAllCategories() throws DaoException;
	
	public Category selectCategoryById(int idCategory) throws DaoException;
}
