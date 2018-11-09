package xingli.me.springsymphony.aop;

import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xingli.me.springsymphony.config.JsonWrapper;
import xingli.me.springsymphony.config.SymException;
import xingli.me.springsymphony.util.TokenUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xingli13
 * @date 2018/11/8
 */
@Aspect
@Component
public class LoginAspect {

	@Pointcut("within(xingli.me.springsymphony.controller.*) && !within(xingli.me.springsymphony.controller.UserController)")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object userLoginValidate(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String token = getToken(request);
		try {
			Claims claims = TokenUtils.parseToken(token);
		}catch (Exception e){
			throw new SymException("007");
		}
//		claims.get();
		return pjp.proceed();
	}

	private String getToken(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("access_token".equalsIgnoreCase(cookie.getName())) {
				return cookie.getValue();
			}
		}
		throw new SymException("006");
	}
}
