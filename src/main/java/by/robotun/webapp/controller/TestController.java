package by.robotun.webapp.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.robotun.webapp.dao.IUserDAO;

@Controller
public class TestController {
	
	@Autowired
	IUserDAO userDao;

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(Locale locale, Model model) {
		return "test1";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		return "test";
	}

}
