package by.robotun.webapp.controller.validator.cabinet.moderator;

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
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.form.RejectMessageForm;
import by.robotun.webapp.form.validator.RejectMessageFormValidator;
import by.robotun.webapp.service.IModeratorService;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.converter.SerializationJSON;

@Controller
@RequestMapping("/moderator/rejectLot")
public class RejectMessageController {
	
	@Autowired
	private SerializationJSON serializationJSON;

	@Autowired
	private RejectMessageFormValidator rejectMessageFormValidator;
	
	@Autowired
	private IModeratorService moderatorService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView rejectMessage(@RequestParam(value = "id", required = false) Integer idLot, Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Lot lot = userService.getLotByIdForModeration(idLot);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MODERATOR_REJECT_LOT);
		modelAndView.addObject(ControllerParamConstant.LOT_JSON, serializationJSON.toJsonViewsInternalConfirmLot(lot));
		modelAndView.addObject(ControllerParamConstant.REJECT_MESSAGE_FORM, new RejectMessageForm());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView rejectMessageValidation(@ModelAttribute(ControllerParamConstant.REJECT_MESSAGE_FORM) RejectMessageForm rejectMessageForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		System.err.println(rejectMessageForm);
		rejectMessageFormValidator.validate(rejectMessageForm, result);
		if (result.hasErrors()) {
		}
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		moderatorService.addRejectMessage(rejectMessageForm, person.getId());
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_PROFILE_MAIN_MODERATOR);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		return modelAndView;
	}

}
