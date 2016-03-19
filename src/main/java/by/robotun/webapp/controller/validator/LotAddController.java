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
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.form.LotFormAdd;
import by.robotun.webapp.form.validator.LotFormAddValidator;
import by.robotun.webapp.service.IUserService;

@Controller
@RequestMapping("/user/addLot")
public class LotAddController {

	@Autowired
	private LotFormAddValidator addLotValidator;
	
	@Autowired
	IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addLot(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ADD_LOT);
		modelAndView.addObject(ControllerParamConstant.ADD_LOT_FORM, new LotFormAdd());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addLotValidation(@ModelAttribute(ControllerParamConstant.ADD_LOT_FORM) LotFormAdd addLotForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		addLotValidator.validate(addLotForm, result);
		if (result.hasErrors()) {
		}
		userService.addLot(addLotForm, person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ADD_LOT);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		modelAndView.addObject(ControllerParamConstant.ADD_LOT_FORM, addLotForm);
		return modelAndView;
	}

}
