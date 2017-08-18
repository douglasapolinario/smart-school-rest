package br.com.smartschool.rest;

import static br.com.smartschool.business.BusinessResponse.BusinessResponseStatus.OK;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.smartschool.business.BusinessResponse;
import br.com.smartschool.business.ResponsavelBusiness;
import br.com.smartschool.model.Responsavel;
import br.com.smartschool.model.enums.AuthorityEnum;
import br.com.smartschool.security.annotations.Authorities;

@Path("/responsavel")
public class ResponsavelResource extends RestAbstractResource {
	
	@Inject
	private ResponsavelBusiness responsavelBusiness;
	
	public ResponsavelResource() {
		
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAll() {
		BusinessResponse<List<Responsavel>> response  = responsavelBusiness.findAll();
		
		if (!response.getStatus().equals(OK)) {
			return Response
					.status(Status.BAD_REQUEST)
					.entity(response.getMessages())
					.type(MediaType.APPLICATION_JSON_TYPE)
					.build();
		}

		List<Responsavel> responsaveis = response.getContent();
		return Response
				.ok(responsaveis)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	@Authorities(values={AuthorityEnum.RESPONSAVEL, AuthorityEnum.ALUNO})
	public Response findById(@PathParam("id") Long id) {
		BusinessResponse<Responsavel> response = responsavelBusiness.findById(id);
		
		if (!response.getStatus().equals(OK)) {
			return Response
					.status(Status.BAD_REQUEST)
					.entity(response.getMessages())
					.type(MediaType.APPLICATION_JSON_TYPE)
					.build();
		}
		
		Responsavel responsavel = response.getContent();
		
		return Response
				.ok(responsavel)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Authorities(values={AuthorityEnum.RESPONSAVEL, AuthorityEnum.ALUNO})
	public Response add(Responsavel responsavel, @Context UriInfo uriInfo) {
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		
		if (!response.getStatus().equals(OK)) {
			return Response
					.status(Status.BAD_REQUEST)
					.entity(response.getMessages())
					.type(MediaType.APPLICATION_JSON_TYPE)
					.build();
		}
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(responsavel.getId().toString());
		
		return Response
				.created(builder.build())
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response update(Responsavel responsavel) {
		BusinessResponse<Responsavel> response = responsavelBusiness.update(responsavel);
		
		if (!response.getStatus().equals(OK)) {
			return Response
					.status(Status.BAD_REQUEST)
					.entity(response.getMessages())
					.type(MediaType.APPLICATION_JSON_TYPE)
					.build();
		}
		
		return Response
				.ok(response.getContent())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") Long id) {
		BusinessResponse<Responsavel> response = responsavelBusiness.findById(id);
		
		if (!response.getStatus().equals(OK)) {
			return Response
					.status(Status.BAD_REQUEST)
					.entity(response.getMessages())
					.type(MediaType.APPLICATION_JSON_TYPE)
					.build();
		}
		
		Responsavel responsavel = response.getContent();
		responsavelBusiness.delete(responsavel);
		
		return Response
				.noContent()
				.build();
	}
	
}
