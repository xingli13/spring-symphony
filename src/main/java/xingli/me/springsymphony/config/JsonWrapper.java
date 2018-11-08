package xingli.me.springsymphony.config;

import org.springframework.stereotype.Component;
import xingli.me.springsymphony.util.JsonUtils;

import javax.annotation.Resource;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@Component
public class JsonWrapper {
	@Resource
	JsonUtils json;

	public String success(Object obj) {
		Msg msg = new Msg("1", json.writeValueAsString(obj), "", "");
		return json.writeValueAsString(msg);
	}
}
