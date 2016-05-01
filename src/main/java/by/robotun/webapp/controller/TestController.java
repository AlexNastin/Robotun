package by.robotun.webapp.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import by.robotun.webapp.dao.IUserDAO;

@Controller
public class TestController {

	@Autowired
	private IUserDAO userDao;

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(Locale locale, Model model) {
		return "test1";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		return "test";
	}

	@RequestMapping(value = "/testBase", method = RequestMethod.GET)
	public @ResponseBody String testBase(@RequestParam(value = "count") String count) {
		System.out.println(count);
		return count;
	}

}
