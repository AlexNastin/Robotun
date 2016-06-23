package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.AddLotForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;

@Component
public class AddLotFormValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return AddLotForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddLotForm addLotForm = (AddLotForm) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_NAME, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternName = regExCollection.getRegExPattern(RegExName.REGEX_NAME_LOT);
		Matcher matcherFirmName = patternName.matcher(addLotForm.getName());
		if (!matcherFirmName.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_NAME, LocalizationParamNameProperties.VALIDATION_LOT_NAME_PATERN);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_DESCRIPTION, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternDescription = regExCollection.getRegExPattern(RegExName.REGEX_DESCRIPTION);
		Matcher matcherDescription = patternDescription.matcher(addLotForm.getDescription());
		if (!matcherDescription.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_DESCRIPTION, LocalizationParamNameProperties.VALIDATION_LOT_DESCRIPTION_PATTERN);
		}
		if (addLotForm.getIdCategory() == 0) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_ID_CATEGORY, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
		if (addLotForm.getIdSubcategory() == 0) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_ID_SUBCATEGORY, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_END_DATE, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternEndDate = regExCollection.getRegExPattern(RegExName.REGEX_DATE);
		Matcher matcherDateBirth = patternEndDate.matcher(addLotForm.getEndDate());
		if (!matcherDateBirth.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_END_DATE, LocalizationParamNameProperties.VALIDATION_DATE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_BUDGET, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternBudget = regExCollection.getRegExPattern(RegExName.REGEX_NUMBERS);
		Matcher matcherBudget = patternBudget.matcher(addLotForm.getBudget());
		if (!matcherBudget.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_BUDGET, LocalizationParamNameProperties.VALIDATION_LOT_BUDGET_PATERN);
		}
	}
}
