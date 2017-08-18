package br.com.smartschool.security;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import br.com.smartschool.model.enums.AuthorityEnum;
import br.com.smartschool.rest.RestAbstractResource;
import br.com.smartschool.security.annotations.Authorities;
import br.com.smartschool.security.annotations.Restricted;

@Restricted
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class SecurityInterceptor {

	@AroundInvoke
	public Object handle(InvocationContext joinPoint) throws Exception {
		HttpServletRequest request = getHttpServletRequest(joinPoint);
		
		Method method = joinPoint.getMethod();
		Authorities annotation = method.getAnnotation(Authorities.class);

		List<AuthorityEnum> authList = Arrays.asList(annotation.values());
		
		if (authList.contains(AuthorityEnum.RESPONSAVEL)) {
			return joinPoint.proceed();
		} else {
			return null;
		}
		
	}
	
	private HttpServletRequest getHttpServletRequest(InvocationContext joinPoint) {
		HttpServletRequest request = ((RestAbstractResource) joinPoint.getTarget()).getHttpRequest();
		
		return request;
	}
	
}
