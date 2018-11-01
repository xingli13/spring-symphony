package xingli.me.springsymphony.controlller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xingli.me.springsymphony.domain.User;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@RestController
public class UserController {
	@PostMapping("/join")
	public String newUserJoin(User user){
		return "{\"s\":\"1\", \"m\":\"account created successfully\"}";
	}
}
