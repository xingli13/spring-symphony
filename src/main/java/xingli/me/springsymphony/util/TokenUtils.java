package xingli.me.springsymphony.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import xingli.me.springsymphony.config.AppConfig;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * 使用jwt生成token
 *
 * @author xingli13
 * @date 2018/11/8
 */
@Slf4j
public class TokenUtils {

	public static String generateToken(String username) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		Map<String, Object> claims = new HashMap<>();
		claims.put("username", username);
		claims.put("role", "user");
		SecretKey key = generateKey();
		JwtBuilder builder = Jwts.builder()
				.setClaims(claims)
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(now)
				.setSubject(username)
				.signWith(signatureAlgorithm, key);
		long expireMillis = nowMillis + Long.valueOf(AppConfig.getConfig("ttlMillis"));
		Date expire = new Date(expireMillis);
		builder.setExpiration(expire);
		return builder.compact();
	}

	public static SecretKey generateKey() {
		String stringKey = AppConfig.getConfig("secret");
		byte[] encodeKey = Base64.getDecoder().decode(stringKey);
		return new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
	}
}
