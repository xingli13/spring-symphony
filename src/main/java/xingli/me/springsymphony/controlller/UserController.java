package xingli.me.springsymphony.controlller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@RestController
public class UserController {
	@GetMapping
	public String hello(){
		return "hello";
	}
}
