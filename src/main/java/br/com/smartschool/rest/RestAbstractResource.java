package br.com.smartschool.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import br.com.smartschool.security.annotations.Restricted;

@Restricted
public class RestAbstractResource {
	
	@Context
	private HttpServletRequest httpRequest;

	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

}
