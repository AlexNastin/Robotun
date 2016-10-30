package by.web.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.web.store.dao.ICategoryDAO;
import by.web.store.domain.Color;
import by.web.store.domain.Cpu;
import by.web.store.domain.Os;
import by.web.store.domain.Producer;
import by.web.store.domain.Ram;
import by.web.store.domain.Role;
import by.web.store.domain.VideoCardModel;
import by.web.store.domain.VideoCardType;
import by.web.store.exeption.DaoException;
import by.web.store.exeption.ServiceException;
import by.web.store.service.ICatalogService;
import by.web.store.service.ISupportService;

@Component
public class SupportService implements ISupportService {
	
	@Autowired
//	private ICategoryDAO categoryDAO;

//	@Override
//	public List<Role> get() {
//		List<Role> roles = new ArrayList<>();
//		try {
//			roles = categoryDAO.selectAllCategories();
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return roles;
//	}

	@Override
	public List<Producer> getProducers() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cpu> getCpus() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ram> getRams() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VideoCardType> getVideoCardTypes() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VideoCardModel> getVideoCardModels() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Os> getOss() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
