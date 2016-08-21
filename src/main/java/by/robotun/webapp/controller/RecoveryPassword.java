package by.robotun.webapp.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.domain.PasswordResetToken;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.form.validator.HelperValidator;
import by.robotun.webapp.localization.LocalizationParamNameProperties;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.impl.MailService;

@Controller
public class RecoveryPassword {

	@Autowired
	private MailService mailService;
	
	@Autowired
	private HelperValidator helperValidator;
	
	@Autowired
	private IGuestService guestService;

	@Autowired
	private MessageSource messages;
	
	@RequestMapping(value = "/forgotPassword.html", method = RequestMethod.GET)
	public ModelAndView forgotPassword(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOGIN_FORGOT_PASSWORD);
		return modelAndView;
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(HttpServletRequest request, @RequestParam("email") String userEmail, Locale locale) {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOGIN_FORGOT_PASSWORD);
		System.out.println(locale);
		System.out.println(locale.getClass());
		if (helperValidator.validationLogin(userEmail)) {
			User user;
			try {
				user = guestService.getUser(userEmail);
			} catch (ServiceException e) {
				modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_ERROR_SERVER, null, locale));
				return modelAndView;
			}
			if (user == null) {
				modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_RECOVERY_PASSWORD_NOT_USER, null, locale));
				return modelAndView;
			}
			String token = null;
			try {
				token = guestService.createPasswordResetTokenForUser(user);
				if (token != null) {
					StringBuilder appUrl = new StringBuilder("http://");
					appUrl.append(request.getServerName());
					appUrl.append(":");
					appUrl.append(request.getServerPort());
					appUrl.append(request.getContextPath());
					String message = messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_RECOVERY_PASSWORD, null, locale);
					String messageSubject = messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_RECOVERY_PASSWORD_SUBJECT, null, locale);
					mailService.sendMail(mailService.constructRecoveryPasswordMailMessage(appUrl.toString(), message, messageSubject, token, user));
					modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_RECOVERY_PASSWORD_EMAIL_SEND, null, locale));
					return modelAndView;
				}
				String message = messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_RECOVERY_PASSWORD_EMAIL, null, locale);
				modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
				return modelAndView;
			} catch (ServiceException e) {
				try {
					guestService.deletePasswordResetTokenForUser(user);
					modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_ERROR_SERVER, null, locale));
					return modelAndView;
				} catch (ServiceException e1) {
					modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_ERROR_SERVER, null, locale));
					return modelAndView;
				}
			}
		} else {
			modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_RECOVERY_PASSWORD_NOT_USER, null, locale));
			return modelAndView;
		}
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/secure/changePassword", method = RequestMethod.GET)
	public ModelAndView showChangePasswordPage(Locale locale, Model model, @RequestParam("id") int id, @RequestParam("token") String token) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOGIN);
		if (helperValidator.validationUUID(token)) {
			PasswordResetToken passwordResetToken = guestService.getPasswordResetToken(token);
			if (passwordResetToken == null || passwordResetToken.getIdUser() != id) {
				modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_INVALID_TOKEN, null, locale));
				return modelAndView;
			}
			Calendar cal = Calendar.getInstance();
			if ((passwordResetToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
				modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_EXPIRED_TOKEN, null, locale));
				return modelAndView;
			}
			List<GrantedAuthority> grantedAuths = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			User user = guestService.getUser(passwordResetToken.getIdUser());
			Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, grantedAuths);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			modelAndView.setViewName(URLMapping.REDIRECT_SECURE_UPDATE_PASSWORD);
			return modelAndView;
		}
		String message = messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_INVALID_TOKEN, null, locale);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		return modelAndView;
	}

	@RequestMapping(value = "/secure/savePassword", method = RequestMethod.POST)
	public ModelAndView saveNewPassword(Locale locale, Model model, @RequestParam("password") String password)
			throws ServiceException {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		guestService.updateForgotPassword(user, password);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_LOGIN);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, messages.getMessage(LocalizationParamNameProperties.MESSAGE_EMAIL_RESET_PASSWORD_SUCCESSFUL, null, locale));
		return modelAndView;
	}
}
