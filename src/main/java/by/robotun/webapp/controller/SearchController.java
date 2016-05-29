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
import by.robotun.webapp.service.converter.SerializationJSON;

@RestController
public class SearchController {

	@Autowired
	private SerializationJSON serializationJSON;

//	@Autowired
//	private ILotRepository lotRepository;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "text") String text) throws ServiceException {
//	
//		System.out.println(	lotRepository.getClass());
//		String result = "df";
//		List<LotSolr> lotSolrs = lotRepository.findByKey(result);
//		for (Object object : lotSolrs) {
//			System.out.println(object);
//		}
		return null;
	}

//	@RequestMapping(value = "/search", method = RequestMethod.GET)
//	public String searchLotsForCategory(@RequestParam(value = "category") String category,
//			@RequestParam(value = "subcategory") String subcategory) throws ServiceException {
//		String result = "";
//
//		return result;
//	}

}
