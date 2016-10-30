package by.web.store.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.web.store.domain.Person;
import by.web.store.domain.User;
import by.web.store.exeption.ServiceException;
import by.web.store.service.IPrivateService;

@Controller
public class PrivateController {
	
	@Autowired
	private IPrivateService privateService;
	
	@RequestMapping(value = "/private", method = RequestMethod.GET)
	public ModelAndView login(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOGIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "/private/main", method = RequestMethod.GET)
	public ModelAndView profileMain(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ERROR_403);
		if(person.getIdRole() == ControllerParamConstant.ADMIN_ROLE) {
			modelAndView = new ModelAndView(URLMapping.REDIRECT_ADMIN_MAIN);
		} else if(person.getIdRole() == ControllerParamConstant.USER_ROLE) {
			modelAndView = new ModelAndView(URLMapping.REDIRECT_USER_MAIN);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/private/admin/main", method = RequestMethod.GET)
	public ModelAndView profileAdminMain(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ADMIN_MAIN);
		modelAndView.addObject(ControllerParamConstant.LIST_USERS, privateService.getUsersByRole(ControllerParamConstant.USER_ROLE));
		modelAndView.addObject(ControllerParamConstant.LOGIN, person.getLogin());
		return modelAndView;
	}
	
	@RequestMapping(value = "/private/user/main", method = RequestMethod.GET)
	public ModelAndView profileUserMain(Locale locale, Model model) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_USER_MAIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "/private/admin/main/delete-user", method = RequestMethod.GET)
	public ModelAndView profileAdminDeleteUser(@RequestParam(value = "id", required = false) Integer idUser, Locale locale, Model model) throws ServiceException {
		privateService.deleteUser(idUser);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_ADMIN_MAIN);
		return modelAndView;
	}

}
