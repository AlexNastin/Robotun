package by.web.store.dao;

import java.util.List;

import by.web.store.domain.Producer;
import by.web.store.exeption.DaoException;

public interface IProducerDAO {
	
	List<Producer> selectProducers() throws DaoException;
}
