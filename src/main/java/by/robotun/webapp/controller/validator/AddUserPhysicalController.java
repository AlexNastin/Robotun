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
import by.robotun.webapp.form.AddUserPhysicalForm;
import by.robotun.webapp.form.validator.AddUserPhysicalValidator;
import by.robotun.webapp.service.IGuestService;

@Controller
@RequestMapping("/addUserPhysical")
public class AddUserPhysicalController {

	@Autowired
	private AddUserPhysicalValidator addUserPhysicalValidator;
	
	@Autowired
	IGuestService guestService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addUserPhysical(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.PHYSICAL_SIGNUP);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.ADD_USER_PHYSICAL_FORM, new AddUserPhysicalForm());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUserPhysicalValidation(@ModelAttribute(ControllerParamConstant.ADD_USER_PHYSICAL_FORM) AddUserPhysicalForm addUserPhysicalForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		addUserPhysicalValidator.validate(addUserPhysicalForm, result);

		if (result.hasErrors()) {
		}
		
		ModelAndView modelAndView = new ModelAndView(URLMapping.FORWARD_ADD_USER_PHYSICAL_TO_DB);
		modelAndView.addObject(ControllerParamConstant.ADD_USER_PHYSICAL_FORM, addUserPhysicalForm);
		return modelAndView;
	}

}
