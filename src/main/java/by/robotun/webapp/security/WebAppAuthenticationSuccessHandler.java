package by.robotun.webapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.domain.User;

public class WebAppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	private String URL = "/index";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		User user = (User) authentication.getPrincipal();
		Person person = new Person();
		person.setId(user.getIdUser());
		person.setIdRole(user.getIdRole());
		person.setLogin(user.getLogin());
		person.setNickname(user.getNickname());
		person.setIdCity(user.getIdCity());
		request.getSession(true).setAttribute(ControllerParamConstant.PERSON, person);
		redirectStrategy.sendRedirect(request, response, URL);
	}
}
