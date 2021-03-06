package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.form.SignupUserLegalForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;
import by.robotun.webapp.localization.LocalizationParamNameProperties;

@Component
public class SignupUserLegalFormValidator implements Validator {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private RegExCollection regExCollection;

	private static Logger LOGGER = Logger.getLogger(SignupUserPhysicalFormValidator.class);
	
	@Override
	public boolean supports(Class<?> cls) {
		return SignupUserLegalForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignupUserLegalForm addUserLegalForm = (SignupUserLegalForm) target;
		try {
			User user =  userDAO.selectUser(addUserLegalForm.getLogin());
			if (user != null) {	
				errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_LOGIN, LocalizationParamNameProperties.VALIDATION_SIGNUP_LOGIN_EXIST);
			}
		} catch (DaoException e) {
			LOGGER.error(e);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_ENTERPRISE, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternNameEnterprise = regExCollection.getRegExPattern(RegExName.REGEX_NAME_ENTERPRISE);
		Matcher matcherNameEnterprise = patternNameEnterprise.matcher(addUserLegalForm.getNameEnterprise());
		if (!matcherNameEnterprise.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_ENTERPRISE, LocalizationParamNameProperties.VALIDATION_SIGNUP_NAME_ENTERPRISE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_LOGIN, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternLogin = regExCollection.getRegExPattern(RegExName.REGEX_LOGIN);
		Matcher matcherLogin = patternLogin.matcher(addUserLegalForm.getLogin());
		if (!matcherLogin.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_LOGIN, LocalizationParamNameProperties.VALIDATION_SIGNUP_LOGIN);
		}
		if (addUserLegalForm.getLogin().length() > 50) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_LOGIN, LocalizationParamNameProperties.VALIDATION_SIGNUP_LOGIN);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_UNP, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternUNP = regExCollection.getRegExPattern(RegExName.REGEX_UNP);
		Matcher matcherUNP = patternUNP.matcher(addUserLegalForm.getUnp());
		if (!matcherUNP.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_UNP, LocalizationParamNameProperties.VALIDATION_SIGNUP_UNP);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternAddress = regExCollection.getRegExPattern(RegExName.REGEX_ADDRESS);
		Matcher matcherAddress = patternAddress.matcher(addUserLegalForm.getAddress());
		if (!matcherAddress.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_SIGNUP_ADDRESS);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_ZIPCODE, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternZipCode = regExCollection.getRegExPattern(RegExName.REGEX_ZIPCODE);
		Matcher matcherZipCode = patternZipCode.matcher(addUserLegalForm.getZipCode());
		if (!matcherZipCode.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_ZIPCODE, LocalizationParamNameProperties.VALIDATION_SIGNUP_ZIPCODE);
		}
		if (addUserLegalForm.getIdCity() == 0) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_ID_CITY, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_PASSWORD, LocalizationParamNameProperties.VALIDATION_EMPTY);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_CONFIRM_PASSWORD, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternPassword = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		Matcher matcherPassword = patternPassword.matcher(addUserLegalForm.getPassword());
		if (!matcherPassword.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_PATTERN);
		}
		if (!(addUserLegalForm.getPassword()).equals(addUserLegalForm.getConfirmPassword())) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_CONFIRM_PASSWORD, LocalizationParamNameProperties.VALIDATION_PASSWORD_PASSWORD_DONT_MATCH);
		}
		if (!addUserLegalForm.isConfirm()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_CONFIRM, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
		String[] phones = addUserLegalForm.getPhones();
		Pattern patternPhone = regExCollection.getRegExPattern(RegExName.REGEX_PHONE);
		int countPhone = 0;
		for (int i = 0; i < phones.length; i++) {
			if (!"".equals(phones[i])) {
				countPhone++;
				Matcher matcherPhone = patternPhone.matcher(phones[i]);
				if (!matcherPhone.matches()) {
					errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_SIGNUP_PHONE);
				}
			}
		}
		if (countPhone == 0) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_SIGNUP_PHONE_EMPTY);
		}
	}
}
