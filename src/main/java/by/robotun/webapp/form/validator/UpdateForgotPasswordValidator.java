package by.robotun.webapp.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.UpdateForgotPasswordForm;
import by.robotun.webapp.form.regex.RegExCollection;
import by.robotun.webapp.form.regex.RegExName;

@Component
public class UpdateForgotPasswordValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return UpdateForgotPasswordForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UpdateForgotPasswordForm updateForgotPasswordForm = (UpdateForgotPasswordForm) target;
		Matcher matcher = null;
		Pattern pattern = null;

		// ��������� Password � ConfirmPassword � �� ����������.
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password.empty");
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		matcher = pattern.matcher(updateForgotPasswordForm.getPassword());
		// �������� � ��������� ��������� �����, �����, �����������. �� 8
		// �������� �� 32
		if (!matcher.matches()) {
			errors.rejectValue("password", "valid.password.pattern");
		}
		if (!(updateForgotPasswordForm.getPassword()).equals(updateForgotPasswordForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "valid.confirmPassword.passwordDontMatch");
		}

	}
}