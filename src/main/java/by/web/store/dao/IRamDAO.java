package by.web.store.dao;

import java.util.List;

import by.web.store.domain.Ram;
import by.web.store.exeption.DaoException;

public interface IRamDAO {
	
	List<Ram> selectRams() throws DaoException;
}
