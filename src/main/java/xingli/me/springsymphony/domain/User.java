package xingli.me.springsymphony.domain;

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
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	@Pattern(regexp = "[0-9a-zA-Z]{1,16}", message = "用户名不合法")
	private String username;

	@Size(max = 32, min = 8, message = "密码应该大于8位，小于24位")
	private String password;
}
