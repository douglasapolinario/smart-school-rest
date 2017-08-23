package br.com.smartschool.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import br.com.smartschool.security.annotations.Public;

@Path("/login")
public class OAuthResource extends RestAbstractResource {
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Public
	public Response login() {
		try {
			OAuthTokenRequest oauthRequest = new OAuthTokenRequest(getHttpRequest());
			String clientId = oauthRequest.getClientId();
			String clientSecret = oauthRequest.getClientSecret();
			String username = oauthRequest.getUsername();
			String password = oauthRequest.getPassword();
			
		} catch (OAuthSystemException | OAuthProblemException e) {
			e.printStackTrace();
		}
		
		Response response = Response.ok().build();
		return response;
		
	}
	
}
