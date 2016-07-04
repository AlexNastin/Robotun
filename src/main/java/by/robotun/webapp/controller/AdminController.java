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
import org.springframework.web.servlet.ModelAndView;


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
		List<User> moderators = adminService.getAllStaffs();
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_PROFILE_MAIN_ADMIN);
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_JSON, serializationJSON.toJsonViewsInternalForListModerators(moderators));
		return modelAndView;
	}

	@RequestMapping(value = "/admin/deleteModerator", method = RequestMethod.GET)
	public ModelAndView deleteModerator(@RequestParam(value = "id", required = false) Integer idUser, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		adminService.deleteModerator(idUser);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_PROFILE_MAIN_ADMIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/resetModeratorPassword", method = RequestMethod.GET)
	public ModelAndView resetModeratorPassword(@RequestParam(value = "id", required = false) Integer idUser, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		adminService.resetModeratorPassword(idUser);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_PROFILE_MAIN_ADMIN);
		return modelAndView;
	}

}
