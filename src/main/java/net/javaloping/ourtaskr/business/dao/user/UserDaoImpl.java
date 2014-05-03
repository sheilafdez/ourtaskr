package net.javaloping.ourtaskr.business.dao.user;

import net.javaloping.ourtaskr.business.dao.GenericDaoImpl;
import net.javaloping.ourtaskr.business.model.User;
import org.springframework.stereotype.Component;

/**
 * @author  victormiranda
 */
@Component
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}
}
