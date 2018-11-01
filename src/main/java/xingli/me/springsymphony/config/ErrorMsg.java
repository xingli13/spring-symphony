package xingli.me.springsymphony.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@ConfigurationProperties(prefix = "error")
@Component
@PropertySource("classpath:config/message_CN.properties")
public class ErrorMsg {
	private static Map<String, String> sym = new HashMap<>();

	public static String getSymMsg(String ec) {
		return sym.get(ec);
	}

	public void setSym(Map<String, String> sym) {
		ErrorMsg.sym = sym;
	}

	public Map<String, String> getSym() {
		return sym;
	}
}
