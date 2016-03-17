package by.robotun.webapp.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IAdminService;


@Controller
public class AdminController {
	
	@Autowired
	IAdminService adminService;
	
	@RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
	public ModelAndView profileAdmin(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		List<User> moderators = adminService.getAllModerators();
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_ADMIN);
		modelAndView.addObject(ControllerParamConstant.LIST_USERS, moderators);
		return modelAndView;
	}

}
