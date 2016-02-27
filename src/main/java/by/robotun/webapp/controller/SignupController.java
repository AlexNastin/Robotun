package by.robotun.webapp.controller;

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

import by.robotun.webapp.form.SignupUserLegalForm;
import by.robotun.webapp.form.SignupUserPhysicalForm;
import by.robotun.webapp.form.validator.SignupUserLegalFormValidator;
import by.robotun.webapp.form.validator.SignupUserPhysicalFormValidator;
import by.robotun.webapp.service.IGuestService;

@Controller
public class SignupController {

	@Autowired
	private SignupUserPhysicalFormValidator addUserPhysicalValidator;

	@Autowired
	private SignupUserLegalFormValidator addUserLegalValidator;

	@Autowired
	private IGuestService guestService;

	@RequestMapping(value = "/signup ", method = RequestMethod.GET)
	public ModelAndView addUserPhysical(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_SIGNUP);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_PHYSICAL_FORM, new SignupUserPhysicalForm());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_LEGAL_FORM, new SignupUserLegalForm());
		return modelAndView;
	}

	@RequestMapping(value = "/signup/userPhysical", method = RequestMethod.POST)
	public ModelAndView addUserPhysicalValidation(
			@ModelAttribute(ControllerParamConstant.ADD_USER_PHYSICAL_FORM) SignupUserPhysicalForm signupUserPhysicalForm,
			BindingResult result, HttpSession httpSession) throws Exception {
		addUserPhysicalValidator.validate(signupUserPhysicalForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_SIGNUP);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_SIGNUP);
		guestService.addUserPhysical(signupUserPhysicalForm);
		String message = "ADDDDD";
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message); 
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_LEGAL_FORM, new SignupUserLegalForm());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_PHYSICAL_FORM,  new SignupUserPhysicalForm());
		return modelAndView;
	}

	@RequestMapping(value = "/signup/userLegal", method = RequestMethod.POST)
	public ModelAndView addUserLegalValidation(
			@ModelAttribute(ControllerParamConstant.ADD_USER_LEGAL_FORM)  SignupUserLegalForm signupUserLegalForm,
			BindingResult result, HttpSession httpSession) throws Exception {
		addUserLegalValidator.validate(signupUserLegalForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_SIGNUP);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_SIGNUP);
		guestService.addUserLegal(signupUserLegalForm);
		String message = "ADDDDD";
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_PHYSICAL_FORM,  new SignupUserPhysicalForm() );
		modelAndView.addObject(ControllerParamConstant.ADD_USER_LEGAL_FORM, new SignupUserLegalForm());
		return modelAndView;
	}
}
