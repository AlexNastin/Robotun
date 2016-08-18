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
 * ����� �����������. ���������� ���� ������������ � ������������� ������ �
 * ���-���������� �������� ����.
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
			throw new UsernameNotFoundException("�������� ����� �/��� ������.");
		}
		User profile = null;
		try {
			profile = userDAO.selectUser(authentication.getPrincipal().toString());
		} catch (DaoException e) {
			LOGGER.error("�������� � ����������� ������������ �� DAO-����, ��� ��������������.");
			throw new UsernameNotFoundException("������ �������.");
		}
		if (profile == null) {
			throw new UsernameNotFoundException("�������� ����� �/��� ������.");
		}
		String suppliedPasswordHash = DigestUtils.md5Hex(authentication.getCredentials().toString());
		if (!profile.getPassword().equals(suppliedPasswordHash)) {
			throw new BadCredentialsException("�������� ����� �/��� ������.");
		}
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(profile, null, getAuthorities(profile.getIdRole()));
		return token;
	}

	/**
	 * ���������� ��������� {@link GrantedAuthority} �� ������ ��������� ����.
	 * @param role - ����� ����
	 * @return ��������� {@link GrantedAuthority}
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * ����������� �������� ���� ������������� ������ �����.
	 * @param role - ����� ����
	 * @return ������ ����� � ���� ������ {@link String}
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
	 * ����������� {@link String} ����� � {@link SimpleGrantedAuthority}
	 * ��������.
	 * @param roles {@link String} �����
	 * @return ������ GrantedAuthority
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
