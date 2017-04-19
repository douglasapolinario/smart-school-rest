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

import br.com.smartschool.dao.AlunoDaoImpl;
import br.com.smartschool.dao.DisciplinaDaoImpl;
import br.com.smartschool.model.Pessoa;

@Path("/alunos")
public class AlunoResource {
	
	@Inject
	private AlunoDaoImpl alunoDao;
	
	@Inject
	private DisciplinaDaoImpl disciplinaDao;

	public AlunoResource() {
		
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAll() {
		Iterable<Pessoa> findAll = alunoDao.findAll();
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
		Pessoa aluno = alunoDao.find(id);
		
		return aluno;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Pessoa aluno) {
		System.out.println(aluno.getNome());
		alunoDao.createOrUpdate(aluno);
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Pessoa aluno) {
		
	}
	
	
	
}
