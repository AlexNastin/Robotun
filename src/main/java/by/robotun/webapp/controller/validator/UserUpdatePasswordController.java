package by.robotun.webapp.controller.validator;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
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
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.form.UserUpdatePasswordForm;
import by.robotun.webapp.form.validator.UserUpdatePasswordFormValidator;
import by.robotun.webapp.service.IGuestService;

@Controller
@RequestMapping("/user/secure/updatePassword")
public class UserUpdatePasswordController {

	@Autowired
	private UserUpdatePasswordFormValidator personalSecurityValidator;

	@Autowired
	private IGuestService guestService;

	@Autowired
	private MessageSource messages;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalSecurity(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView("profile/update_password");
		UserUpdatePasswordForm userUpdatePasswordForm = new UserUpdatePasswordForm();
		modelAndView.addObject(ControllerParamConstant.UPDATE_PASSWORD_FORM, userUpdatePasswordForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(
			@ModelAttribute("userUpdatePasswordForm") UserUpdatePasswordForm userUpdatePasswordForm,
			BindingResult result, HttpSession httpSession, Locale locale) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		personalSecurityValidator.validate(userUpdatePasswordForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("profile/update_password");
			return modelAndView;
		}
		User user = guestService.getUser(person.getId());
		String md5Password = DigestUtils.md5Hex(userUpdatePasswordForm.getOldPassword());
		if (!user.getPassword().equals(md5Password)) {
			ModelAndView modelAndView = new ModelAndView("profile/update_password");
			result.rejectValue("oldPassword", "valid.oldPassword.passwordDontMatch");
			return modelAndView;
		}
		guestService.updatePassword(userUpdatePasswordForm.getPassword(), person.getId());
		ModelAndView modelAndView = new ModelAndView("profile/update_password");
		String message = messages.getMessage("email.message.resetpaswordsuccessful", null, locale);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		modelAndView.addObject("userUpdatePasswordForm", userUpdatePasswordForm);
		return modelAndView;
	}

}
