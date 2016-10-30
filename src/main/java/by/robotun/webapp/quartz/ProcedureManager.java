package by.robotun.webapp.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.exception.DaoException;

@Component("procedureManager")
public class ProcedureManager {

	@Autowired
	private ILotDAO lotDAO;

	public void deleteLotForTime() throws DaoException {
		lotDAO.callFunctionDeleteLotForTime();
	}

}
