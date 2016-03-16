package by.robotun.webapp.service;

import java.util.Date;
import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;

public interface IAutoloaderService {

	List<Lot> getLots(int limit, int offset, Date endDate) throws ServiceException;

}
