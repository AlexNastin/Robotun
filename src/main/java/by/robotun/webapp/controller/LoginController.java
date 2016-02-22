package by.robotun.webapp.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login/login");
		return modelAndView;
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView start(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("main");
		return modelAndView;
	}
	
	
}
