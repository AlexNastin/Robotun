package by.web.store.controller.validator;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.web.store.controller.ControllerParamConstant;
import by.web.store.controller.URLMapping;
import by.web.store.domain.Person;
import by.web.store.domain.User;
import by.web.store.form.AddUserForm;
import by.web.store.service.IPrivateService;

@Controller
@RequestMapping("/private/admin/main/add-user")
public class AddUserController {
	
	@Autowired
	IPrivateService privateService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addUser(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ADMIN_ADD_USER);
		AddUserForm addUserForm = new AddUserForm();
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		modelAndView.addObject(ControllerParamConstant.LOGIN, person.getLogin());
		modelAndView.addObject(ControllerParamConstant.FORM_ADD_USER, addUserForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUserValid(
			@ModelAttribute(ControllerParamConstant.FORM_ADD_USER) AddUserForm addUserForm)
			throws Exception {
		User user = new User();
		user.setIdRole(ControllerParamConstant.USER_ROLE);
		user.setLogin(addUserForm.getLogin());
		user.setRegistrationDate(new Date());
		user.setPassword(DigestUtils.md5Hex(addUserForm.getPassword()));
		privateService.addUser(user);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_ADMIN_MAIN);
		return modelAndView;
	}

}
