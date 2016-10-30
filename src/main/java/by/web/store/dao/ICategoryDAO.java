package by.web.store.dao;

import java.util.List;

import by.web.store.domain.Role;
import by.web.store.exeption.DaoException;

public interface ICategoryDAO {
	
	public List<Role> selectAllCategories() throws DaoException;
}
