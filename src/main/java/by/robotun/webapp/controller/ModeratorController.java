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

import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.service.IModeratorService;


@Controller
public class ModeratorController {
	
	@Autowired
	IModeratorService moderatorService;
	
	@RequestMapping(value = "/moderator/profile", method = RequestMethod.GET)
	public ModelAndView profileModerator(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		List<Lot> lots = moderatorService.getAllLotsOnModeration();
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_MODERATOR);
		modelAndView.addObject(ControllerParamConstant.LIST_LOTS, lots);
		return modelAndView;
	}

}
