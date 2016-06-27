package by.robotun.webapp.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.dao.IArchiveLotDAO;
import by.robotun.webapp.dao.IBetDAO;
import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.dao.IPhoneDAO;
import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Bet;
import by.robotun.webapp.domain.Legal;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.Phone;
import by.robotun.webapp.domain.Physical;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddLotForm;
import by.robotun.webapp.form.UpdateLotForm;
import by.robotun.webapp.form.UpdatePersonalUserLegalForm;
import by.robotun.webapp.form.UpdatePersonalUserPhysicalForm;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.ServiceParamConstant;

@Service
public class UserService implements IUserService {

	@Autowired
	private ILotDAO lotDAO;
	
	@Autowired
	private IArchiveLotDAO archiveLotDAO;

	@Autowired
	private IBetDAO betDAO;
	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IPhoneDAO phoneDAO;

	@Override
	public void addLot(AddLotForm addLotForm, int idUser) throws ServiceException {
		try {
			DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE_WITH_TIME);
			Date startDate = new Date();
			Date endDate = dateFormat.parse(addLotForm.getEndDate());
			Lot lot = new Lot();
			lot.setName(addLotForm.getName());
			lot.setIdCity(addLotForm.getIdCity());
			lot.setStartDate(startDate);
			lot.setEndDate(endDate);
			lot.setIdCategory(addLotForm.getIdCategory());
			lot.setIdSubcategory(addLotForm.getIdSubcategory());
			lot.setBudget(Integer.parseInt(addLotForm.getBudget()));
			lot.setDescription(addLotForm.getDescription());
			lot.setIsVisible(ServiceParamConstant.ON_MODERATION_NUMBER);
			lot.setIsCall(addLotForm.getIsCall());
			lot.setIdCity(addLotForm.getIdCity());
			lot.setIdUser(idUser);
			lot.setLatitude(addLotForm.getLatitude());
			lot.setLongitude(addLotForm.getLongitude());
			lotDAO.insertLot(lot);
		} catch (ParseException | DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Lot getLotById(Integer idLot) throws ServiceException {
		Lot lot = null;
		if(idLot != null) {
			try {
				lot = lotDAO.selectLotById(idLot);
			} catch (DaoException e) {
				throw new ServiceException(e);
			}
		}
		return lot;
	}
	
	@Override
	public ArchiveLot getArchiveLotById(Integer idArchiveLot) throws ServiceException {
		ArchiveLot archiveLot;
		try {
			archiveLot = archiveLotDAO.selectArchiveLotById(idArchiveLot);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return archiveLot;
	}

	@Override
	public void addBet(String cost, int idUser, int idLot) throws ServiceException {
		Date date = new Date();
		Bet bet = new Bet();
		bet.setCost(Double.parseDouble(cost));
		bet.setDate(date);
		bet.setIdUser(idUser);
		bet.setIdLot(idLot);
		try {
			betDAO.insertBet(bet);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Date getDateLotById(Integer idLot) throws ServiceException {
		Date endDate;
		try {
			endDate = lotDAO.selectDateLotById(idLot);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return endDate;
	}

	@Override
	public void updatePersonalUserPhysical(UpdatePersonalUserPhysicalForm updatePersonalUserPhysicalForm, Integer idUser, HttpSession httpSession)
			throws ServiceException {
		try {
			User user = userDAO.selectUser(idUser);
			user.setIdCity(updatePersonalUserPhysicalForm.getIdCity());
			StringBuilder nicknameBuilder = new StringBuilder(updatePersonalUserPhysicalForm.getSurname());
			nicknameBuilder.append(" ");
			nicknameBuilder.append(updatePersonalUserPhysicalForm.getName());
			user.setNickname(nicknameBuilder.toString());
			List<Phone> phones = user.getPhones();
			String[] phoneMass = updatePersonalUserPhysicalForm.getPhones();
			for (int i = 0; i < phoneMass.length; i++) {
				Phone phone = phones.get(i);
				phone.setTitle(phoneMass[i]);
				phone.setUser(user);
				phone.setIdOperator(1);
			}
			user.setPhones(phones);
			Physical physical = user.getPhysical();
			physical.setName(updatePersonalUserPhysicalForm.getName());
			physical.setSurname(updatePersonalUserPhysicalForm.getSurname());
			physical.setUser(user);
			user.setPhysical(physical);
			userDAO.updateUser(user);
			Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
			person.setIdCity(user.getIdCity());
			person.setLogin(user.getLogin());
			person.setNickname(user.getNickname());
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
		
	}

	@Override
	public User getUserById(Integer idUser) throws ServiceException {
		User user = new User();
		try {
			user = userDAO.selectUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public void updatePersonalUserLegal(UpdatePersonalUserLegalForm updatePersonalUserLegalForm, Integer idUser, HttpSession httpSession) throws ServiceException {
		try {
			User user = userDAO.selectUser(idUser);
			user.setIdCity(updatePersonalUserLegalForm.getIdCity());
			user.setNickname(updatePersonalUserLegalForm.getNameEnterprise());
			List<Phone> phones = user.getPhones();
			String[] phoneMass = updatePersonalUserLegalForm.getPhones();
			for (int i = 0; i < phoneMass.length; i++) {
				Phone phone = phones.get(i);
				phone.setTitle(phoneMass[i]);
				phone.setUser(user);
				phone.setIdOperator(1);
			}
			user.setPhones(phones);
			Legal legal = user.getLegal();
			String nameEnterprise = updatePersonalUserLegalForm.getNameEnterprise().replace("\"", "\\\"");
			user.setNickname(nameEnterprise);
			legal.setUnp(updatePersonalUserLegalForm.getUnp());
			legal.setAddress(updatePersonalUserLegalForm.getAddress());
			legal.setZipCode(Integer.valueOf(updatePersonalUserLegalForm.getZipCode()));
			legal.setUser(user);
			user.setLegal(legal);
			userDAO.updateUser(user);
			Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
			person.setIdCity(user.getIdCity());
			person.setLogin(user.getLogin());
			person.setNickname(user.getNickname());
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public List<String> getPhonesStringByIdUser(Integer idUser) throws ServiceException {
		List<String> phones = new ArrayList<String>();
		try {
			phones = phoneDAO.selectPhonesStringByIdUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return phones;
	}

	@Override
	public List<Lot> getLotsCreatedUser(int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsCreatedUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return lots;	
	}
	
	@Override
	public List<ArchiveLot> getArchiveLotsCreatedUser(int idUser) throws ServiceException {
		List<ArchiveLot> archiveLots = new ArrayList<ArchiveLot>();
		try {
			archiveLots = archiveLotDAO.selectArchiveLotsCreatedUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return archiveLots;	
	}

	@Override
	public List<Lot> getLotsRespondedUser(int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		try {
			lots = lotDAO.selectLotsRespondedUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return lots;		
	}

	@Override
	public Lot getLotByIdForModeration(Integer idLot) throws ServiceException {
		Lot lot;
		try {
			lot = lotDAO.selectLotByIdForModeration(idLot);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return lot;
	}

	@Override
	public void updateLot(UpdateLotForm updateLotForm) throws ServiceException {
		Lot lot;
		try {
			lot = lotDAO.selectLotById(updateLotForm.getIdLot());
			DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE_WITH_TIME);
			Date endDate = dateFormat.parse(updateLotForm.getEndDate());
			lot.setName(updateLotForm.getName());
			lot.setIdCity(updateLotForm.getIdCity());
			lot.setEndDate(endDate);
			lot.setIdCategory(updateLotForm.getIdCategory());
			lot.setIdSubcategory(updateLotForm.getIdSubcategory());
			lot.setBudget(Integer.parseInt(updateLotForm.getBudget()));
			lot.setDescription(updateLotForm.getDescription());
			lot.setIsVisible(ServiceParamConstant.ON_MODERATION_NUMBER);
			lot.setIdCity(updateLotForm.getIdCity());
			lot.setIsCall(updateLotForm.getIsCall());
			lot.setLatitude(updateLotForm.getLatitude());
			lot.setLongitude(updateLotForm.getLongitude());
			lotDAO.updateLot(lot);
		} catch (DaoException | ParseException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int deleteLot(Integer idLot) throws ServiceException {
		int confirm = 0;
		try {
			lotDAO.deleteLot(idLot);
		} catch (DaoException e) {
			confirm = 1;
			throw new ServiceException(e);
		}
		return confirm;
	}

	@Override
	public List<Lot> getLotsOnUpdateByUser(int idUser) throws ServiceException {
		List<Lot> lots = new ArrayList<>();
		try {
			lots = lotDAO.selectLotsOnUpdateByUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return lots;
	}

	@Override
	public User getUserByIdWithCity(int idUser) throws ServiceException {
		User user = new User();
		try {
			user = userDAO.selectUserByIdWithCity(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return user;
	}

}
