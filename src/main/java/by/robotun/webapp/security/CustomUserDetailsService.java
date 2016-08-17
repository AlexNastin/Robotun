package by.robotun.webapp.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.DaoException;

/**
 * @author Nastin
 */
@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDAO userDAO;

	private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User userJobster = null;
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		try {
			System.out.println(login+" !");
			userJobster = userDAO.selectUser(login);
			System.out.println(userJobster+" !!");
			System.out.println(userJobster.getLogin()+" !!!");
			LOGGER.info("User: " + userJobster.getLogin() + " i entered this system");
		} catch (DaoException e) {
			LOGGER.error("Problem dao");
		}
		return new org.springframework.security.core.userdetails.User(userJobster.getLogin(),userJobster.getPassword().toLowerCase(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(userJobster.getIdRole()));

	}

	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
	 * @param role the numerical role
	 * @return a collection of {@link GrantedAuthority
	 * 
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * @param role the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();
		if (role.intValue() == 1) {
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
		} else if (role.intValue() == 3) {
			roles.add("ROLE_DESIGNER");
		} else if (role.intValue() == 4) {
			roles.add("ROLE_MODERATOR");
		}
		return roles;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * @param roles {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
