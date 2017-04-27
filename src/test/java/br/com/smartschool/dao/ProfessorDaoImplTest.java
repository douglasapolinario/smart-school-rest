package br.com.smartschool.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.ProfessorDaoImpl;
import br.com.smartschool.model.Pessoa;
import br.com.smartschool.model.Professor;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class ProfessorDaoImplTest extends AbstractTest {

	@Inject
	private ProfessorDaoImpl professorDaoImpl;
	
	@Test
	public void save_professor() {
		Professor professor = Professor.builder()
				.celular("(11)97163-4740")
				.cpf("55243587898")
				.email("douglas@gmail.com")
				.nome("Douglas")
				.rg("448887776")
				.senha("xptoprof1")
				.telefone("47894433")
				.build();

		
		professorDaoImpl.createOrUpdate(professor);
		Assert.assertNotNull(professor.getId());
		
		Professor fromStore = (Professor) professorDaoImpl.findByCPF("55243587898");
		Assert.assertEquals(professor, fromStore);
	}


	@Test
	public void update_professor() {
		Professor professor = Professor.builder()
				.celular("(11)97163-4740")
				.cpf("55243587898")
				.email("douglas@gmail.com")
				.nome("Douglas")
				.rg("448887776")
				.senha("xptoprof1")
				.telefone("47894433")
				.build();
		
		professorDaoImpl.createOrUpdate(professor);
		Assert.assertNotNull(professor.getId());
		
		Professor fromStore = (Professor) professorDaoImpl.findByCPF("55243587898");
		fromStore.setCelular("(11)987654434");
		fromStore.setCpf("11199811208");
		fromStore.setEmail("professor.portugues@gmail.com");
		fromStore.setNome("Professor de Portugues");
		fromStore.setRg("411988975");
		professorDaoImpl.createOrUpdate(fromStore);
		
		Assert.assertEquals(fromStore, professor);
	}
	
	@Test
	public void remove_professor() {
		Professor professor = Professor.builder()
				.celular("(11)97163-4740")
				.cpf("55243587898")
				.email("douglas@gmail.com")
				.nome("Douglas")
				.rg("448887776")
				.senha("xptoprof1")
				.telefone("47894433")
				.build();
		
		professorDaoImpl.createOrUpdate(professor);
		Assert.assertNotNull(professor.getId());

		professorDaoImpl.delete(professor.getId());
		
		Professor fromStore = (Professor) professorDaoImpl.findByCPF("55243587898");
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_professor_by_id() {
		Professor professor = Professor.builder()
				.celular("(11)97163-4740")
				.cpf("55243587898")
				.email("douglas@gmail.com")
				.nome("Douglas")
				.rg("448887776")
				.senha("xptoprof1")
				.telefone("47894433")
				.build();
		
		professorDaoImpl.createOrUpdate(professor);
		Assert.assertNotNull(professor.getId());
		
		Professor fromStore = (Professor) professorDaoImpl.find(professor.getId());
		
		Assert.assertEquals(professor, fromStore);
	}
	
	@Test
	public void list_professor() {
		Professor professor1 = Professor.builder()
				.celular("(11)97163-4740")
				.cpf("55243587898")
				.email("douglas@gmail.com")
				.nome("Douglas")
				.rg("448887776")
				.senha("xptoprof1")
				.telefone("47894433")
				.build();
		professorDaoImpl.createOrUpdate(professor1);
		Assert.assertNotNull(professor1.getId());
		
		Professor professor2 = Professor.builder()
				.celular("(11)97163-4740")
				.cpf("55243587898")
				.email("douglas@gmail.com")
				.nome("Douglas")
				.rg("448887776")
				.senha("xptoprof1")
				.telefone("47894433")
				.build();
		professorDaoImpl.createOrUpdate(professor2);
		Assert.assertNotNull(professor2.getId());
		
		Professor professor3 = Professor.builder()
				.celular("(11)97163-4740")
				.cpf("55243587898")
				.email("douglas@gmail.com")
				.nome("Douglas")
				.rg("448887776")
				.senha("xptoprof1")
				.telefone("47894433")
				.build();
		professorDaoImpl.createOrUpdate(professor3);
		Assert.assertNotNull(professor3.getId());
		
		List<Professor> profs = Arrays.asList(professor1, professor2, professor3);
		List<Pessoa> fromStore = professorDaoImpl.findAll();
		
		Assert.assertArrayEquals(profs.toArray(), fromStore.toArray());
	}
	
}
