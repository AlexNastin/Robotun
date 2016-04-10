package by.robotun.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.dao.solr.ISolrDAO;
import by.robotun.webapp.exeption.ServiceException;

@RestController
public class SearchController {

	@Autowired
	private ISolrDAO solr;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getLegalMyLots(@RequestParam(value = "text") String text) throws ServiceException {
		solr.test(text);
		return null;
	}

}
