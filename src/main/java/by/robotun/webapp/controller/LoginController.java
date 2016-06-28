package by.robotun.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.exception.ServiceException;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView start() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_INDEX);
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_MAIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOGIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "/403page", method = RequestMethod.GET)
	public ModelAndView page403() {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ERROR_403);
		return modelAndView;
	}
}
