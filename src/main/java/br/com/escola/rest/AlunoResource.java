package br.com.escola.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.escola.dao.AlunoDaoImpl;
import br.com.escola.dao.DisciplinaDaoImpl;
import br.com.escola.model.Agenda;
import br.com.escola.model.Aluno;
import br.com.escola.model.Disciplina;
import br.com.escola.model.Pessoa;
import br.com.escola.model.Recado;
import br.com.escola.model.Serie;

@Path("/alunos")
public class AlunoResource {
	
	@Inject
	private AlunoDaoImpl alunoDao;
	
	@Inject
	private DisciplinaDaoImpl disciplinaDao;
	
	private List<Pessoa> alunos;

	public AlunoResource() {
		Aluno aluno = new Aluno();
		aluno.setNome("Richard Oliveira Apolinario");
		aluno.setCpf("343.783.238-77");
		aluno.setRg("44.186.793-5");
		aluno.setCelular("971634740");
		aluno.setEmail("doliveira.apolinario@gmail.com");

		Agenda agenda1 = new Agenda();
		agenda1.setDescricao("Agenda Richard");
		
		Set<Recado> recados = new HashSet<Recado>();
		Recado rec1 = new Recado();
		rec1.setData(LocalDateTime.now());
		rec1.setAssunto("Mau comportamento");
		rec1.setTextoRecado("Hoje o Richard estava falando muito durante a aula.");
		
		Recado rec2 = new Recado();
		rec2.setData(LocalDateTime.now());
		rec2.setAssunto("Festa junina");
		rec2.setTextoRecado("No dia 25/06/2016 ocorrera nossa festa junina. Abaixo segue o crononograma de apresentacao:");
		recados.addAll(Arrays.asList(rec1, rec2));
		agenda1.setRecados(recados );
		aluno.setAgenda(agenda1);
		
		
		
		Serie serie = new Serie();
		serie.setAno("2ª");
		serie.setTurma("A");

		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Douglas Oliveira Apolinario");
		aluno2.setCpf("343.783.238-87");
		aluno2.setRg("44.186.793-6");
		aluno2.setCelular("47078194");
		aluno2.setEmail("dapolinario@gmail.com");
		
		Agenda agenda2 = new Agenda();
		agenda2.setDescricao("Agenda Richard");
		
		Set<Recado> recados2 = new HashSet<Recado>();
		Recado rec3 = new Recado();
		rec3.setData(LocalDateTime.now());
		rec3.setAssunto("Muita conversa");
		rec3.setTextoRecado("Hoje o Richard estava falando muito durante a aula.");
		
		Recado rec4 = new Recado();
		rec4.setData(LocalDateTime.now());
		rec4.setAssunto("Passeio aquario SP");
		rec4.setTextoRecado("No dia 14 de novembro faremos nosso passeio para o aquario de Sao Paulo. O valor eh de R$ 100,00, parcelado em duas vezes."
				+ "Por favor confirmar a autorizacao para que seu filho possa participar desse atividade.");
		
		recados2.addAll(Arrays.asList(rec3, rec4));
		agenda2.setRecados(recados2 );
		aluno2.setAgenda(agenda2);
		
		alunos = Arrays.asList(aluno, aluno2);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Pessoa> getAll() {
		Aluno aluno = new Aluno();
		aluno.setRg("44186793-5");
		aluno.setCpf("343.783.238-77");
		aluno.setNome("Douglas Oliveira Apolinario");
		aluno.setEmail("doliveira.apolinario@gmail.com");
		aluno.setSenha("123456");
		aluno.setCelular("971634740");
		aluno.setTelefone("47078194");
		
		Iterable<Disciplina> disciplinas = disciplinaDao.findAll();
		Disciplina disciplina = disciplinas.iterator().hasNext() ? disciplinas.iterator().next() : new Disciplina();
		disciplina.setDescricao("Matematica");

		Set<Disciplina> disciplinas2 = new HashSet<>();
		disciplinas2.add(disciplina);
		aluno.setDisciplinas(disciplinas2);
	
		alunoDao.createOrUpdate(aluno);
		
		Iterable<Pessoa> findAll = alunoDao.findAll();
		List<Pessoa> pessoas = new ArrayList<>();
		findAll.forEach(pessoas::add);
		return pessoas;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Pessoa findById(@PathParam("id") Long id) {
		Optional<Pessoa> retorno = alunos.stream().filter(a -> a.getId().equals(id)).findFirst();
		
		return retorno.orElse(new Pessoa());
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Pessoa aluno) {
		System.out.println(aluno.getNome());
		alunoDao.createOrUpdate(aluno);
	}
	
}
