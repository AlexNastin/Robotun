package by.robotun.webapp.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.robotun.webapp.service.UserRepository;

@Controller
public class RedisController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/redisTest", method = RequestMethod.GET)
	public String test1(Locale locale, Model model) {
		 userRepository.insertValue("b", "sdfsfs");
		 System.out.println(userRepository.getValue("Alex"));
		return "test1";
	}
}
