package by.robotun.webapp.form.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public final class RegExCollection {

	private Pattern PATTERN_PASSWORD = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$");
	private Pattern PATTERN_LOGIN = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
	private Pattern PATTERN_NAME_LOT = Pattern.compile("^[À-ÿ0-9\\s.,]{2,100}$");
	private Pattern PATTERN_DESCRIPTION = Pattern.compile("^[^{}<>]{2,500}$");
	private Pattern PATTERN_DATE = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
	private Pattern PATTERN_NUMBERS = Pattern.compile("^[0-9]+$");
	
	private Pattern PATTERN_RUS_NAME = Pattern.compile("^[À-ÿ¸¨\\-]{2,40}$");
	private Pattern PATTERN_PHONE = Pattern.compile("^[80][0-9]{10,13}$");
	
	private Pattern PATTERN_UUID = Pattern.compile("^[0-9A-Fa-f]{8}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{12}$");
	private Pattern PATTERN_FLAT_LETTER = Pattern.compile("^[À-ÿ¸¨]{1}$");
	private Pattern PATTERN_PERSONAL_ACCOUNT_PATTERN = Pattern.compile("^[0-9]{20}$");
	private Pattern PATTERN_OKPO = Pattern.compile("^[0-9]{12}$");
	private Pattern PATTERN_ROLE = Pattern.compile("(1|2)");
	private Pattern PATTERN_NO_LATIN_LETTERS = Pattern.compile("^[^A-z]+$");
	private Pattern PATTERN_NO_RUS_LETTERS = Pattern.compile("^[^À-ÿ¸¨]+$");
	private Pattern PATTERN_FULL_NAME_USER = Pattern.compile("^[À-ÿ¸¨]{1,20}$");
	private Pattern PATTERN_ENG_LETTERS_AND_NUMBERS = Pattern.compile("^[A-z0-9]{1,24}$");
	private Pattern PATTERN_MFO = Pattern.compile("^[0-9]{9}$");
	private Pattern PATTERN_SUB_BANK_CODE = Pattern.compile("^[0-9]{1,5}$");
	private Pattern PATTERN_CORRESPONDING_ACCOUNT = Pattern.compile("^[0-9]{13}$|^[0-9]{28}$");

	private Map<String, Pattern> regEx = new HashMap<String, Pattern>(32,1f);

	public RegExCollection() {
		regEx.put(RegExName.REGEX_PASSWORD, PATTERN_PASSWORD);
		regEx.put(RegExName.REGEX_LOGIN, PATTERN_LOGIN);
		regEx.put(RegExName.REGEX_NAME_LOT, PATTERN_NAME_LOT);
		regEx.put(RegExName.REGEX_DESCRIPTION, PATTERN_DESCRIPTION);
		regEx.put(RegExName.REGEX_DATE, PATTERN_DATE);
		regEx.put(RegExName.REGEX_NUMBERS, PATTERN_NUMBERS);
		
		
		regEx.put(RegExName.REGEX_FULL_NAME_USER, PATTERN_FULL_NAME_USER);
		regEx.put(RegExName.REGEX_PHONE, PATTERN_PHONE);
		regEx.put(RegExName.REGEX_ROLE, PATTERN_ROLE);
		regEx.put(RegExName.REGEX_RUS_NAME, PATTERN_RUS_NAME);
		regEx.put(RegExName.REGEX_ENG_LETTERS_AND_NUMBERS, PATTERN_ENG_LETTERS_AND_NUMBERS);
		regEx.put(RegExName.REGEX_RUS_LETTERS, PATTERN_NO_RUS_LETTERS);
		regEx.put(RegExName.REGEX_PERSONAL_ACCOUNT, PATTERN_PERSONAL_ACCOUNT_PATTERN);
		regEx.put(RegExName.REGEX_FLAT_LETTER, PATTERN_FLAT_LETTER);
		regEx.put(RegExName.REGEX_OKPO, PATTERN_OKPO);
		regEx.put(RegExName.REGEX_NO_LATIN_LETTERS, PATTERN_NO_LATIN_LETTERS);
		regEx.put(RegExName.REGEX_MFO, PATTERN_MFO);
		regEx.put(RegExName.REGEX_SUB_BANK_CODE , PATTERN_SUB_BANK_CODE);
		regEx.put(RegExName.REGEX_CORRESPONDING_ACCOUNTE , PATTERN_CORRESPONDING_ACCOUNT);
		regEx.put(RegExName.REGEX_UUID, PATTERN_UUID);	
	}

	public Pattern getRegExPattern(String key) {
		return regEx.get(key);
	}
}
