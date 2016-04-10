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
import by.robotun.webapp.service.converter.SerializationJSON;

@RestController
public class AutoloaderController {
	
	@Autowired
	private SerializationJSON serializationJSON;

	@Autowired
	private IAutoloaderService autocompleteService;

	@RequestMapping(value = "/autoloader/allResults", method = RequestMethod.GET)
	public String getAllLots(@RequestParam(value = "offset", required = false) Integer offset) throws ServiceException {
		Date date = new Date();
		List<Lot> lots = autocompleteService.getLots(offset, date);
		return serializationJSON.toJsonViewsPublic(lots);
	}
	
	@RequestMapping(value = "/autoloader/physical/myLots", method = RequestMethod.GET)
	public String getPhysicalMyLots(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyLots(offset, person.getId());
		System.err.println(lots);
		return serializationJSON.toJsonViewsPublic(lots);
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
	
	@RequestMapping(value = "/autoloader/moderator/onModeration", method = RequestMethod.GET)
	public List<Lot> getOnModeration(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		List<Lot> lots = autocompleteService.getOnModeration(offset);
		return lots;
	}
	
	@RequestMapping(value = "/autoloader/physical/lotsOnUpdate", method = RequestMethod.GET)
	public List<Lot> getPhysicalLotsOnUpdate(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getLotsOnUpdate(offset, person.getId());
		return lots;
	}
	
	@RequestMapping(value = "/autoloader/legal/lotsOnUpdate", method = RequestMethod.GET)
	public List<Lot> getLegalLotsOnUpdate(@RequestParam(value = "offset", required = false) Integer offset, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getLotsOnUpdate(offset, person.getId());
		return lots;
	}
}