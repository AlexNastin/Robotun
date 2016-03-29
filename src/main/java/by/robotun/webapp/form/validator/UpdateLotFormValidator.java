package by.robotun.webapp.form.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.robotun.webapp.form.UpdateLotForm;

@Component
public class UpdateLotFormValidator implements Validator {

	private static Logger LOGGER = Logger.getLogger(UpdateLotFormValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		return UpdateLotForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UpdateLotForm updateLotForm = (UpdateLotForm) target;
		Matcher matcher = null;
		Pattern pattern = null;
//		List<String> emails = null;
//		List<String> nickNames = null;
//		try {
//			emails = guestService.getAllEmail();
//			nickNames = guestService.getAllNickName();
//		} catch (ServiceException e) {
//			LOGGER.error("Problems with getting a name and/or nickname.", e);
//		}
//
//		// Валидация Role
//		if ((signupForm.getRole_idRole() == 0)) {
//			errors.rejectValue("role_idRole", "valid.role.empty");
//		}
//
//		// Валидация Login (email)
//		// На пустое значение
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
//				"valid.login.empty");
//		// Количество до 45.
//		if (signupForm.getLogin().length() > 45) {
//			errors.rejectValue("login", "valid.login.maxsize");
//		}
//		// На сам тип email
//		if (!EmailValidator.getInstance().isValid(signupForm.getLogin())) {
//			errors.rejectValue("login", "valid.login.pattern");
//		}
//		// Содержиться ли такой Email в БД
//		if (emails.contains(signupForm.getLogin())) {
//			errors.rejectValue("login", "valid.login.exists");
//		}
//
//		// Валидация NickName
//		// На пустое значение
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName",
//				"valid.nickName.empty");
//		String userNickName = signupForm.getNickName();
//		pattern = regExCollection
//				.getRegExPattern(RegExName.REGEX_NICKNAME_USER);
//		matcher = pattern.matcher(userNickName);
//		// На пустую строку. Количество от 3 символов до 16. Латиница. Нет
//		// спецсимволов.
//		if (!matcher.matches()) {
//			errors.rejectValue("nickName", "valid.nickName.pattern");
//		}
//		// Содержиться ли такой NickName в БД
//		if (nickNames.contains(userNickName)) {
//			errors.rejectValue("nickName", "valid.nickName.exists");
//		}
//
//		// Валидация Password и ConfirmPassword и их совпадение.
//		// На пустое значение
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//				"valid.password.empty");
//		pattern = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
//		matcher = pattern.matcher(signupForm.getPassword());
//		// Строчные и прописные латинские буквы, цифры, спецсимволы. От 8
//		// символов до 32
//		if (!matcher.matches()) {
//			errors.rejectValue("password", "valid.password.pattern");
//		}
//		if (!(signupForm.getPassword()).equals(signupForm.getConfirmPassword())) {
//			errors.rejectValue("confirmPassword",
//					"valid.confirmPassword.passwordDontMatch");
//		}

	}
}
