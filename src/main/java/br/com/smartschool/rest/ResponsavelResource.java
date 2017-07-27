package br.com.smartschool.rest;

import java.util.ArrayList;
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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.smartschool.dao.ResponsavelDaoImpl;
import br.com.smartschool.model.Pessoa;
import br.com.smartschool.model.Responsavel;

@Path("/responsavel")
public class ResponsavelResource {
	
	@Inject
	private ResponsavelDaoImpl responsavelDao;
	
	public ResponsavelResource() {
		
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAll() {
		Iterable<Responsavel> findAll = responsavelDao.findAll();
		List<Pessoa> responsaveis = new ArrayList<>();
		findAll.forEach(responsaveis::add);
		
		return Response
				.ok(responsaveis)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findById(@PathParam("id") Long id) {
		Responsavel responsavel = responsavelDao.find(id);
		
		return Response
				.ok(responsavel)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response add(Responsavel responsavel, @Context UriInfo uriInfo) {
		responsavelDao.createOrUpdate(responsavel);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(responsavel.getId().toString());
		
		return Response
				.created(builder.build())
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(Responsavel aluno) {
		return null;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") Long id) {
		responsavelDao.delete(id);
		
		return Response
				.noContent()
				.build();
	}
	
}
