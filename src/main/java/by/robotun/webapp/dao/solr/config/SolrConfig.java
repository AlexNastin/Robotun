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

//@Configuration
//@EnableSolrRepositories(basePackages = "by.robotun.webapp.dao.solr")
//public class SolrConfig {


//	@Bean
//	public SolrClient getSolrClient() {
//		SolrClient solrClient =new HttpSolrClient("http://localhost:8983/solr");
//		return solrClient;
//	}
//	
//	@Bean
//	public SolrTemplate solrTemplate(SolrClient solrClient) {
//		SolrTemplate solrTemplate  = new SolrTemplate(solrClient, "jcg");
//		return solrTemplate;
//	}
//}
