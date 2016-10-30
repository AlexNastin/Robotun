package by.web.store.form.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public final class RegExCollection {
	private Pattern PATTERN_PASSWORD = Pattern.compile("[\\s\\S]{8,255}");
	private Pattern PATTERN_LOGIN = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
	private Pattern PATTERN_NAME_LOT = Pattern.compile("^[^{}<>\\/]{2,100}$");
	private Pattern PATTERN_DESCRIPTION = Pattern.compile("^[^{}<>\\/]{2,500}$");
	private Pattern PATTERN_DATE = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}\\s{1}[0-9]{2}:{1}[0-9]{2}:{1}[0-9]{2}$");
	private Pattern PATTERN_NUMBERS = Pattern.compile("^[0-9]+$");
	private Pattern PATTERN_NAME_ENTERPRISE = Pattern.compile("^[^{}<>\\/]{2,150}$");
	private Pattern PATTERN_UNP = Pattern.compile("^[0-9]{9}$");
	private Pattern PATTERN_ZIPCODE = Pattern.compile("^[0-9]{6}$");
	private Pattern PATTERN_ADDRESS = Pattern.compile("^[^{}<>\\/]{2,250}$");
	private Pattern PATTERN_FIO = Pattern.compile("^[À-ÿ¸¨\\-]{2,40}$");
	private Pattern PATTERN_PHONE = Pattern.compile("^[+][0-9]{10,13}$");
	private Pattern PATTERN_FIND_EMAIL= Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
	private Pattern PATTERN_UUID = Pattern.compile("^[0-9A-Fa-f]{8}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{12}$");

	private Map<String, Pattern> regEx = new HashMap<String, Pattern>(32,1f);

	public RegExCollection() {
		regEx.put(RegExName.REGEX_UUID, PATTERN_UUID);	
		regEx.put(RegExName.REGEX_PASSWORD, PATTERN_PASSWORD);
		regEx.put(RegExName.REGEX_LOGIN, PATTERN_LOGIN);
		regEx.put(RegExName.REGEX_NAME_LOT, PATTERN_NAME_LOT);
		regEx.put(RegExName.REGEX_DESCRIPTION, PATTERN_DESCRIPTION);
		regEx.put(RegExName.REGEX_DATE, PATTERN_DATE);
		regEx.put(RegExName.REGEX_NUMBERS, PATTERN_NUMBERS);
		regEx.put(RegExName.REGEX_NAME_ENTERPRISE, PATTERN_NAME_ENTERPRISE);
		regEx.put(RegExName.REGEX_UNP, PATTERN_UNP);
		regEx.put(RegExName.REGEX_ZIPCODE, PATTERN_ZIPCODE);
		regEx.put(RegExName.REGEX_ADDRESS, PATTERN_ADDRESS);
		regEx.put(RegExName.REGEX_PHONE, PATTERN_PHONE);
		regEx.put(RegExName.REGEX_FIO, PATTERN_FIO);
		regEx.put(RegExName.REGEX_FIND_EMAIL, PATTERN_FIND_EMAIL);	
	}

	public Pattern getRegExPattern(String key) {
		return regEx.get(key);
	}
}
