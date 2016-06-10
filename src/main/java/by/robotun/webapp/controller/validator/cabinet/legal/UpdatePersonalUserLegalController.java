package by.robotun.webapp.controller.validator.cabinet.legal;

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
import by.robotun.webapp.domain.User;
import by.robotun.webapp.form.UpdatePersonalUserLegalForm;
import by.robotun.webapp.form.validator.UpdatePersonalUserLegalFormValidator;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;

@Controller
@RequestMapping("/legal/profile/updatePersonalData")
public class UpdatePersonalUserLegalController {

	@Autowired
	private UpdatePersonalUserLegalFormValidator updatePersonalUserLegalFormValidator;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGuestService guestService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView updatePersonalUserLegal(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		User user = userService.getUserById(person.getId());
		UpdatePersonalUserLegalForm updatePersonalUserLegalForm = new UpdatePersonalUserLegalForm();
		updatePersonalUserLegalForm.setAddress(user.getLegal().getAddress());
		updatePersonalUserLegalForm.setIdCity(user.getIdCity());
		updatePersonalUserLegalForm.setNameEnterprise(user.getLegal().getNameEnterprise().replace("\\\"","\""));
		updatePersonalUserLegalForm.setUnp(user.getLegal().getUnp());
		updatePersonalUserLegalForm.setZipCode(user.getLegal().getZipCode());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_PERSONAL_LEGAL);
		modelAndView.addObject(ControllerParamConstant.UPDATE_PERSONAL_LEGAL_FORM, updatePersonalUserLegalForm);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname().replace("\\\"","\""));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updatePersonalUserLegalValidation(@ModelAttribute(ControllerParamConstant.UPDATE_PERSONAL_LEGAL_FORM) UpdatePersonalUserLegalForm updatePersonalUserLegalForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		updatePersonalUserLegalFormValidator.validate(updatePersonalUserLegalForm, result);
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (result.hasErrors()) {
		}
		userService.updatePersonalUserLegal(updatePersonalUserLegalForm, person.getId(), httpSession);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_PERSONAL_LEGAL);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		modelAndView.addObject(ControllerParamConstant.UPDATE_PERSONAL_PHYSICAL_FORM, new UpdatePersonalUserLegalForm());
		modelAndView.addObject(ControllerParamConstant.USER, userService.getUserById(person.getId()));
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.NICKNAME, person.getNickname().replace("\\\"","\""));
		return modelAndView;
	}

}
