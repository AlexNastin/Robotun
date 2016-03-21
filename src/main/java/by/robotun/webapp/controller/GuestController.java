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

import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;


@Controller
public class GuestController {
	
	@Autowired
	private IGuestService guestService;
	
	@Autowired
	private IUserService userService;

	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam(value = "idCategory", required = false) Integer idCategory,
			@RequestParam(value = "idSubcategory", required = false) Integer idSubcategory, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		List<Lot> lots;
		Date endDate = new Date();
		if(idCategory == null && idSubcategory == null) {
			lots = guestService.getAllLots(endDate);
		} else {
			lots = guestService.getAllLotsByCategoryAndSubcategory(idCategory, idSubcategory, endDate);
		}
		List<Category> categories = guestService.getAllCategories();
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_RESULT);
		modelAndView.addObject(ControllerParamConstant.LIST_CATEGORIES, categories);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS, lots);
		return modelAndView;
	}
	
	@RequestMapping(value = "/lot", method = RequestMethod.GET)
	public ModelAndView lot(@RequestParam(value = "id", required = true) Integer idLot, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		Lot lot = userService.getLotById(idLot);
		List<Category> categories = guestService.getAllCategories();
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOT);
		modelAndView.addObject(ControllerParamConstant.DATE_END_LOT, lot.getEndDate().getTime());
		modelAndView.addObject(ControllerParamConstant.LOT, lot);
		if(person != null) {
			modelAndView.addObject(ControllerParamConstant.ID_USER, person.getId());
			modelAndView.addObject(ControllerParamConstant.LOGIN, person.getLogin());
		} else {
			modelAndView.addObject(ControllerParamConstant.ID_USER, 0);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_CATEGORIES, categories);
		return modelAndView;
	}

}
