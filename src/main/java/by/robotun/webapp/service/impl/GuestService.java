package by.robotun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IArchiveBetDAO;
import by.robotun.webapp.dao.IBetDAO;
import by.robotun.webapp.dao.ICategoryDAO;
import by.robotun.webapp.dao.ICityDAO;
import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.dao.IPasswordResetTokenDAO;
import by.robotun.webapp.dao.ISubcategoryDAO;
import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.Avatar;
import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.domain.Legal;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.PasswordResetToken;
import by.robotun.webapp.domain.Phone;
import by.robotun.webapp.domain.Physical;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.form.SignupUserLegalForm;
import by.robotun.webapp.form.SignupUserPhysicalForm;
import by.robotun.webapp.form.UpdateUserPasswordForm;
import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.ServiceParamConstant;

@Service
public class GuestService implements IGuestService {

	static final Logger LOGGER = Logger.getLogger(GuestService.class);
	
	@Autowired
	private IPasswordResetTokenDAO resetTokenDAO;

	@Autowired
	private ICityDAO cityDAO;

	@Autowired
	private ISubcategoryDAO subcategoryDAO;

	@Autowired
	private ICategoryDAO categoryDAO;

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private ILotDAO lotDAO;

	@Autowired
	private IBetDAO betDAO;
	
	@Autowired
	private IArchiveBetDAO archiveBetDAO;
	
	@Autowired
	private PropertyManager propertyManager;

