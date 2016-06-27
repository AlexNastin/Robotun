package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.SignupUserPhysicalForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;

@Component
public class SignupUserPhysicalFormValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;
	
	@Override
	public boolean supports(Class<?> cls) {
		return SignupUserPhysicalForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignupUserPhysicalForm addUserPhysicalForm = (SignupUserPhysicalForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_LOGIN, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternLogin = regExCollection.getRegExPattern(RegExName.REGEX_LOGIN);
		Matcher matcherLogin = patternLogin.matcher(addUserPhysicalForm.getLogin());
		if (!matcherLogin.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_LOGIN, LocalizationParamNameProperties.VALIDATION_SIGNUP_LOGIN);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternFIO = regExCollection.getRegExPattern(RegExName.REGEX_FIO);
		Matcher matcherFIO = patternFIO.matcher(addUserPhysicalForm.getName());
		if (!matcherFIO.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_, LocalizationParamNameProperties.VALIDATION_SIGNUP_NAME);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_SURNAME, LocalizationParamNameProperties.VALIDATION_EMPTY);
		matcherFIO.reset(addUserPhysicalForm.getSurname());
		if (!matcherFIO.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_SURNAME, LocalizationParamNameProperties.VALIDATION_SIGNUP_SURNAME);
		}
		String[] phones = addUserPhysicalForm.getPhones();
		Pattern patternPhone = regExCollection.getRegExPattern(RegExName.REGEX_PHONE);
		Matcher matcherPhone = patternPhone.matcher(phones[0]);
		if (!matcherPhone.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_SIGNUP_PHONE);
		}
		for (int i = 1; i < phones.length; i++) {
			if (!"".equals(phones[i])) {
				if (!matcherPhone.matches()) {
					errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_SIGNUP_PHONE);
				}
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_PASSWORD, LocalizationParamNameProperties.VALIDATION_EMPTY);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_CONFIRM_PASSWORD, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternPassword = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		Matcher matcherPassword = patternPassword.matcher(addUserPhysicalForm.getPassword());
		if (!matcherPassword.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_PATTERN);
		}
		if (!(addUserPhysicalForm.getPassword()).equals(addUserPhysicalForm.getConfirmPassword())) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_CONFIRM_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_PASSWORD_DONT_MATCH);
		}
		if (!addUserPhysicalForm.isConfirm()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_CONFIRM, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
	}
}
