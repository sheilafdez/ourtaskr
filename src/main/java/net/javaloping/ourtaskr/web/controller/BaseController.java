package net.javaloping.ourtaskr.web.controller;

import net.javaloping.ourtaskr.util.validation.ValidationException;
import net.javaloping.ourtaskr.util.validation.ValidationExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author victormiranda
 */

@Controller
public class BaseController {

	@ExceptionHandler(ValidationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationExceptionResponse handleFormValidationError(
			ValidationException validationError) {

		ValidationExceptionResponse validationExceptionResponse =
			new ValidationExceptionResponse();

		validationExceptionResponse.setField(validationError.getField());
		validationExceptionResponse.setType(validationError.getType());

		return validationExceptionResponse;
	}
}
