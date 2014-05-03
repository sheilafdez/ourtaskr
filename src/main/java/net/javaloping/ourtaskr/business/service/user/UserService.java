package net.javaloping.ourtaskr.business.service.user;

import net.javaloping.ourtaskr.business.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author victormiranda
 */

@Service
@Transactional
public interface UserService {

	UserDTO addUser(UserDTO u);

	UserDTO getUser(Long userId);
}
