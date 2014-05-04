package net.javaloping.ourtaskr.web.controller.user;

import static net.javaloping.ourtaskr.util.validation.ValidationException.Type;
import net.javaloping.ourtaskr.business.dto.UserDTO;
import net.javaloping.ourtaskr.business.service.user.UserService;
import net.javaloping.ourtaskr.util.validation.ObjectValidator;
import net.javaloping.ourtaskr.util.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author  victormiranda
 */

@Component
public class UserValidator extends ObjectValidator<UserDTO> {

	@Autowired
	private UserService userService;

	public void validate(UserDTO user) throws ValidationException{
		super.validate(user);

		if (!user.getPassword().equals(user.getConfirmedPassword())) {
			throw new ValidationException("confirmPassword",
					Type.FIELDS_DONT_MATCH);
		}

		if (userService.getUserByEmail(user.getEmailAddress()) != null) {
			throw new ValidationException("emailAddress",
					Type.EMAIL,"Email is used");
		}

	}
}
