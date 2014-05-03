package net.javaloping.ourtaskr.util;

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

			if (a.equals(NotNull.class)) {
				try {
					if (Validator.isNull((String)field.get(o))) {
						throw new ValidationException();
					}
				} catch (IllegalAccessException e) {
					//TODO
				}
			}
		}
	}
}
