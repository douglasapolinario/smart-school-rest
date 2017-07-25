package br.com.smartschool.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		List<Pessoa> pessoas = new ArrayList<>();
		findAll.forEach(pessoas::add);
		
		return Response
				.ok(pessoas)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Pessoa findById(@PathParam("id") Long id) {
		Pessoa aluno = responsavelDao.find(id);
		
		return aluno;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Responsavel responsavel) {
		System.out.println(responsavel.getNome());
		responsavelDao.createOrUpdate(responsavel);
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Responsavel aluno) {
		
	}
	
	
	
}
