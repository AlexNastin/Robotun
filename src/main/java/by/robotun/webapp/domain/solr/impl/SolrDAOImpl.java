package by.robotun.webapp.domain.solr.impl;



import javax.inject.Singleton;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.solr.ISolrDAO;

@Repository
public class SolrDAOImpl implements ISolrDAO {

	@Singleton
	private static final HttpSolrClient HTTP_SOLR_CLIENT = new HttpSolrClient("http://localhost:8983/solr/jcg");

	@Autowired
	private SolrTemplate solr;
	
	@Override
	public void test(String text) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("name:*" + text+"*");
		solrQuery.setFields("name");
		solrQuery.setStart(0);
		System.err.println(text);

		try {
			QueryResponse response = HTTP_SOLR_CLIENT.query(solrQuery);
			SolrDocumentList s = response .getResults();
			System.out.println(s.size());
			if (s.size() != 0) {
				System.out.println(s.get(0));
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}

	}

}
