package net.javaloping.ourtaskr.util;

import net.javaloping.ourtaskr.util.annotations.EMail;
import net.javaloping.ourtaskr.util.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *  @author victormiranda
 */
public abstract class ObjectValidator<T> {

	public void validate(T o) throws ValidationException {
		for (Field field : o.getClass().getDeclaredFields()) {
				validateField(field, o);
		}
	}

	private void validateField(Field field,T o) throws ValidationException {
		Annotation annotations[] = field.getDeclaredAnnotations();

		for (Annotation a : annotations) {
			try {
				field.setAccessible(true);
				Object fieldValue = field.get(o);

				if (a.equals(NotNull.class) &&
						Validator.isNull(fieldValue)) {
					throw new ValidationException(
						field, ValidationException.Type.NULL_FIELD);
				}
				if (a.equals(EMail.class) &&
						Validator.isMail((String)fieldValue)) {
					throw new ValidationException(
						field, ValidationException.Type.EMAIL);

				}
			}
			catch (IllegalAccessException e) {
				throw new ValidationException("Error in validator",e);
			}
		}
	}
}
