package by.robotun.webapp.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.ServiceParamConstant;
import by.robotun.webapp.service.converter.SerializationJSON;

@Controller
public class GuestController {

	@Autowired
	private SerializationJSON serializationJSON;

	@Autowired
	private IGuestService guestService;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam(value = "q", required = false) String query, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		int idCity = 0;
		if (person != null) {
			idCity = person.getIdCity();
		}
		String querySolr = query;
		if (querySolr == null) {
			querySolr = "*:*";
			query = "";
		} else {
			querySolr.replace(" ", "* or *");
			querySolr = "description:(*" + querySolr + "*) OR name:(*" + querySolr + "*)";
		}
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_RESULT);
		List<Category> categories = guestService.getAllCategories();
		modelAndView.addObject(ControllerParamConstant.QUERY_SOLR, querySolr);
		modelAndView.addObject(ControllerParamConstant.QUERY, query);
		modelAndView.addObject(ControllerParamConstant.ID_CITY, idCity);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.LIST_CATEGORIES_JSON,
				serializationJSON.toJsonViewsPublicCategories(categories));
		return modelAndView;
	}

	@RequestMapping(value = "/lot", method = RequestMethod.GET)
	public ModelAndView lot(@RequestParam(value = "id", required = true) Integer idLot,
			@RequestParam(value = "idPic", required = false) Integer idPicture, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		Lot lot = userService.getLotById(idLot);
		ModelAndView modelAndView = new ModelAndView();
		if (lot == null) {
			modelAndView = new ModelAndView(URLMapping.JSP_ERROR_404);
		} else {
			if (lot.getIsVisible() == ServiceParamConstant.ON_MODERATION_NUMBER
					|| lot.getIsVisible() == ServiceParamConstant.ON_UPDATE_NUMBER) {
				modelAndView = new ModelAndView(URLMapping.JSP_ERROR_ON_MODERATION);
			} else {
				if (idPicture == null) {
					idPicture = 1;
				}
				modelAndView = new ModelAndView(URLMapping.JSP_LOT);
				String path = "null";
				modelAndView.addObject(ControllerParamConstant.DATE_END_LOT, lot.getEndDate().getTime());
				modelAndView.addObject(ControllerParamConstant.LOT_JSON, serializationJSON.toJsonViewsInternalLot(lot));
				modelAndView.addObject(ControllerParamConstant.COUNT_BET, guestService.getCountBetByLot(idLot));
				modelAndView.addObject(ControllerParamConstant.IS_ME_CALL, false);
				modelAndView.addObject(ControllerParamConstant.IS_I_CALL, false);
				modelAndView.addObject(ControllerParamConstant.IS_ELSE, false);
				modelAndView.addObject(ControllerParamConstant.CURRENT_DATE, new Date().getTime());
				modelAndView.addObject(ControllerParamConstant.ID_PICTURE, idPicture);
				if (person != null) {
					path = person.getPath();
					if (lot.getIsCall() && lot.getIdUser() == person.getId()) {
						modelAndView.addObject(ControllerParamConstant.IS_I_CALL, true);
					} else if (!lot.getIsCall()) {
						if (guestService.getCountBetByLotByUser(lot.getIdLot(), person.getId()) > 0) {
							modelAndView.addObject(ControllerParamConstant.IS_ME_CALL, true);
							modelAndView.addObject(ControllerParamConstant.LIST_NUMBERS,
									userService.getPhonesStringByIdUser(person.getId()));
						}
					} else {
						modelAndView.addObject(ControllerParamConstant.IS_ELSE, true);
					}
					modelAndView.addObject(ControllerParamConstant.ID_USER, person.getId());
					modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
				} else {
					modelAndView.addObject(ControllerParamConstant.ID_USER, 0);
				}
				modelAndView.addObject(ControllerParamConstant.AVATAR_PATH, path);
			}
		}

		return modelAndView;
	}

	@RequestMapping(value = "/archiveLot", method = RequestMethod.GET)
	public ModelAndView archiveLot(@RequestParam(value = "id", required = true) Integer idArchiveLot,
			@RequestParam(value = "idPic", required = false) Integer idPicture, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView();
		if (person != null) {
			ArchiveLot archiveLot = userService.getArchiveLotById(idArchiveLot);
			if (archiveLot != null && person.getId() == archiveLot.getIdUser()) {
				String path = person.getPath();
				if (idPicture == null) {
					idPicture = 1;
				}
				modelAndView = new ModelAndView(URLMapping.JSP_ARCHIVE_LOT);
				modelAndView.addObject(ControllerParamConstant.DATE_END_LOT, archiveLot.getEndDate().getTime());
				modelAndView.addObject(ControllerParamConstant.LOT_JSON,
						serializationJSON.toJsonViewsInternalLot(archiveLot));
				modelAndView.addObject(ControllerParamConstant.COUNT_BET,
						guestService.getCountArchiveBetByLot(idArchiveLot));
				modelAndView.addObject(ControllerParamConstant.IS_ME_CALL, false);
				modelAndView.addObject(ControllerParamConstant.IS_I_CALL, false);
				modelAndView.addObject(ControllerParamConstant.IS_ELSE, false);
				modelAndView.addObject(ControllerParamConstant.CURRENT_DATE, new Date().getTime());
				modelAndView.addObject(ControllerParamConstant.ID_PICTURE, idPicture);
				if (archiveLot.getIsCall() && archiveLot.getIdUser() == person.getId()) {
					modelAndView.addObject(ControllerParamConstant.IS_I_CALL, true);
				} else if (!archiveLot.getIsCall()) {
					if (guestService.getCountArchiveBetByLotByUser(archiveLot.getIdArchiveLot(), person.getId()) > 0) {
						modelAndView.addObject(ControllerParamConstant.IS_ME_CALL, true);
						modelAndView.addObject(ControllerParamConstant.LIST_NUMBERS,
								userService.getPhonesStringByIdUser(person.getId()));
					}
				} else {
					modelAndView.addObject(ControllerParamConstant.IS_ELSE, true);
				}
				modelAndView.addObject(ControllerParamConstant.ID_USER, person.getId());
				modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
				modelAndView.addObject(ControllerParamConstant.AVATAR_PATH, path);
			}
		} else {
			modelAndView = new ModelAndView(URLMapping.JSP_ERROR_404);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/viewUserProfile", method = RequestMethod.GET)
	public ModelAndView profileUserView(@RequestParam(value = "id", required = true) Integer idUser, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		User user = userService.getUserByIdWithCity(idUser);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_VIEW);
		if(person != null) {
			modelAndView.addObject(ControllerParamConstant.ID_VISITED_USER, person.getId());
		} else {
			modelAndView.addObject(ControllerParamConstant.ID_VISITED_USER, 0);
		}
		modelAndView.addObject(ControllerParamConstant.USER_JSON, serializationJSON.toJsonViewsInternalUserSubclass(user));
		modelAndView.addObject(ControllerParamConstant.ID_USER, idUser);
		return modelAndView;
	}
}
