package by.robotun.webapp.controller.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.form.UpdateForgotPasswordForm;
import by.robotun.webapp.form.validator.UpdateForgotPasswordValidator;

@Controller
@RequestMapping("/secure/updatePassword")
public class UpdateForgotPasswordController {

	@Autowired
	private UpdateForgotPasswordValidator updateForgotPasswordValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalSecurity(Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/update_forgot_password");
		UpdateForgotPasswordForm updateForgotPasswordForm = new UpdateForgotPasswordForm();
		modelAndView.addObject(ControllerParamConstant.UPDATE_FORGOT_PASSWORD_FORM, updateForgotPasswordForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(
			@ModelAttribute("updateForgotPasswordForm") UpdateForgotPasswordForm updateForgotPasswordForm,
			BindingResult result) throws Exception {
		updateForgotPasswordValidator.validate(updateForgotPasswordForm, result);
		ModelAndView modelAndView = new ModelAndView("login/update_forgot_password");
		if (!result.hasErrors()) {
			modelAndView = new ModelAndView("forward:/secure/savePassword");
		}
		;
		modelAndView.addObject("password", updateForgotPasswordForm.getPassword());
		return modelAndView;
	}

}
