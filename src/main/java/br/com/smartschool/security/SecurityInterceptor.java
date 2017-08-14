package br.com.smartschool.security;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.smartschool.security.annotations.Publico;

@Publico
@Interceptor
public class SecurityInterceptor {

	@AroundInvoke
	public Object handle(InvocationContext joinPoint) throws Exception {
		Method method = joinPoint.getMethod();
		
		Annotation[] annotations = method.getDeclaredAnnotations();
		
		return joinPoint.proceed();
	}
	
}
