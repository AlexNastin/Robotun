package by.robotun.webapp.service;

import java.util.List;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;

public interface IModeratorService {
	
	public List<Lot> getAllLotsOnModeration() throws ServiceException;
}
