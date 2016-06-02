package by.robotun.webapp.controller.validator;

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
import by.robotun.webapp.form.SignupUserLegalForm;
import by.robotun.webapp.form.SignupUserPhysicalForm;
import by.robotun.webapp.form.validator.SignupUserLegalFormValidator;
import by.robotun.webapp.service.IGuestService;

@Controller
@RequestMapping(value = "/signup/userLegal")
public class SignupLegalController {

	@Autowired
	private SignupUserLegalFormValidator addUserLegalValidator;

	@Autowired
	private IGuestService guestService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addUserPhysical(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_SIGNUP_LEGAL);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_PHYSICAL_FORM, new SignupUserPhysicalForm());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_LEGAL_FORM, new SignupUserLegalForm());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUserLegalValidation(
			@ModelAttribute(ControllerParamConstant.ADD_USER_LEGAL_FORM)  SignupUserLegalForm signupUserLegalForm,
			BindingResult result, HttpSession httpSession) throws Exception {
		addUserLegalValidator.validate(signupUserLegalForm, result);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_SIGNUP_LEGAL);
		if (!result.hasErrors()) {
			guestService.addUserLegal(signupUserLegalForm);
			String message = "ADDDDD";
			modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_LEGAL_FORM, new SignupUserLegalForm());
		return modelAndView;
	}
}
