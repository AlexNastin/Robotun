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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.controller.URLMapping;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.form.AddLotForm;
import by.robotun.webapp.form.validator.AddLotValidator;
import by.robotun.webapp.service.IUserService;

@Controller
@RequestMapping("/user/addLot")
public class AddLotController {

	@Autowired
	private AddLotValidator addLotValidator;
	
	@Autowired
	IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addLot(@RequestParam(value = "flagMessage", required = false) Boolean flagMessage, Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		System.out.println(person);
		ModelAndView modelAndView = new ModelAndView(URLMapping.ADD_LOT);
		modelAndView.addObject(ControllerParamConstant.ADD_LOT_FORM, new AddLotForm());
		if (flagMessage != null) {
			modelAndView.addObject(ControllerParamConstant.FLAG_MESSAGE, flagMessage);
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addLotValidation(@ModelAttribute(ControllerParamConstant.ADD_LOT_FORM) AddLotForm addLotForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		addLotValidator.validate(addLotForm, result);

		if (result.hasErrors()) {
		}
		
		ModelAndView modelAndView = new ModelAndView(URLMapping.FORWARD_ADD_LOT_TO_DB);
		modelAndView.addObject(ControllerParamConstant.ADD_LOT_FORM, addLotForm);
		return modelAndView;
	}

}
