package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.ServiceException;
import by.robotun.webapp.form.UpdateUserPasswordForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;
import by.robotun.webapp.service.IGuestService;

@Component
public class UpdateUserPasswordFormValidator implements Validator{

	private static final Logger LOGGER = Logger.getLogger(UpdateUserPasswordFormValidator.class);
	
	@Autowired
	private RegExCollection regExCollection;
	
	@Autowired
	private IGuestService userService; 

	@Override
	public boolean supports(Class<?> arg0) {
		return UpdateUserPasswordFormValidator.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UpdateUserPasswordForm personalSecurityForm = (UpdateUserPasswordForm) target;
		System.err.println(personalSecurityForm.getIdUser() +"!!!!!!!!!!!!!!!!!!!!!2");
		User user = null;
		try {
			System.err.println(personalSecurityForm.getIdUser() +"!!!!!!!!!!!!!!!!!!!!!1");
			user = userService.getSaffUser(personalSecurityForm.getIdUser());
			System.err.println(user);
		} catch (ServiceException e) {
			LOGGER.error("Проблема с извлечением пользователя из DAO-слоя, при аутентификации.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_UPDATE_PASSWORD_OLD_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_EMPTY);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_UPDATE_PASSWORD_NEW_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_EMPTY);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_UPDATE_PASSWORD_CONFIRM_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_EMPTY);
		String md5Password = DigestUtils.md5Hex(personalSecurityForm.getOldPassword());
		if (!(md5Password.equals(user.getPassword()))) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_UPDATE_PASSWORD_OLD_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_OLD_PASSWORD_DONT_MATCH);
		} 
		Pattern pattern = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		Matcher matcher = pattern.matcher(personalSecurityForm.getPassword());
		if (!matcher.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_UPDATE_PASSWORD_NEW_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_PATTERN);
		}
		if (!(personalSecurityForm.getPassword()).equals(personalSecurityForm.getConfirmPassword())) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_UPDATE_PASSWORD_CONFIRM_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_PASSWORD_DONT_MATCH);
		}
	}
}
