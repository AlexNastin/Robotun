package by.robotun.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import by.robotun.webapp.domain.User;

@WebFilter(urlPatterns = { "/*" })
public class PersonFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName() +"!");
		System.out.println(auth.getPrincipal() +"!!");
		if("GUEST".equals(auth.getName())){
			
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
