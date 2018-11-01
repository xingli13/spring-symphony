package xingli.me.springsymphony.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Component;
import xingli.me.springsymphony.util.JsonUtil;

import javax.annotation.Resource;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@Component
public class JsonWrapper {
	@Resource
	JsonUtil json;

	public String success(Object obj) {
		Msg msg = new Msg("1", json.writeValueAsString(obj), "", "");
		return json.writeValueAsString(msg);
	}
}
