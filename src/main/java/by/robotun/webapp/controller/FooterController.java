package by.robotun.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.exception.ServiceException;

@Controller
public class FooterController {

	@RequestMapping(value = "/rules", method = RequestMethod.GET)
	public ModelAndView rules() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_RULES);
		return modelAndView;
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public ModelAndView contacts() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_CONTACTS);
		return modelAndView;
	}

	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public ModelAndView faq() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_FAQ);
		return modelAndView;
	}

	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public ModelAndView policy() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_POLICY);
		return modelAndView;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView safety() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_ABOUT);
		return modelAndView;
	}
}
