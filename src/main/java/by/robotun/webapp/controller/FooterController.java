package by.robotun.webapp.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.form.FeedBackFrom;
import by.robotun.webapp.form.validator.HelperValidator;
import by.robotun.webapp.localization.LocalizationParamNameProperties;
import by.robotun.webapp.service.impl.MailService;

@Controller
public class FooterController {

	@Autowired
	private HelperValidator helperValidator;

	@Autowired
	private MailService mailService;

	/** @see org.springframework.context.MessageSource */
	@Autowired
	private MessageSource messages;

	@RequestMapping(value = "/rules", method = RequestMethod.GET)
	public ModelAndView rules() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_RULES);
		return modelAndView;
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public ModelAndView contacts() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_CONTACTS);
		modelAndView.addObject(ControllerParamConstant.FEEDBACK_FORM, new FeedBackFrom());
		return modelAndView;
	}

	@RequestMapping(value = "/contacts/send", method = RequestMethod.POST)
	public ModelAndView sendFeedBack(@ModelAttribute(ControllerParamConstant.FEEDBACK_FORM) FeedBackFrom feedBackFrom,
			BindingResult result, Locale locale) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_FOOTER_CONTACTS);
		modelAndView.addObject(ControllerParamConstant.FEEDBACK_FORM, new FeedBackFrom());
		helperValidator.validationLogin(feedBackFrom.getEmail());
		if (!result.hasErrors()) {
			mailService.sendSimpleMailMessage(mailService.constructFeedbackSimpleMailMessage(feedBackFrom.getEmail(),
					feedBackFrom.getName(), feedBackFrom.getTitle(), feedBackFrom.getText()));
			modelAndView.addObject(ControllerParamConstant.MESSAGE,
					messages.getMessage(LocalizationParamNameProperties.MESSAGE_FEEDBACK_SUCCESSFUL, null, locale));
		}
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
