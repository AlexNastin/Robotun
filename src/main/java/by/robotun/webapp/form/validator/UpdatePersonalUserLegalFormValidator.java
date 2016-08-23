package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.UpdatePersonalUserLegalForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;
import by.robotun.webapp.localization.LocalizationParamNameProperties;

@Component
public class UpdatePersonalUserLegalFormValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;
	
	@Override
	public boolean supports(Class<?> cls) {
		return UpdatePersonalUserLegalForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UpdatePersonalUserLegalForm updatePersonalUserLegalForm = (UpdatePersonalUserLegalForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_ENTERPRISE, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternNameEnterprise = regExCollection.getRegExPattern(RegExName.REGEX_NAME_ENTERPRISE);
		Matcher matcherNameEnterprise = patternNameEnterprise.matcher(updatePersonalUserLegalForm.getNameEnterprise());
		if (!matcherNameEnterprise.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_NAME_ENTERPRISE, LocalizationParamNameProperties.VALIDATION_SIGNUP_NAME_ENTERPRISE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_UNP, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternUNP = regExCollection.getRegExPattern(RegExName.REGEX_UNP);
		Matcher matcherUNP = patternUNP.matcher(updatePersonalUserLegalForm.getUnp());
		if (!matcherUNP.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_UNP, LocalizationParamNameProperties.VALIDATION_SIGNUP_UNP);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternAddress = regExCollection.getRegExPattern(RegExName.REGEX_ADDRESS);
		Matcher matcherAddress = patternAddress.matcher(updatePersonalUserLegalForm.getAddress());
		if (!matcherAddress.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_PHONES, LocalizationParamNameProperties.VALIDATION_SIGNUP_ADDRESS);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_REGISTRATION_ZIPCODE, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternZipCode = regExCollection.getRegExPattern(RegExName.REGEX_ZIPCODE);
		Matcher matcherZipCode = patternZipCode.matcher(updatePersonalUserLegalForm.getZipCode());
		if (!matcherZipCode.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_ZIPCODE, LocalizationParamNameProperties.VALIDATION_SIGNUP_ZIPCODE);
		}
		if (updatePersonalUserLegalForm.getIdCity() == 0) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_REGISTRATION_ID_CITY, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
		String[] phones = updatePersonalUserLegalForm.getPhones();
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
