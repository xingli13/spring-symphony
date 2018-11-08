package xingli.me.springsymphony.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@Component
public class JsonUtils {
	@Resource
	ObjectMapper mapper;

	public String writeValueAsString(Object obj){
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("001");
		}
	}
}
