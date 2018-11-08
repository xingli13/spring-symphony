package xingli.me.springsymphony.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@Data
@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;

	@ApiModelProperty(value = "用户名", required = true, example = "xingli13")
	@Pattern(regexp = "[0-9a-zA-Z]{1,16}", message = "用户名为小于16位的字母数字组合")
	private String username;

	@ApiModelProperty(value = "密码", required = true, example = "12345678")
	private String password;

	@ApiModelProperty(value = "邮箱", required = true, example = "adb@iflytek.com")
	@Pattern(regexp = "^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", message = "邮箱格式不合法")
	private String email;

	/**
	 * 是否激活
	 * 0:未
	 * 1:已
	 */
	@ApiModelProperty(hidden = true)
	private int status;
}