	@Override
	public User getSaffUser(int idUser) throws ServiceException {
		try {
			return userDAO.selectStaffUser(idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<City> getAllCities() throws ServiceException {
		List<City> cities;
		try {
			cities = cityDAO.selectAllCities();
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
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
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return subcategories;
	}

	@Override
	public List<Subcategory> getAllSubcategoryWithCategory(int idCategory) throws ServiceException {
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
		if(idCategory == 0) {
			return subcategories;
		}
		try {
			subcategories = subcategoryDAO.selectAllSubcategoriesByCategory(idCategory);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
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
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return categories;
	}

	@Override
	public void addUserPhysical(SignupUserPhysicalForm addUserPhysicalForm) throws ServiceException {
		User user = new User();
		Physical physical = new Physical();
		Avatar avatar = new Avatar();
		List<Phone> phones = new ArrayList<Phone>();
		user.setLogin(addUserPhysicalForm.getLogin());
		user.setIdCity(addUserPhysicalForm.getIdCity());
		user.setIdRole(ServiceParamConstant.ID_ROLE_USER_PHYSICAL);
		StringBuilder nicknameBuilder = new StringBuilder(addUserPhysicalForm.getSurname());
		nicknameBuilder.append(" ");
		nicknameBuilder.append(addUserPhysicalForm.getName());
		user.setNickname(nicknameBuilder.toString());
		user.setRegistrationDate(new Date());

		String md5Password = DigestUtils.md5Hex(addUserPhysicalForm.getPassword());
		user.setPassword(md5Password);
		physical.setName(addUserPhysicalForm.getName());
		physical.setSurname(addUserPhysicalForm.getSurname());
		physical.setUser(user);
		user.setPhysical(physical);
		
		avatar.setPath(String.valueOf((new Random().nextInt(Integer.parseInt(propertyManager.getValue(PropertyName.AVATAR_INDEX_SIZE))+1))));
		avatar.setUser(user);
		user.setAvatar(avatar);

		String[] phoneMass = addUserPhysicalForm.getPhones();
		for (int i = 0; i < phoneMass.length; i++) {
			Phone phone = new Phone();
			phone.setTitle(phoneMass[i]);
			phone.setUser(user);
			phone.setIdOperator(1);
			phones.add(phone);
		}
		user.setPhones(phones);

		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	@Override
	public void addUserLegal(SignupUserLegalForm signupUserLegalForm) throws ServiceException {
		User user = new User();
		Legal legal = new Legal();
		Avatar avatar = new Avatar();
		List<Phone> phones = new ArrayList<Phone>();
		user.setLogin(signupUserLegalForm.getLogin());
		user.setIdCity(signupUserLegalForm.getIdCity());
		user.setIdRole(ServiceParamConstant.ID_ROLE_USER_LEGAL);
		String nameEnterprise = signupUserLegalForm.getNameEnterprise().replace("\"", "\\\"");
		user.setNickname(nameEnterprise);
		user.setRegistrationDate(new Date());

		String md5Password = DigestUtils.md5Hex(signupUserLegalForm.getPassword());
		user.setPassword(md5Password);
		legal.setAddress(signupUserLegalForm.getAddress());
		legal.setNameEnterprise(nameEnterprise);
		legal.setUnp(signupUserLegalForm.getUnp());
		legal.setZipCode(Integer.valueOf(signupUserLegalForm.getZipCode()));
		legal.setUser(user);
		user.setLegal(legal);
		
		avatar.setPath(String.valueOf((new Random().nextInt(Integer.parseInt(propertyManager.getValue(PropertyName.AVATAR_INDEX_SIZE))+1))));
		avatar.setUser(user);
		user.setAvatar(avatar);

		String[] phoneMass = signupUserLegalForm.getPhones();
		for (int i = 0; i < phoneMass.length; i++) {
			Phone phone = new Phone();
			phone.setTitle(phoneMass[i]);
			phone.setUser(user);
			phone.setIdOperator(1);
			phones.add(phone);
		}
		user.setPhones(phones);
		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Lot> getAllLots(Date endDate) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectAllLots(endDate);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Deprecated
	@Override
	public List<Lot> getAllLotsByCategory(int idCategory, Date endDate) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectLotByCategory(idCategory, endDate);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public List<Lot> getAllLotsByCategoryAndSubcategory(int idCategory, int idSubcategory, Date endDate)
			throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectLotByCategoryAndSubcategory(idCategory, idSubcategory, endDate);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public User getUser(String login) throws ServiceException {
		User user;
		try {
			user = userDAO.selectUser(login);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public void deletePasswordResetTokenForUser(User user) throws ServiceException {
		try {
			PasswordResetToken passwordResetTokenOld = resetTokenDAO.selectTokenByUser(user.getIdUser());
			resetTokenDAO.deletePasswordResetToken(passwordResetTokenOld.getIdToken());
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}
	
	@Override
	public String createPasswordResetTokenForUser(User user) throws ServiceException {
		Date date = new Date();
		String token = null;
		try {
			PasswordResetToken passwordResetTokenOld = resetTokenDAO.selectTokenByUser(user.getIdUser());
			if (passwordResetTokenOld == null) {
				token = UUID.randomUUID().toString();
				PasswordResetToken passwordResetTokenNew = new PasswordResetToken();
				passwordResetTokenNew.setExpiryDate(new Date(date.getTime() + 86400000l));
				passwordResetTokenNew.setIdUser(user.getIdUser());
				passwordResetTokenNew.setToken(token);
				resetTokenDAO.insertPasswordResetToken(passwordResetTokenNew);
			} else {
				Calendar calendar = Calendar.getInstance();
				if (passwordResetTokenOld.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0) {
					passwordResetTokenOld.setExpiryDate(new Date(date.getTime() + 86400000l));
					token = UUID.randomUUID().toString();
					passwordResetTokenOld.setToken(token);
					resetTokenDAO.updatePasswordResetToken(passwordResetTokenOld);
				}
			}
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return token;
	}

	@Override
	public PasswordResetToken getPasswordResetToken(String token) throws ServiceException {
		PasswordResetToken passwordResetToken = null;
		try {
			passwordResetToken = resetTokenDAO.selectTokenByToken(token);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}

		return passwordResetToken;
	}

	@Override
	public void updateForgotPassword(User user, String password) throws ServiceException {
		String md5Password = DigestUtils.md5Hex(password);
		user.setPassword(md5Password);
		try {
			PasswordResetToken passwordResetToken = resetTokenDAO.selectTokenByUser(user.getIdUser());
			userDAO.updateUser(user);
			resetTokenDAO.deletePasswordResetToken(passwordResetToken.getIdToken());
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}

	}

	@Override
	public User getUser(int idUser) throws ServiceException {
		User user = new User();
		try {
			user = userDAO.selectUser(idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	@Transactional
	public void updatePassword(UpdateUserPasswordForm userUpdatePasswordForm) throws ServiceException {
		try {
			User user = userDAO.selectStaffUser(userUpdatePasswordForm.getIdUser());
			String password = userUpdatePasswordForm.getPassword();
			if (password != null) {
				String md5Password = DigestUtils.md5Hex(password);
				user.setPassword(md5Password);
				userDAO.updateUser(user);
			}
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	@Override
	public long getCountBetByLot(Integer idLot) throws ServiceException {
		long count = 0;
		try {
			count = betDAO.selectCountBetByLot(idLot);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return count;
	}
	
	@Override
	public long getCountArchiveBetByLot(Integer idArchiveLot) throws ServiceException {
		long count = 0;
		try {
			count = archiveBetDAO.selectCountArchiveBetByLot(idArchiveLot);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return count;
	}

	@Override
	public long getCountBetByLotByUser(Integer idLot, Integer idUser) throws ServiceException {
		long count = 0;
		try {
			count = betDAO.selectCountBetByLotByUser(idLot, idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return count;
	} 
	
	@Override
	public long getCountArchiveBetByLotByUser(Integer idArchiveLot, Integer idUser) throws ServiceException {
		long count = 0;
		try {
			count = archiveBetDAO.selectCountArchiveBetByLotByUser(idArchiveLot, idUser);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return count;
	}

	@Override
	public int getIdOwnerLot(Integer idLot) throws ServiceException {
		int idUser = 0;
		try {
			idUser = lotDAO.selectIdOwnerLot(idLot);
		} catch (DaoException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return idUser;
	}
}
