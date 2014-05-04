package net.javaloping.ourtaskr.business.dao.user;

import net.javaloping.ourtaskr.business.dao.GenericDaoImpl;
import net.javaloping.ourtaskr.business.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author  victormiranda
 */
@Component
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User getUserByEmail(String emailAddress) {

		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("emailAddress", emailAddress));

		List<User> users = criteria.list();

		if (users.isEmpty()) {
			return null;
		}

		return users.get(0);
	}
}
