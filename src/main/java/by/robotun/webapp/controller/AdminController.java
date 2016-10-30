package by.robotun.webapp.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.service.IAdminService;
import by.robotun.webapp.service.converter.SerializationJSON;

@Controller
public class AdminController {
	
	@Autowired
	private SerializationJSON serializationJSON;

	@Autowired
	private IAdminService adminService;

	@RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
	public ModelAndView profileAdmin(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		List<User> moderators = adminService.getAllStaffs();
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_ADMIN);
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_JSON, serializationJSON.toJsonViewsInternalForListModerators(moderators));
		modelAndView.addObject(ControllerParamConstant.AVATAR_PATH, person.getPath());
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/deleteUser", method = RequestMethod.GET)
	@ResponseBody
	public int deleteUser(@RequestParam(value = "id", required = false) Integer idUser, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		int status = adminService.deleteUser(idUser);
		return status;
	}
	
	@RequestMapping(value = "/admin/resetModeratorPassword", method = RequestMethod.GET)
	public ModelAndView resetModeratorPassword(@RequestParam(value = "id", required = false) Integer idUser, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		adminService.resetModeratorPassword(idUser);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_PROFILE_MAIN_ADMIN);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public ModelAndView users(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_USERS_ADMIN);
		modelAndView.addObject(ControllerParamConstant.AVATAR_PATH, person.getPath());
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/findUsers", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findUsers(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "id", required = false) Integer idUser) throws ServiceException {
		List<User> users = adminService.findUsersCriteria(idUser, name.replace("*", "%"));
		return serializationJSON.toJsonViewsPublic(users);
	}
}
