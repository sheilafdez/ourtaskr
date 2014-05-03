package net.javaloping.ourtaskr.business.service.user;

import net.javaloping.ourtaskr.business.dao.user.UserDao;
import net.javaloping.ourtaskr.business.dto.UserDTO;
import net.javaloping.ourtaskr.business.model.User;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author victormiranda
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private Mapper dozerMapper;

	public UserDTO addUser(UserDTO u) {
		Date d = new Date();
		u.setCreateDate(d);

		User user = new User();

		dozerMapper.map(u,user);

		userDao.save(user);

		dozerMapper.map(user,u);

		return u;
	}

	@Override
	public UserDTO getUser(Long userId) {
		User user = userDao.get(userId);

		UserDTO userDTO = new UserDTO();

		dozerMapper.map(user, userDTO);

		return userDTO;
	}

}
