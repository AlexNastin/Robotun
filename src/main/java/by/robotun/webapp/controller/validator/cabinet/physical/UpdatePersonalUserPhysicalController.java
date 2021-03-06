package by.robotun.webapp.controller.validator.cabinet.physical;

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
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.form.UpdatePersonalUserPhysicalForm;
import by.robotun.webapp.form.validator.UpdatePersonalUserPhysicalFormValidator;
import by.robotun.webapp.localization.LocalizationParamNameProperties;
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
	
	/** @see org.springframework.context.MessageSource */
	@Autowired
	private MessageSource messages;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView updatePersonalUserPhysical(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		User user = userService.getUserById(person.getId());
		UpdatePersonalUserPhysicalForm personalUserPhysicalForm = new UpdatePersonalUserPhysicalForm();
		personalUserPhysicalForm.setIdCity(user.getIdCity());
		personalUserPhysicalForm.setName(user.getPhysical().getName());
		personalUserPhysicalForm.setSurname(user.getPhysical().getSurname());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_PERSONAL_PHYSICAL);
		modelAndView.addObject(ControllerParamConstant.UPDATE_PERSONAL_PHYSICAL_FORM, personalUserPhysicalForm);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
		modelAndView.addObject(ControllerParamConstant.AVATAR_PATH, person.getPath());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updatePersonalUserPhysicalValidation(@ModelAttribute(ControllerParamConstant.UPDATE_PERSONAL_PHYSICAL_FORM) UpdatePersonalUserPhysicalForm updatePersonalUserPhysicalForm,
		BindingResult result, HttpSession httpSession, Locale locale) throws Exception {
		updatePersonalUserPhysicalFormValidator.validate(updatePersonalUserPhysicalForm, result);
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_PERSONAL_PHYSICAL);
		if (!result.hasErrors()) {
			userService.updatePersonalUserPhysical(updatePersonalUserPhysicalForm, person.getId(), httpSession);
			modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_PERSONAL_DATA_UPDATE_SUCCESSFUL, null, locale));
			updatePersonalUserPhysicalForm = new UpdatePersonalUserPhysicalForm();
		}
		modelAndView.addObject(ControllerParamConstant.UPDATE_PERSONAL_PHYSICAL_FORM, updatePersonalUserPhysicalForm);
		modelAndView.addObject(ControllerParamConstant.USER, userService.getUserById(person.getId()));
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname());
		modelAndView.addObject(ControllerParamConstant.AVATAR_PATH, person.getPath());
		return modelAndView;
	}

}
