package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.UpdateLotForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;

@Component
public class UpdateLotFormValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;
	
	@Override
	public boolean supports(Class<?> cls) {
		return UpdateLotForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UpdateLotForm updateLotForm = (UpdateLotForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_NAME, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternName = regExCollection.getRegExPattern(RegExName.REGEX_NAME_LOT);
		Matcher matcherFirmName = patternName.matcher(updateLotForm.getName());
		if (!matcherFirmName.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_NAME, LocalizationParamNameProperties.VALIDATION_LOT_NAME_PATTERN);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_DESCRIPTION, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternDescription = regExCollection.getRegExPattern(RegExName.REGEX_DESCRIPTION);
		Matcher matcherDescription = patternDescription.matcher(updateLotForm.getDescription());
		if (!matcherDescription.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_DESCRIPTION, LocalizationParamNameProperties.VALIDATION_LOT_DESCRIPTION_PATTERN);
		}
		if (updateLotForm.getIdCategory() == 0) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_ID_CATEGORY, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
		if (updateLotForm.getIdSubcategory() == 0) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_ID_SUBCATEGORY, LocalizationParamNameProperties.VALIDATION_EMPTY);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_END_DATE, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternEndDate = regExCollection.getRegExPattern(RegExName.REGEX_DATE);
		Matcher matcherDateBirth = patternEndDate.matcher(updateLotForm.getEndDate());
		if (!matcherDateBirth.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_END_DATE, LocalizationParamNameProperties.VALIDATION_DATE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorParamConstant.FIELD_FORM_ADD_LOT_BUDGET, LocalizationParamNameProperties.VALIDATION_EMPTY);
		Pattern patternBudget = regExCollection.getRegExPattern(RegExName.REGEX_NUMBERS);
		Matcher matcherBudget = patternBudget.matcher(updateLotForm.getBudget());
		if (!matcherBudget.matches()) {
			errors.rejectValue(ValidatorParamConstant.FIELD_FORM_ADD_LOT_BUDGET, LocalizationParamNameProperties.VALIDATION_LOT_BUDGET_PATTERN);
		}
	}
}
