package by.web.store.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import by.web.store.dao.IUserDAO;
import by.web.store.domain.User;
import by.web.store.exeption.DaoException;
import by.web.store.form.regex.RegExCollection;
import by.web.store.form.regex.RegExName;

@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private RegExCollection regExCollection;
	
	@Autowired
	private IUserDAO userDAO;
	
	private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);

	private  Pattern patternEmail = null;
	 
	@PostConstruct
	public void init() {
		patternEmail = regExCollection.getRegExPattern(RegExName.REGEX_FIND_EMAIL);
	}
	
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		User userStore = null;
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		String login = "";
		try {
			Matcher matcherEmail = patternEmail.matcher(user);
			if (matcherEmail.find()) {
				login = matcherEmail.group();
			}
			userStore = userDAO.selectUser(login);
		} catch (DaoException e) {
			LOGGER.error("DAO ERROR");
		}
		return new org.springframework.security.core.userdetails.User(userStore.getLogin(),userStore.getPassword().toLowerCase(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(userStore.getIdRole()));
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
