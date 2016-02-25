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
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.AddUserLegalForm;
import by.robotun.webapp.form.AddUserPhysicalForm;
import by.robotun.webapp.service.IGuestService;


@Controller
public class GuestController {
	
	@Autowired
	IGuestService guestService;
	
	@RequestMapping(value = "/addUserPhysicalToDB", method = RequestMethod.POST)
	public ModelAndView addUserPhysicalDB(AddUserPhysicalForm addUserPhysicalForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		guestService.addUserPhysical(addUserPhysicalForm);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_MAIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "/addUserLegalToDB", method = RequestMethod.POST)
	public ModelAndView addUserLegalDB(AddUserLegalForm addUserLegalForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		guestService.addUserLegal(addUserLegalForm);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_MAIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam(value = "idCategory", required = false) Integer idCategory,
			@RequestParam(value = "idSubcategory", required = false) Integer idSubcategory, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		List<Lot> lots;
		if(idCategory == null && idSubcategory == null) {
			lots = guestService.getAllLots();
		} else if(idSubcategory == null) {
			// дописать метод
			lots = guestService.getAllLotsByCategory();
		} else {
			// дописать метод
			lots = guestService.getAllLotsByCategoryAndSubcategory();
		}
		ModelAndView modelAndView = new ModelAndView(URLMapping.RESULT);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS, lots);
		return modelAndView;
	}

}
