package by.robotun.webapp.quartz.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;
import by.robotun.webapp.quartz.HttpClientSolrJ;

public class ScheduleFullIndexSolrJob extends QuartzJobBean {
	
	static final Logger LOGGER = Logger.getLogger(ScheduleFullIndexSolrJob.class);

	private HttpClientSolrJ httpClientSolrJ;

	private PropertyManager propertyManager;

	public void setHttpClientSolrJ(HttpClientSolrJ httpClientSolrJ) {
		this.httpClientSolrJ = httpClientSolrJ;
	}

	public void setPropertyManager(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.err.println("ScheduleFullIndexSolrJob");
		String json = httpClientSolrJ.solrImport(propertyManager.getValue(PropertyName.SOLR_URL_FULL_IMPORT));
		System.out.println(json);
		LOGGER.info(json);
	}
}