package by.web.store.dao;

import java.util.List;

import by.web.store.domain.Cpu;
import by.web.store.exeption.DaoException;

public interface ICpuDAO {
	
	List<Cpu> selectCpus() throws DaoException;
}
