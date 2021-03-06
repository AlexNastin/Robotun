package by.robotun.webapp.controller.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.controller.URLMapping;
import by.robotun.webapp.domain.City;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.form.UpdateLotForm;
import by.robotun.webapp.form.validator.UpdateLotFormValidator;
import by.robotun.webapp.localization.LocalizationParamNameProperties;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.ServiceParamConstant;
import by.robotun.webapp.service.converter.SerializationJSON;

@Controller
@RequestMapping("/user/updateLot")
public class LotUpdateController {

	@Autowired
	private UpdateLotFormValidator updateLotFormValidator;
	
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
	public ModelAndView updateLot(@RequestParam(value = "id", required = false) Integer idLot, Locale locale, ModelMap model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = null;
		Lot lot = userService.getLotById(idLot);
		if(lot != null && lot.getIdUser() == person.getId()) {
			modelAndView = new ModelAndView(URLMapping.JSP_UPDATE_LOT);
			DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE_WITHOUT_TIME);
			UpdateLotForm updateLotForm = new UpdateLotForm();
			updateLotForm.setBudget(String.valueOf(lot.getBudget()));
			updateLotForm.setIdLot(idLot);
			updateLotForm.setDescription(lot.getDescription());
			updateLotForm.setIdCategory(lot.getIdCategory());
			updateLotForm.setIdCity(lot.getIdCity());
			updateLotForm.setIdSubcategory(lot.getIdSubcategory());
			updateLotForm.setIsCall(lot.getIsCall());
			updateLotForm.setName(lot.getName());
			List<City> cities = guestService.getAllCities();
			modelAndView.addObject(ControllerParamConstant.LIST_CITIES, cities);
			modelAndView.addObject(ControllerParamConstant.LIST_CITIES_JSON, serializationJSON.toJsonViewsPublic(cities));
			modelAndView.addObject(ControllerParamConstant.UPDATE_LOT_FORM, updateLotForm);
			modelAndView.addObject(ControllerParamConstant.LOT, lot);
			modelAndView.addObject(ControllerParamConstant.DATE_END_LOT, dateFormat.format(lot.getEndDate()));
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(lot.getEndDate());
			modelAndView.addObject(ControllerParamConstant.HOUR_END_LOT, calendar.get(Calendar.HOUR_OF_DAY));
		} else {
			modelAndView = new ModelAndView(URLMapping.JSP_ERROR_404);
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updateLotValidation(@ModelAttribute(ControllerParamConstant.UPDATE_LOT_FORM) UpdateLotForm updateLotForm, BindingResult result, Locale locale) throws Exception {
		updateLotFormValidator.validate(updateLotForm, result);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_UPDATE_LOT);
		if (!result.hasErrors()) {
			userService.updateLot(updateLotForm);
			modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_LOT_UPDATE_SUCCESSFUL, null, locale));
		}
		Lot lot = userService.getLotById(updateLotForm.getIdLot());
		modelAndView.addObject(ControllerParamConstant.UPDATE_LOT_FORM, updateLotForm);
		List<City> cities = guestService.getAllCities();
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, cities);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES_JSON, serializationJSON.toJsonViewsPublic(cities));
		modelAndView.addObject(ControllerParamConstant.LOT, lot);
		DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE_WITHOUT_TIME);
		modelAndView.addObject(ControllerParamConstant.DATE_END_LOT, dateFormat.format(lot.getEndDate()));
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(lot.getEndDate());
		modelAndView.addObject(ControllerParamConstant.HOUR_END_LOT, calendar.get(Calendar.HOUR_OF_DAY));
		return modelAndView;
	}

}
