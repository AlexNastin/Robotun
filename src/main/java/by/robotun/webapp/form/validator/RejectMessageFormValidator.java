package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.RejectMessageForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;

@Component
public class RejectMessageFormValidator implements Validator {
	
	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> cls) {
		return RejectMessageForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RejectMessageForm rejectMessageForm = (RejectMessageForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_TEXT, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternLogin = regExCollection.getRegExPattern(RegExName.REGEX_DESCRIPTION);
		Matcher matcherLogin = patternLogin.matcher(rejectMessageForm.getText());
		if (!matcherLogin.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_TEXT, LocalizationParamNameProperties.VALIDATION_LOT_DESCRIPTION_PATTERN);
		}
	}
}
