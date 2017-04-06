package br.com.escola.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.escola.model.Pessoa;

@Path("/login")
public class LoginResource {
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response login(Pessoa responsavel) {
		Response response = Response.ok().build();
		return response;
		
	}
	
}
