package by.robotun.webapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;

public class WebAppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private static Logger LOGGER = Logger.getLogger(WebAppAuthenticationSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private IUserDAO userDAO;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.err.println("Test WebAppAuthenticationSuccessHandler");
		User user = (User) authentication.getPrincipal();
		Person person = new Person();
		try {
			User us = userDAO.selectUser(user.getLogin());
			person.setId(us.getIdUser());
			person.setIdRole(us.getIdRole());
			person.setLogin(us.getLogin());
			person.setNickname(us.getNickname());
		} catch (DaoException e) {
			LOGGER.error("WebAppAuthenticationSuccessHandler", e);
		}
		request.getSession(true).setAttribute(ControllerParamConstant.PERSON, person);
		String URL = "/index";
		redirectStrategy.sendRedirect(request, response, URL);
	}

}
