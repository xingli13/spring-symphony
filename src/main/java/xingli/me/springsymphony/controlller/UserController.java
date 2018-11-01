package xingli.me.springsymphony.controlller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xingli.me.springsymphony.config.JsonWrapper;
import xingli.me.springsymphony.config.SymException;
import xingli.me.springsymphony.domain.User;
import xingli.me.springsymphony.repository.UserDao;

import javax.annotation.Resource;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@RestController
@Slf4j
public class UserController {
	@Resource
	JsonWrapper jsonWrapper;
	@Resource
	UserDao userDao;

	@PostMapping("/join")
	public String newUserJoin(@RequestBody @Validated User user) {
		log.info(user.toString());
		if (userDao.findFirstByUsername(user.getUsername()) == null) {
			userDao.save(user);
			return jsonWrapper.success(user.getUsername());
		} else {
			throw new SymException("002");
		}
	}
}
