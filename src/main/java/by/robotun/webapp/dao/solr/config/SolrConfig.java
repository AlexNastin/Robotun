package by.robotun.webapp.dao.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;
//
//@Configuration
//@EnableSolrRepositories(basePackages = "by.robotun.webapp.dao.solr")
//public class SolrConfig {
//
//	@Autowired
//	private PropertyManager propertyManager;
//
//	@Bean
//	public SolrClient getSolrClient() {
//		return new HttpSolrClient(propertyManager.getValue(PropertyName.SOLR_HTTP_URL));
//	}
//	
//	@Bean
//	public SolrTemplate solrTemplate(SolrClient server) {
//		return new SolrTemplate(server);
//	}
//}
