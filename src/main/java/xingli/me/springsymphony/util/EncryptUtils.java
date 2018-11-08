package xingli.me.springsymphony.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author xingli13
 * @date 2018/11/8
 */
public class EncryptUtils {
	public static String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static boolean isPasswordCorrect(String password, String stored) {
		return BCrypt.checkpw(password,stored);
	}
}
