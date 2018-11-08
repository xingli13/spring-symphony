package xingli.me.springsymphony.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingli13
 * @date 2018/11/8
 */
@ConfigurationProperties(prefix = "config")
@Component
@PropertySource("classpath:config/message_CN.properties")
public class AppConfig {
	private static Map<String, String> sym = new HashMap<>();

	public void setSym(Map<String, String> sym) {
		AppConfig.sym = sym;
	}

	public Map<String, String> getSym() {
		return sym;
	}

	public static String getConfig(String key) {
		return sym.get(key);
	}
}
