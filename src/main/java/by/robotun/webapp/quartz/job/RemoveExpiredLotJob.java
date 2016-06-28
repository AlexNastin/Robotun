package by.robotun.webapp.quartz.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.quartz.ProcedureManager;

public class RemoveExpiredLotJob extends QuartzJobBean {

	static final Logger LOGGER = Logger.getLogger(RemoveExpiredLotJob.class);

	private ProcedureManager procedureManager;

	public void setProcedureManager(ProcedureManager procedureManager) {
		this.procedureManager = procedureManager;
	}

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		try {
			procedureManager.deleteLotForTime();
		} catch (DaoException e) {
			LOGGER.error(e);
		}
	}
}
