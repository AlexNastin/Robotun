package by.robotun.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.domain.ArchiveBet;
import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Bet;
import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.converter.SerializationJSON;

@Controller
public class UserController {

	@Autowired
	private SerializationJSON serializationJSON;

	@Autowired
	IUserService userService;

	@Autowired
	IGuestService guestService;

	@RequestMapping(value = "/get/subcategories", method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> getAllSubcategoryWithCategory(
			@RequestParam(value = "idCategory", required = true) Integer idCategory) throws ServiceException {
		List<Subcategory> subcategories = guestService.getAllSubcategoryWithCategory(idCategory);
		return subcategories;
	}

	@RequestMapping(value = "/get/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory() throws ServiceException {
		return guestService.getAllCategories();
	}

	@RequestMapping(value = "/physical/profile/myResponses", method = RequestMethod.GET)
	public ModelAndView myResponsePhysical(Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = userService.getLotsRespondedUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_RESPONSES_PHYSICAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON, serializationJSON.toJsonViewsPublic(lots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
		return modelAndView;
	}

	@RequestMapping(value = "/physical/profile/myLots", method = RequestMethod.GET)
	public ModelAndView myLotsPhysical(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = userService.getLotsCreatedUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_LOTS_PHYSICAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON, serializationJSON.toJsonViewsPublic(lots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
		return modelAndView;
	}
	
	@RequestMapping(value = "/physical/profile/archiveLots", method = RequestMethod.GET)
	public ModelAndView archiveLotsPhysical(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<ArchiveLot> archiveLots = userService.getArchiveLotsCreatedUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_ARCHIVE_LOTS_PHYSICAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON, serializationJSON.toJsonViewsPublic(archiveLots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
		return modelAndView;
	}

	@RequestMapping(value = "/physical/profile/lotsOnUpdate", method = RequestMethod.GET)
	public ModelAndView lotsOnUpdatePhysical(Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = userService.getLotsOnUpdateByUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_LOTS_ON_UPDATE_PHYSICAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON,
				serializationJSON.toJsonViewsInternalRejectMessages(lots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
		return modelAndView;
	}

	@RequestMapping(value = "/legal/profile/myLots", method = RequestMethod.GET)
	public ModelAndView myLotsLegal(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = userService.getLotsCreatedUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_LOTS_LEGAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON, serializationJSON.toJsonViewsPublic(lots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname().replace("\\\"","\""));
		return modelAndView;
	}
	
	@RequestMapping(value = "/legal/profile/archiveLots", method = RequestMethod.GET)
	public ModelAndView archiveLotsLegal(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<ArchiveLot> archiveLots = userService.getArchiveLotsCreatedUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_ARCHIVE_LOTS_LEGAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON, serializationJSON.toJsonViewsPublic(archiveLots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname().replace("\\\"","\""));
		return modelAndView;
	}

	@RequestMapping(value = "/legal/profile/myResponses", method = RequestMethod.GET)
	public ModelAndView myResponsesLegal(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = userService.getLotsRespondedUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_RESPONSES_LEGAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON, serializationJSON.toJsonViewsPublic(lots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname().replace("\\\"","\""));
		return modelAndView;
	}

	@RequestMapping(value = "/legal/profile/lotsOnUpdate", method = RequestMethod.GET)
	public ModelAndView lotsOnUpdateLegal(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<Lot> lots = userService.getLotsOnUpdateByUser(person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_LOTS_ON_UPDATE_LEGAL);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS_JSON,
				serializationJSON.toJsonViewsInternalRejectMessages(lots));
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname().replace("\\\"","\""));
		return modelAndView;
	}

	@RequestMapping(value = "/lot/showNumber/owner", method = RequestMethod.GET)
	public @ResponseBody List<String> getNumbersOwner(@RequestParam(value = "idLot", required = false) Integer idLot, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<String> phones = new ArrayList<String>();
		Lot lot = userService.getLotById(idLot);
		if(!lot.getIsCall()) {
			for (Bet bet : lot.getBets()) {
				if(bet.getIdUser() == person.getId()) {
					phones = userService.getPhonesStringByIdUser(lot.getIdUser());
					break;
				}
			}
		}
		return phones;
	}
	
	@RequestMapping(value = "/lot/showNumber/client", method = RequestMethod.GET)
	public @ResponseBody List<String> getNumbersClient(@RequestParam(value = "idLot", required = false) Integer idLot,
			@RequestParam(value = "id", required = false) Integer idUser, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<String> phones = new ArrayList<String>();
		Lot lot = userService.getLotById(idLot);
		if(lot.getIsCall() && lot.getIdUser() == person.getId()) {
			for (Bet bet : lot.getBets()) {
				if(bet.getIdUser() == idUser) {
					phones = userService.getPhonesStringByIdUser(idUser);
					break;
				}
			}
		}
		return phones;
	}
	
	@RequestMapping(value = "/lot/showNumber/archive/owner", method = RequestMethod.GET)
	public @ResponseBody List<String> getNumbersArchiveOwner(@RequestParam(value = "idLot", required = false) Integer idArchiveLot, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<String> phones = new ArrayList<String>();
		ArchiveLot archiveLot = userService.getArchiveLotById(idArchiveLot);
		if(!archiveLot.getIsCall()) {
			for (ArchiveBet archiveBet : archiveLot.getBets()) {
				if(archiveBet.getIdUser() == person.getId()) {
					phones = userService.getPhonesStringByIdUser(archiveLot.getIdUser());
					break;
				}
			}
		}
		return phones;
	}
	
	@RequestMapping(value = "/lot/showNumber/archive/client", method = RequestMethod.GET)
	public @ResponseBody List<String> getNumbersArchiveClient(@RequestParam(value = "idLot", required = false) Integer idArchiveLot,
			@RequestParam(value = "id", required = false) Integer idUser, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<String> phones = new ArrayList<String>();
		ArchiveLot archiveLot = userService.getArchiveLotById(idArchiveLot);
		if(archiveLot.getIsCall() && archiveLot.getIdUser() == person.getId()) {
			for (ArchiveBet archiveBet : archiveLot.getBets()) {
				if(archiveBet.getIdUser() == idUser) {
					phones = userService.getPhonesStringByIdUser(idUser);
					break;
				}
			}
		}
		return phones;
	}

	@RequestMapping(value = "/user/deleteLot", method = RequestMethod.GET)
	public @ResponseBody Integer deleteLot(@RequestParam(value = "id", required = false) Integer idLot, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		int idUser = guestService.getIdOwnerLot(idLot);
		Integer confirm = 0;
		if (idUser == person.getId()) {
			confirm = userService.deleteLot(idLot);
		}
		return confirm;
	}
}
