package by.web.store.service;

import java.util.List;

import by.web.store.domain.Color;
import by.web.store.domain.Cpu;
import by.web.store.domain.Os;
import by.web.store.domain.Producer;
import by.web.store.domain.Ram;
import by.web.store.domain.VideoCardModel;
import by.web.store.domain.VideoCardType;
import by.web.store.exeption.ServiceException;

public interface ISupportService {
	
	List<Producer> getProducers() throws ServiceException;
	
	List<Cpu> getCpus() throws ServiceException;
	
	List<Ram> getRams() throws ServiceException;
	
	List<VideoCardType> getVideoCardTypes() throws ServiceException;
	
	List<VideoCardModel> getVideoCardModels() throws ServiceException;
	
	List<Color> getColors() throws ServiceException;
	
	List<Os> getOss() throws ServiceException;

}
