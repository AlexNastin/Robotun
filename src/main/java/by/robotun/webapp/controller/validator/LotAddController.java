package by.robotun.webapp.controller.validator;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.controller.URLMapping;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.form.AddLotForm;
import by.robotun.webapp.form.validator.AddLotFormValidator;
import by.robotun.webapp.form.validator.LocalizationParamNameProperties;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.converter.SerializationJSON;

@Controller
@RequestMapping("/user/addLot")
public class LotAddController {

	@Autowired
	private AddLotFormValidator addLotValidator;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGuestService guestService;
	
	@Autowired
	private SerializationJSON serializationJSON;
	
	/** @see org.springframework.context.MessageSource */
	@Autowired
	private MessageSource messages;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addLot(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ADD_LOT);
		List<City> cities = guestService.getAllCities();
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, cities);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES_JSON, serializationJSON.toJsonViewsPublic(cities));
		modelAndView.addObject(ControllerParamConstant.ADD_LOT_FORM, new AddLotForm());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addLotValidation(@ModelAttribute(ControllerParamConstant.ADD_LOT_FORM) AddLotForm addLotForm, BindingResult result, HttpSession httpSession, Locale locale) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ADD_LOT);
		addLotValidator.validate(addLotForm, result);
		List<City> cities = guestService.getAllCities();
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, cities);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES_JSON, serializationJSON.toJsonViewsPublic(cities));
		if (!result.hasErrors()) {
			userService.addLot(addLotForm, person.getId());
			modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_LOT_INSERT_SUCCESSFUL, null, locale));
			addLotForm = new AddLotForm();
		}
		modelAndView.addObject(ControllerParamConstant.ADD_LOT_FORM, addLotForm);
		return modelAndView;
	}
}
