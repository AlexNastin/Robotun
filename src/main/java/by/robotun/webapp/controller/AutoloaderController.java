package by.robotun.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.service.IAutoloaderService;
import by.robotun.webapp.service.converter.SerializationJSON;

@RestController
public class AutoloaderController {

	@Autowired
	private SerializationJSON serializationJSON;

	@Autowired
	private IAutoloaderService autocompleteService;

	@RequestMapping(value = "/autoloader/filterResults", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String filterResult(@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "idCity", required = false) Integer idCity,
			@RequestParam(value = "budgetFrom", required = false) Integer budgetFrom,
			@RequestParam(value = "budgetTo", required = false) Integer budgetTo,
			@RequestParam(value = "desc", required = false) String desc) throws ServiceException {
		List<Lot> lots = autocompleteService.getLotsFiltering(endDate, budgetFrom, budgetTo, desc, idCity);
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/physical/myLots", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getPhysicalMyLots(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyLots(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(lots);
	}
	
	@RequestMapping(value = "/autoloader/physical/archiveLots", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getPhysicalArchiveLots(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<ArchiveLot> archiveLots = autocompleteService.getArchiveLots(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(archiveLots);
	}

	@RequestMapping(value = "/autoloader/physical/myResponses", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getPhysicalMyResponses(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyResponses(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/legal/myLots", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getLegalMyLots(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyLots(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(lots);
	}
	
	@RequestMapping(value = "/autoloader/legal/archiveLots", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getLegalArchiveLots(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<ArchiveLot> archiveLots = autocompleteService.getArchiveLots(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(archiveLots);
	}

	@RequestMapping(value = "/autoloader/legal/myResponses", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getLegalMyResponses(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getMyResponses(offset, person.getId());
		return serializationJSON.toJsonViewsPublic(lots);
	}

	@RequestMapping(value = "/autoloader/moderator/onModeration", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getOnModeration(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		List<Lot> lots = autocompleteService.getOnModeration(offset);
		return serializationJSON.toJsonViewsInternalRejectMessages(lots);
	}

	@RequestMapping(value = "/autoloader/physical/lotsOnUpdate", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getPhysicalLotsOnUpdate(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getLotsOnUpdate(offset, person.getId());
		return serializationJSON.toJsonViewsInternalRejectMessages(lots);
	}

	@RequestMapping(value = "/autoloader/legal/lotsOnUpdate", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getLegalLotsOnUpdate(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = autocompleteService.getLotsOnUpdate(offset, person.getId());
		return serializationJSON.toJsonViewsInternalRejectMessages(lots);
	}

	@RequestMapping(value = "/autoloader/admin/moderators", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getModerators(@RequestParam(value = "offset", required = false) Integer offset,
			HttpSession httpSession) throws ServiceException {
		List<User> users = autocompleteService.getModerators(offset);
		return serializationJSON.toJsonViewsInternalForListModerators(users);
	}
}