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
import by.robotun.webapp.form.AddUserLegalForm;
import by.robotun.webapp.form.validator.AddUserLegalValidator;
import by.robotun.webapp.service.IGuestService;

@Controller
@RequestMapping("/addUserLegal")
public class AddUserLegalController {

	@Autowired
	private AddUserLegalValidator addUserLegalValidator;
	
	@Autowired
	IGuestService guestService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addUserLegal(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.LEGAL_SIGNUP);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_LEGAL_FORM, new AddUserLegalForm());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUserLegalValidation(@ModelAttribute(ControllerParamConstant.ADD_USER_LEGAL_FORM) AddUserLegalForm addUserLegalForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		addUserLegalValidator.validate(addUserLegalForm, result);

		if (result.hasErrors()) {
		}
		
		ModelAndView modelAndView = new ModelAndView(URLMapping.FORWARD_ADD_USER_LEGAL_TO_DB);
		modelAndView.addObject(ControllerParamConstant.ADD_USER_LEGAL_FORM, addUserLegalForm);
		return modelAndView;
	}

}