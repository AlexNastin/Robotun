package by.robotun.webapp.security.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;

@Component
public class AuthenticationValidator {

	@Autowired
	private RegExCollection regExCollection;

	public boolean validation(String login) {
		boolean isValid = false;
		Pattern pattern = regExCollection.getRegExPattern(RegExName.REGEX_EMAIL);
		Matcher matcher = pattern.matcher(login);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}
}
