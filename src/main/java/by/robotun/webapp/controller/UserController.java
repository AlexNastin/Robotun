package by.robotun.webapp.controller;

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

import by.robotun.webapp.domain.Category;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.ServiceParamConstant;


@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IGuestService guestService;
	
	@RequestMapping(value = "/get/subcategories", method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> getAllSubcategoryWithCategory(
			@RequestParam(value = "idCategory", required = true) Integer idCategory)
			throws ServiceException {
		List<Subcategory> subcategories = guestService
				.getAllSubcategoryWithCategory(idCategory);
		return subcategories;
	}
	
	@RequestMapping(value = "/get/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory()
			throws ServiceException {
		return guestService.getAllCategories();
	}
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView profileUser(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);

		ModelAndView modelAndView = new ModelAndView();
		if (person.getIdRole()==ServiceParamConstant.ID_ROLE_USER_LEGAL) {
			modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_LEGAL);
			modelAndView.addObject(ControllerParamConstant.LIST_LOTS, userService.getLotsRespondedUser(person.getId()));
		} else if (person.getIdRole()==ServiceParamConstant.ID_ROLE_USER_PHYSICAL) {
			modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_PHYSICAL);
			modelAndView.addObject(ControllerParamConstant.LIST_LOTS, userService.getLotsCreatedUser(person.getId()));
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/myResponse", method = RequestMethod.GET)
	public ModelAndView myResponse(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView();
		if (person.getIdRole()==ServiceParamConstant.ID_ROLE_USER_LEGAL) {
			modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_RESPONSE_LEGAL);
			modelAndView.addObject(ControllerParamConstant.LIST_LOTS, userService.getLotsCreatedUser(person.getId()));
		} else if (person.getIdRole()==ServiceParamConstant.ID_ROLE_USER_PHYSICAL) {
			modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_RESPONSE_PHYSICAL);
			modelAndView.addObject(ControllerParamConstant.LIST_LOTS, userService.getLotsRespondedUser(person.getId()));
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/lot/showNumber", method = RequestMethod.GET)
	public @ResponseBody List<String> getNumbers(@RequestParam(value = "id", required = false) Integer idUser) throws ServiceException {
		List<String> phones = userService.getPhonesStringByIdUser(idUser);
		return phones;
	}
}
