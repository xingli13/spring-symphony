package xingli.me.springsymphony.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xingli.me.springsymphony.config.JsonWrapper;
import xingli.me.springsymphony.domain.User;
import xingli.me.springsymphony.service.UserService;

import javax.annotation.Resource;
import java.util.Map;

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
	UserService userService;

	@PostMapping("/join")
	@ApiOperation(value = "新用户注册", notes = "根据user来创建新用户")
	@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
	public String newUserJoin(@RequestBody @Validated User user) {
		log.info(user.toString());
		userService.userJoin(user);
		return jsonWrapper.success(user.getUsername());
	}

	@ApiOperation(value = "用户激活自己的账户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "verifyId", value = "激活的id", required = true, dataType = "String")
	})
	@GetMapping("/confirm_verification/{verifyId}")
	public String verifyEmail(@PathVariable String verifyId) {
		userService.verifyEmail(verifyId);
		return jsonWrapper.success("成功激活");
	}

	@PostMapping("/login")
	@ApiOperation(value = "用户登录", notes = "根据邮箱或用户名+密码的形式登录")
	public String login(@RequestBody Map<String, String> param) {
		String token = userService.login(param.get("username"), param.get("password"));
		return jsonWrapper.success("{\"token\" : \"" + token + "\"}");
	}
}
