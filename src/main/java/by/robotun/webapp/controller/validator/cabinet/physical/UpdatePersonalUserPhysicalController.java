package by.robotun.webapp.controller.validator.cabinet.physical;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.controller.URLMapping;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.form.UpdatePersonalUserPhysicalForm;
import by.robotun.webapp.form.validator.UpdatePersonalUserPhysicalFormValidator;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;

@Controller
@RequestMapping("/physical/profile/updatePersonalData")
public class UpdatePersonalUserPhysicalController {

	@Autowired
	private UpdatePersonalUserPhysicalFormValidator updatePersonalUserPhysicalFormValidator;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGuestService guestService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView updatePersonalUserPhysical(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_PERSONAL_PHYSICAL);
		modelAndView.addObject(ControllerParamConstant.UPDATE_PERSONAL_PHYSICAL_FORM, new UpdatePersonalUserPhysicalForm());
		modelAndView.addObject(ControllerParamConstant.USER, userService.getUserById(person.getId()));
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updatePersonalUserPhysicalValidation(@ModelAttribute(ControllerParamConstant.UPDATE_PERSONAL_PHYSICAL_FORM) UpdatePersonalUserPhysicalForm updatePersonalUserPhysicalForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		updatePersonalUserPhysicalFormValidator.validate(updatePersonalUserPhysicalForm, result);
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (result.hasErrors()) {
		}
		userService.updatePersonalUserPhysical(updatePersonalUserPhysicalForm, person.getId(), httpSession);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_PERSONAL_PHYSICAL);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		modelAndView.addObject(ControllerParamConstant.UPDATE_PERSONAL_PHYSICAL_FORM, new UpdatePersonalUserPhysicalForm());
		modelAndView.addObject(ControllerParamConstant.USER, userService.getUserById(person.getId()));
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		return modelAndView;
	}

}
