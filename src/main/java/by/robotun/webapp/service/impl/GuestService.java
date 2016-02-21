package by.robotun.webapp.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.robotun.webapp.dao.ICategoryDAO;
import by.robotun.webapp.dao.ICityDAO;
import by.robotun.webapp.dao.ISubcategoryDAO;
import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.domain.Legal;
import by.robotun.webapp.domain.Physical;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddUserLegalForm;
import by.robotun.webapp.form.AddUserPhysicalForm;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.ServiceParamConstant;

@Service
public class GuestService implements IGuestService {
	
	@Autowired
	private ICityDAO cityDAO;
	
	@Autowired
	private ISubcategoryDAO subcategoryDAO;
	
	@Autowired
	private ICategoryDAO categoryDAO;
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<City> getAllCities() throws ServiceException {
		List<City> cities;
		try {
			cities = cityDAO.selectAllCities();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return cities;
	}

	@Override
	public List<Subcategory> getAllSubcategories() throws ServiceException {
		List<Subcategory> subcategories;
		try {
			subcategories = subcategoryDAO.selectAllSubcategories();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return subcategories;
	}

	@Override
	public List<Category> getAllCategories() throws ServiceException {
		List<Category> categories;
		try {
			categories = categoryDAO.selectAllCategories();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return categories;
	}

	@Override
	public void addUserPhysical(AddUserPhysicalForm addUserPhysicalForm) throws ServiceException {
		User user = new User();
		Physical physical = new Physical();
		user.setLogin(addUserPhysicalForm.getLogin());
		user.setIdCity(addUserPhysicalForm.getIdCity());
		user.setIdRole(ServiceParamConstant.ID_ROLE_USER_PHYSICAL);
		user.setRegistrationDate(new Date());
		
		String md5Password = DigestUtils.md5Hex(addUserPhysicalForm.getPassword());
		user.setPassword(md5Password);
		
		physical.setName(addUserPhysicalForm.getName());
		physical.setSurname(addUserPhysicalForm.getSurname());
		physical.setMiddleName(addUserPhysicalForm.getMiddleName());
		user.setPhysical(physical);
		
		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void addUserLegal(AddUserLegalForm addUserLegalForm) throws ServiceException {
		User user = new User();
		Legal legal = new Legal();
		user.setLogin(addUserLegalForm.getLogin());
		user.setIdCity(addUserLegalForm.getIdCity());
		user.setIdRole(ServiceParamConstant.ID_ROLE_USER_LEGAL);
		user.setRegistrationDate(new Date());
		
		String md5Password = DigestUtils.md5Hex(addUserLegalForm.getPassword());
		user.setPassword(md5Password);
		
		legal.setAddress(addUserLegalForm.getAddress());
		legal.setNameEnterprise(addUserLegalForm.getNameEnterprise());
		legal.setUnp(addUserLegalForm.getUnp());
		legal.setZipCode(addUserLegalForm.getZipCode());
		user.setLegal(legal);
		
		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
