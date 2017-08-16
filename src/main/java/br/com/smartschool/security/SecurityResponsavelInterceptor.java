package br.com.smartschool.security;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import br.com.smartschool.security.annotations.PrivadoResponsavel;

@PrivadoResponsavel
@Interceptor
public class SecurityResponsavelInterceptor {

	@AroundInvoke
	public Object handle(InvocationContext joinPoint) throws Exception {
		HttpServletRequest request = getHttpServletRequest(joinPoint);
		
		Method method = joinPoint.getMethod();
		
		Annotation[] annotations = method.getDeclaredAnnotations();
		
		return joinPoint.proceed();
	}
	
	private HttpServletRequest getHttpServletRequest(InvocationContext joinPoint) {
		for (Object parameter : joinPoint.getParameters()) {
			if (parameter instanceof HttpServletRequest) {
				return (HttpServletRequest) parameter;
			}
		}
		
		return null;
	}
	
}
