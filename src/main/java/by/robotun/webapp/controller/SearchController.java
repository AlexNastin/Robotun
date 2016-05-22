package by.robotun.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
//		List<LotSolr> lotSolrs =  (List<LotSolr>) lotRepository.findAll();
//		for (LotSolr lotSolr : lotSolrs) {
//			System.out.println();
//		}
		return null;
	}

}
