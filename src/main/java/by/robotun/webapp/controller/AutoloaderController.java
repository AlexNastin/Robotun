package by.robotun.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IAutoloaderService;

@RestController
public class AutoloaderController {

	@Autowired
	private IAutoloaderService autocompleteService;

	@RequestMapping(value = "/autoloader/allResults", method = RequestMethod.GET)
	public List<Lot> getAllLots(@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "offset", required = false) Integer offset) throws ServiceException {
		Date date = new Date();
		System.err.println(limit + "      " + offset);
		List<Lot> lots = autocompleteService.getLots(limit, offset, date);
		return lots;
	}
}