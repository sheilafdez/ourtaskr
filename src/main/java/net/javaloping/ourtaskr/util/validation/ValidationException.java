package net.javaloping.ourtaskr.util.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Field;

/**
 * @author victormiranda
 */
public class ValidationException extends Exception {

	private String field;
	private Type type;
	private String reason;

	public ValidationException(Field field,Type type) {
		this.type = type;
		this.field = field.getName();
	}

	public ValidationException(String field,Type type) {
		this.field = field;
		this.type = type;
	}

	public ValidationException(String field,Type type,String reason) {
		this.field = field;
		this.type = type;
		this.reason = reason;
	}

	public String getField() {
		return field;
	}

	public Type getType() {
		return type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public enum Type {
		NULL_FIELD,
		EMAIL,
		FIELDS_DONT_MATCH;
	}

}
