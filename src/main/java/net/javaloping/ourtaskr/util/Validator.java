package net.javaloping.ourtaskr.util;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * @author  victormiranda
 */
public class Validator implements Serializable {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

	public static boolean isMail(String email) {
		return !isNull(email) && VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}

	public static boolean isNull(final String val) {
		return (val == null || val.trim().equals(StringConstants.EMPTY_STR));
	}

	public static boolean isNull(final Object val) {
		if (val == null) {
			return true;
		}
		if (val instanceof String) {
			return isNull(val.toString());
		}
		return false;
	}
}
