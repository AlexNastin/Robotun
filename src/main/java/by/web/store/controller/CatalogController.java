package by.web.store.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.web.store.domain.Role;
import by.web.store.exeption.ServiceException;
import by.web.store.service.ICatalogService;

@Controller
public class CatalogController {
	
	@Autowired
	private ICatalogService catalogService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView profileAdmin(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_MAIN);
		return modelAndView;
	}

}
