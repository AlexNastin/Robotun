# Robotunpackage by.beltelecom.cska.security;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import by.beltelecom.cska.controller.helper.ControllerParamConstant;
import by.beltelecom.cska.domain.Person;
import by.beltelecom.cska.domain.User;

public class CSKAAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private static Logger LOGGER = Logger.getLogger(CSKAAuthenticationSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	private String URL = "/index";
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.err.println("Test WebAppAuthenticationSuccessHandler");
		User user = (User) authentication.getPrincipal();
		Person person = new Person();
		person.setLogin(user.getLogin());
		person.setIdPerson(user.getIdUser());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy");
		String expirationDate = simpleDateFormat.format(user.getExpirationDate());
		person.setExpirationDate(expirationDate);
		request.getSession(true).setAttribute(ControllerParamConstant.PERSON, person);
		redirectStrategy.sendRedirect(request, response, URL);
	}

}
