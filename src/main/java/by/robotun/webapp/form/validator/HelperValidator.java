package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;

@Component
public class HelperValidator {

	@Autowired
	private RegExCollection regExCollection;

	public boolean validationLogin(String login) {
		boolean isValid = false;
		Pattern pattern = regExCollection.getRegExPattern(RegExName.REGEX_LOGIN);
		Matcher matcher = pattern.matcher(login);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}
	
	public boolean validationUUID(String token) {
		boolean isValid = false;
		Pattern pattern = regExCollection.getRegExPattern(RegExName.REGEX_UUID);
		Matcher matcher = pattern.matcher(token);;
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}
}
