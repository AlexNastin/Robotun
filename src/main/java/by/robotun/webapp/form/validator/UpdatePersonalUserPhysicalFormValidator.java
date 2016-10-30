package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.UpdatePersonalUserPhysicalForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;
import by.robotun.webapp.localization.LocalizationParamNameProperties;

@Component
public class UpdatePersonalUserPhysicalFormValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;
	
	@Override
	public boolean supports(Class<?> cls) {
		return UpdatePersonalUserPhysicalForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UpdatePersonalUserPhysicalForm updatePersonalUserPhysicalForm = (UpdatePersonalUserPhysicalForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternFIO = regExCollection.getRegExPattern(RegExName.REGEX_FIO);
		Matcher matcherFIO = patternFIO.matcher(updatePersonalUserPhysicalForm.getName());
		if (!matcherFIO.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_, LocalizationParamNameProperties.VALIDATION_SIGNUP_NAME);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_SURNAME, LocalizationParamNameProperties.VALIDATION_EMPTY);
		matcherFIO.reset(updatePersonalUserPhysicalForm.getSurname());
		if (!matcherFIO.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_SURNAME, LocalizationParamNameProperties.VALIDATION_SIGNUP_SURNAME);
		}
		String[] phones = updatePersonalUserPhysicalForm.getPhones();
		Pattern patternPhone = regExCollection.getRegExPattern(RegExName.REGEX_PHONE);
		int countPhone = 0;
		for (int i = 1; i < phones.length; i++) {
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
