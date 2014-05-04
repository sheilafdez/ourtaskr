package net.javaloping.ourtaskr.web.controller.user;

import net.javaloping.ourtaskr.business.dto.UserDTO;
import net.javaloping.ourtaskr.business.service.user.UserService;
import net.javaloping.ourtaskr.util.validation.ValidationException;
import net.javaloping.ourtaskr.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author victormiranda
 */
@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value="/user/add", method = RequestMethod.GET)
	@ResponseBody
	public UserDTO addUser(
			@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword,
			@RequestParam("emailAddress") String emailAddress)
		throws ValidationException {

		UserDTO u = new UserDTO();

		u.setName(name);
		u.setSurname(surname);
		u.setPassword(password);
		u.setConfirmedPassword(confirmPassword);
		u.setEmailAddress(emailAddress);

		try{
			userValidator.validate(u);
		}
		catch(ValidationException ve) {
			throw ve;
		}

		u = userService.addUser(u);

		return u;
	}

}
