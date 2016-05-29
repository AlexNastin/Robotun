package by.robotun.webapp.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.converter.SerializationJSON;

public class ScheduleDeltaIndexSolrJob extends QuartzJobBean{

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

    }
}