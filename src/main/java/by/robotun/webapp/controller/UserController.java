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
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.LotFormAdd;
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
	
	@RequestMapping(value = "/user/addLotToDB", method = RequestMethod.POST)
	public ModelAndView addLotDB(LotFormAdd addLotForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		userService.addLot(addLotForm, person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_ADD_LOT);
		modelAndView.addObject(ControllerParamConstant.FLAG_MESSAGE, true);
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/lot", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam(value = "id", required = true) Integer idLot, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		Lot lot = userService.getLotById(idLot);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOT);
		modelAndView.addObject(ControllerParamConstant.DATE_END_LOT, lot.getEndDate().getTime());
		modelAndView.addObject(ControllerParamConstant.LOT, lot);
		modelAndView.addObject(ControllerParamConstant.ID_USER, person.getId());
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView profileUser(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView();
		if (person.getIdRole()==ServiceParamConstant.ID_ROLE_USER_LEGAL) {
			modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_LEGAL);
		} else if (person.getIdRole()==ServiceParamConstant.ID_ROLE_USER_PHYSICAL) {
			modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_PHYSICAL);
		}
		return modelAndView;
	}

}
