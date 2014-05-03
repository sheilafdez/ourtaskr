package net.javaloping.ourtaskr.web.controller.user;

import net.javaloping.ourtaskr.business.dto.UserDTO;
import net.javaloping.ourtaskr.util.ObjectValidator;
import net.javaloping.ourtaskr.util.ValidationException;
import org.springframework.stereotype.Component;

/**
 * @author  victormiranda
 */

@Component
public class UserValidator extends ObjectValidator<UserDTO>{

	public void validate(UserDTO user) throws ValidationException{
		super.validate(user);
	}
}
