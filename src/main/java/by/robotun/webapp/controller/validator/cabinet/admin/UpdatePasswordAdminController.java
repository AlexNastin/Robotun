package by.robotun.webapp.controller.validator.cabinet.admin;

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
import by.robotun.webapp.form.UpdateUserPasswordForm;
import by.robotun.webapp.form.validator.LocalizationParamNameProperties;
import by.robotun.webapp.form.validator.UpdateUserPasswordFormValidator;
import by.robotun.webapp.service.IGuestService;

@Controller
@RequestMapping("/admin/secure/updatePassword")
public class UpdatePasswordAdminController {

	@Autowired
	private UpdateUserPasswordFormValidator personalSecurityValidator;
	
	@Autowired
	private IGuestService guestService;

	@Autowired
	private MessageSource messages;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView updatePassword(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_ADMIN_UPDATE_PASSWORD);
		UpdateUserPasswordForm userUpdatePasswordForm = new UpdateUserPasswordForm();
		modelAndView.addObject(ControllerParamConstant.UPDATE_PASSWORD_FORM, userUpdatePasswordForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updatePasswordValid(@ModelAttribute(ControllerParamConstant.UPDATE_PASSWORD_FORM) UpdateUserPasswordForm userUpdatePasswordForm, BindingResult result, HttpSession httpSession, Locale locale) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		userUpdatePasswordForm.setIdUser(person.getId());
		personalSecurityValidator.validate(userUpdatePasswordForm, result);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_ADMIN_UPDATE_PASSWORD);
		modelAndView.addObject(ControllerParamConstant.UPDATE_PASSWORD_FORM, userUpdatePasswordForm);
		if (!result.hasErrors()) {
			String message = messages.getMessage(LocalizationParamNameProperties.CHANGE_PASSWORD_SUCCESSFUL, null, locale);
			userUpdatePasswordForm.setIdUser(person.getId());
			guestService.updatePassword(userUpdatePasswordForm);
			modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		}
		return modelAndView;
	}
}
