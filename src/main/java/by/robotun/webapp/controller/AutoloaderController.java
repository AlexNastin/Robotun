package by.robotun.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.dao.DaoParamConstant;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
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
	public String getAllLots(@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "idCity", required = false) Integer idCity,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "budgetFrom", required = false) Integer budgetFrom,
			@RequestParam(value = "budgetTo", required = false) Integer budgetTo,
			@RequestParam(value = "desc", required = false) String desc,
			@RequestParam(value = "idCategory", required = false) Integer idCategory,
			@RequestParam(value = "idSubcategory", required = false) Integer idSubcategory) throws ServiceException {
		List<Lot> lots = new ArrayList<Lot>();
		Date date = new Date();
		if ("".equals(endDate) && idCity == 0 && budgetFrom == null && budgetTo == null && DaoParamConstant.SORT_TYPE_NEW.equals(desc) && (idCategory == 0 || idSubcategory == 0)) {
			lots = autocompleteService.getLots(offset, date);
		} else if("".equals(endDate) && idCity == 0 && budgetFrom == null && budgetTo == null && DaoParamConstant.SORT_TYPE_NEW.equals(desc)) {
			lots = autocompleteService.getLotsByCategoryAndSubcategory(offset, date, idCategory, idSubcategory);
		} else {
			lots = autocompleteService.getLotsFilteringOffset(endDate, budgetFrom, budgetTo, desc, idCity, offset, date);
		}
		System.err.println(lots);
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/filterResults", method = RequestMethod.GET)
	public String filterResult(@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "idCity", required = false) Integer idCity,
			@RequestParam(value = "budgetFrom", required = false) Integer budgetFrom,
			@RequestParam(value = "budgetTo", required = false) Integer budgetTo,
			@RequestParam(value = "desc", required = false) String desc) throws ServiceException {
		List<Lot> lots = autocompleteService.getLotsFiltering(endDate, budgetFrom, budgetTo, desc, idCity);
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/physical/myLots", method = RequestMethod.GET)
	public String getPhysicalMyLots(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyLots(offset, person.getId());
		System.err.println(lots);
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/physical/myResponses", method = RequestMethod.GET)
	public String getPhysicalMyResponses(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyResponses(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/legal/myLots", method = RequestMethod.GET)
	public String getLegalMyLots(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyLots(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/legal/myResponses", method = RequestMethod.GET)
	public String getLegalMyResponses(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyResponses(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/moderator/onModeration", method = RequestMethod.GET)
	public String getOnModeration(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		List<Lot> lots = autocompleteService.getOnModeration(offset);
		return serializationJSON.toJsonViewsInternalRejectMessages(lots);
	}

	@RequestMapping(value = "/autoloader/physical/lotsOnUpdate", method = RequestMethod.GET)
	public String getPhysicalLotsOnUpdate(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getLotsOnUpdate(offset, person.getId());
		return serializationJSON.toJsonViewsInternalRejectMessages(lots);
	}

	@RequestMapping(value = "/autoloader/legal/lotsOnUpdate", method = RequestMethod.GET)
	public String getLegalLotsOnUpdate(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getLotsOnUpdate(offset, person.getId());
		return serializationJSON.toJsonViewsInternalRejectMessages(lots);
	}

	@RequestMapping(value = "/autoloader/admin/moderators", method = RequestMethod.GET)
	public String getModerators(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		List<User> users = autocompleteService.getModerators(offset);
		return serializationJSON.toJsonViewsInternalForListModerators(users);
	}
}