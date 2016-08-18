package by.robotun.webapp.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.security.validator.AuthenticationValidator;

/**
 * Класс авторизации. Определяет роль пользователя и предоставляет доступ к
 * веб-приложению согласно роли.
 * @author Nastin A. A.
 */
@Component(value = "authenticationProvider")
public class ProduxAuthenticationProvider implements AuthenticationProvider {

	private static final Logger LOGGER = Logger.getLogger(ProduxAuthenticationProvider.class);

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private AuthenticationValidator authenticationValidator;

	/** @see AuthenticationProvider#supports(Class<?>) */
	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}

	/** @see AuthenticationProvider#authenticate(Authentication) */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (!authenticationValidator.validation(authentication.getPrincipal().toString())) {
			throw new UsernameNotFoundException("Неверный логин и/или пароль.");
		}
		User profile = null;
		try {
			profile = userDAO.selectUser(authentication.getPrincipal().toString());
		} catch (DaoException e) {
			LOGGER.error("Проблема с извлечением пользователя из DAO-слоя, при аутентификации.");
			throw new UsernameNotFoundException("Ошибка сервера.");
		}
		if (profile == null) {
			throw new UsernameNotFoundException("Неверный логин и/или пароль.");
		}
		String suppliedPasswordHash = DigestUtils.md5Hex(authentication.getCredentials().toString());
		if (!profile.getPassword().equals(suppliedPasswordHash)) {
			throw new BadCredentialsException("Неверный логин и/или пароль.");
		}
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(profile, null, getAuthorities(profile.getIdRole()));
		return token;
	}

	/**
	 * Возвращает коллекцию {@link GrantedAuthority} на основе нумерации роли.
	 * @param role - номер роли
	 * @return Коллекцию {@link GrantedAuthority}
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * Преобразует числовую роль эквивалентную списку ролей.
	 * @param role - номер роли
	 * @return Список ролей в виде списка {@link String}
	 */
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();
		if (role.intValue() == 1) {
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER_LEGAL");
		} else if (role.intValue() == 3) {
			roles.add("ROLE_USER_PHYSICAL");
		} else if (role.intValue() == 4) {
			roles.add("ROLE_MODERATOR");
		}
		return roles;
	}

	/**
	 * Обертывания {@link String} ролей в {@link SimpleGrantedAuthority}
	 * объектов.
	 * @param roles {@link String} ролей
	 * @return Список GrantedAuthority
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
