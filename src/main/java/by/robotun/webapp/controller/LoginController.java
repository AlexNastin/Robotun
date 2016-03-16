package by.robotun.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;
import by.robotun.webapp.exeption.ServiceException;

@Controller
public class LoginController {
	
	@Autowired
	private IUserDAO userService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login/login");
		return modelAndView;
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView start(Locale locale, Model model) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/putperson", method = RequestMethod.GET)
	public ModelAndView putPerson(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		Person person = new Person();
		try {
			User us = userService.selectUser(user.getLogin());
			person.setId(us.getIdUser());
			person.setIdRole(us.getIdRole());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpSession.setAttribute(ControllerParamConstant.PERSON, person);
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("main");
		return modelAndView;
	}
	
	
}
