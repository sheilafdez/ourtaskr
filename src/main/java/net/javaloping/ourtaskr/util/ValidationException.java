package net.javaloping.ourtaskr.util;

import java.lang.reflect.Field;

/**
 * @author victormiranda
 */
public class ValidationException extends Exception {

	public Type type;
	public Field field;

	public ValidationException() {
		super();
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(Field field,Type type) {
		this.type = type;
		this.field = field;
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	enum Type {
		NULL_FIELD;
	}

}
