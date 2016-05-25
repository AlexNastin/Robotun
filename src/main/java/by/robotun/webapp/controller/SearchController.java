package by.robotun.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.dao.solr.ILotRepository;
import by.robotun.webapp.domain.solr.LotSolr;
import by.robotun.webapp.exeption.ServiceException;

@RestController
public class SearchController {

//	@Autowired
//	private ILotRepository lotRepository;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getLegalMyLots(@RequestParam(value = "text") String text) throws ServiceException {
//		org.springframework.data.solr.core.query.result.SolrResultPage  lotSolrs =   (SolrResultPage) lotRepository.findAll();
//	for (Object object : lotSolrs) {
//		System.out.println(object);
//	}
		return null;
	}

}
