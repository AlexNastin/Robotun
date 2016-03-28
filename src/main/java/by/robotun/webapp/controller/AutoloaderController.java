package by.robotun.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IAutoloaderService;

@RestController
public class AutoloaderController {

	@Autowired
	private IAutoloaderService autocompleteService;

	@RequestMapping(value = "/autoloader/allResults", method = RequestMethod.GET)
	public List<Lot> getAllLots(@RequestParam(value = "offset", required = false) Integer offset) throws ServiceException {
		Date date = new Date();
		List<Lot> lots = autocompleteService.getLots(offset, date);
		return lots;
	}
	
	@RequestMapping(value = "/autoloader/physical/myLots", method = RequestMethod.GET)
	public List<Lot> getPhysicalMyLots(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyLots(offset, person.getId());
		return lots;
	}
	
	@RequestMapping(value = "/autoloader/physical/myResponses", method = RequestMethod.GET)
	public List<Lot> getPhysicalMyResponses(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyResponses(offset, person.getId());
		return lots;
	}
	
	@RequestMapping(value = "/autoloader/legal/myLots", method = RequestMethod.GET)
	public List<Lot> getLegalMyLots(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyLots(offset, person.getId());
		return lots;
	}
	
	@RequestMapping(value = "/autoloader/legal/myResponses", method = RequestMethod.GET)
	public List<Lot> getLegalMyResponses(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyResponses(offset, person.getId());
		return lots;
	}
}