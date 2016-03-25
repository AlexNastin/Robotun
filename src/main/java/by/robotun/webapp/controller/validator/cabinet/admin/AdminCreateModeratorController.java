package by.robotun.webapp.controller.validator.cabinet.admin;

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
import by.robotun.webapp.form.AddModeratorForm;
import by.robotun.webapp.form.validator.AddModeratorFormValidator;
import by.robotun.webapp.service.IAdminService;

@Controller
@RequestMapping("/admin/addModerator")
public class AdminCreateModeratorController {

	@Autowired
	private AddModeratorFormValidator addModeratorFormValidator;
	
	@Autowired
	private IAdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addModerator(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_ADMIN_ADD_MODERATOR);
		modelAndView.addObject(ControllerParamConstant.ADD_MODERATOR_FORM, new AddModeratorForm());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addModeratorValidation(@ModelAttribute(ControllerParamConstant.ADD_MODERATOR_FORM) AddModeratorForm addModeratorForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		addModeratorFormValidator.validate(addModeratorForm, result);

		if (result.hasErrors()) {
		}
		adminService.addModerator(addModeratorForm);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_ADMIN_ADD_MODERATOR);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		modelAndView.addObject(ControllerParamConstant.ADD_MODERATOR_FORM, new AddModeratorForm());
		return modelAndView;
	}

}
