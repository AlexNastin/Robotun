package by.robotun.webapp.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.robotun.webapp.dao.IBetDAO;
import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.domain.Bet;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.LotFormAdd;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.ServiceParamConstant;

@Service
public class UserService implements IUserService {

	@Autowired
	private ILotDAO lotDAO;

	@Autowired
	private IBetDAO betDAO;

	@Override
	public void addLot(LotFormAdd addLotForm, int idUser) throws ServiceException {
		try {
			DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE);
			Date startDate = new Date();
			Date endDate = dateFormat.parse(addLotForm.getEndDate());
			Lot lot = new Lot();
			lot.setName(addLotForm.getName());
			// будет формироваться иначе когда будет система модерации
			lot.setStartDate(startDate);
			lot.setEndDate(endDate);
			lot.setIdCategory(addLotForm.getIdCategory());
			lot.setIdSubcategory(addLotForm.getIdSubcategory());
			lot.setBudget(addLotForm.getBudget());
			lot.setDescription(addLotForm.getDescription());
			// изменить на false когда будет добавлена система модерации
			lot.setVisible(true);
			lot.setIdUser(idUser);
			lotDAO.insertLot(lot);
		} catch (ParseException | DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Lot getLotById(Integer idLot) throws ServiceException {
		Lot lot;
		try {
			lot = lotDAO.selectLotById(idLot);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return lot;
	}

	@Override
	public void addBet(String cost, int idUser, int idLot) throws ServiceException {
		Date date = new Date();
		Bet bet = new Bet();
		bet.setCost(Double.parseDouble(cost));
		bet.setDate(date);
		bet.setIdUser(idUser);
		bet.setIdLot(idLot);
		System.out.println(bet);
		try {
			betDAO.insertBet(bet);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
