package by.robotun.webapp.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.exeption.ServiceException;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOGIN);
		return modelAndView;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView start(Locale locale, Model model) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_INDEX);
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_MAIN);
		return modelAndView;
	}
}
