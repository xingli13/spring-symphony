package xingli.me.springsymphony.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class BaseExceptionHandler {
	@Resource
	ObjectMapper mapper;

	@ExceptionHandler(SymException.class)
	public String symExceptionHandler(SymException e) {
		log.error(e.getEc(), e);
		return getErrorResponseBody(e.getEc(), e.getMessage());
	}

//	@ExceptionHandler(RuntimeException.class)
//	public String runtimeExceptionHandler(RuntimeException e) {
//		log.error(e.getMessage(), e);
//		return getErrorResponseBody("000", e.getMessage());
//	}

	private String getErrorResponseBody(String ec, String em) {
		Msg msg = new Msg();
		msg.setM("");
		msg.setEc(ec);
		msg.setEm(em);
		msg.setS("0");
		try {
			return mapper.writeValueAsString(msg);
		} catch (JsonProcessingException e) {
			return "{\"s\":\"0\",\"ec\":\"\",\"em\":\"\",\"m\":\"\"}";
		}
	}

	@ExceptionHandler({Exception.class})
	public String exceptionHandler(Exception e) {
		if (e instanceof MethodArgumentNotValidException) {
			BindingResult result = ((MethodArgumentNotValidException) e).getBindingResult();
			if (result.hasErrors() && result.hasFieldErrors()) {
				StringBuilder sb = new StringBuilder();
				result.getFieldErrors().forEach(
						fieldError -> sb.append(fieldError.getDefaultMessage()).append(" "));
				return getErrorResponseBody("998", sb.toString());
			}
		}
		log.error(e.getMessage(), e);
		return getErrorResponseBody("999", e.getMessage());
	}
}
