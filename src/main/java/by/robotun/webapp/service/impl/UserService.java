package by.robotun.webapp.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddLotForm;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.ServiceParamConstant;

@Service
public class UserService implements IUserService {
	
	@Autowired
	ILotDAO lotDAO;

	@Override
	public void addLot(AddLotForm addLotForm) throws ServiceException {
		try {
			DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE);
			Date startDate = new Date();
			Date endDate = dateFormat.parse(addLotForm.getEndDate());
			Lot lot = new Lot();
			lot.setName(addLotForm.getName());
			// ����� ������������� ����� ����� ����� ������� ���������
			lot.setStartDate(startDate);
			lot.setEndDate(endDate);
			lot.setIdCategory(addLotForm.getIdCategory());
			lot.setIdSubcategory(addLotForm.getIdSubcategory());
			lot.setBudget(addLotForm.getBudget());
			lot.setDescription(addLotForm.getDescription());
			// �������� �� false ����� ����� ��������� ������� ���������
			lot.setVisible(true);
			lot.setIdUser(11);
			lotDAO.insertLot(lot);
		} catch (ParseException | DaoException e) {
			throw new ServiceException(e);
		}
		
		
	}

	@Override
	public Lot getLotById(Integer idLot) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
