package net.javaloping.ourtaskr.util;

import java.io.Serializable;

/**
 * @author  victormiranda
 */
public class Validator implements Serializable {

	public static boolean isNull(final String val) {
		return (val == null || val.trim().equals(StringConstants.EMPTY_STR));
	}
}
