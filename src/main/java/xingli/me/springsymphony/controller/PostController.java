package xingli.me.springsymphony.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xingli13
 * @date 2018/11/8
 */
@RestController
public class PostController {
	@GetMapping("hello")
	public String hello() {
		return "hello";
	}
}
