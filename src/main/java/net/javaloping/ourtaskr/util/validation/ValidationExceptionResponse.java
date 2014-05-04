package net.javaloping.ourtaskr.util.validation;

import java.io.Serializable;
import java.lang.reflect.Field;


/**
 * @author victormiranda
 */
public class ValidationExceptionResponse implements Serializable {

	private String field;
	private ValidationException.Type type;

	public String getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field.getName();
	}

	public void setField(String field) {
		this.field = field;
	}

	public ValidationException.Type getType() {
		return type;
	}

	public void setType(ValidationException.Type type) {
		this.type = type;
	}
}
