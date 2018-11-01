package xingli.me.springsymphony.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
	/**
	 * status : 0 failed
	 * 1 success
	 */
	String s;
	/**
	 * message
	 */
	String m;
	/**
	 * error msg
	 */
	String em;
	/**
	 * error code
	 */
	String ec;
}
