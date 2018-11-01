package xingli.me.springsymphony.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@Component
public class BeanDeclaration {
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
