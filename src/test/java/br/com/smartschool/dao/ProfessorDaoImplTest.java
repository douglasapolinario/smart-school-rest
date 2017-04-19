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
		Professor professor = new Professor();
		professor.setCelular("(11)97163-4740");
		professor.setCpf("55243587898");
		professor.setEmail("douglas@gmail.com");
		professor.setNome("Douglas");
		professor.setRg("448887776");
		professor.setSenha("xptoprof1");
		professor.setTelefone("47894433");
		
		professorDaoImpl.createOrUpdate(professor);
		Assert.assertNotNull(professor.getId());
		
		Professor fromStore = (Professor) professorDaoImpl.findByCPF("55243587898");
		Assert.assertEquals(professor, fromStore);
	}


	@Test
	public void update_professor() {
		Professor professor = new Professor();
		professor.setCelular("(11)97163-4740");
		professor.setCpf("55243587898");
		professor.setEmail("douglas@gmail.com");
		professor.setNome("Douglas");
		professor.setRg("448887776");
		professor.setSenha("xptoprof1");
		professor.setTelefone("47894433");
		
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
		Professor professor = new Professor();
		professor.setCelular("(11)97163-4740");
		professor.setCpf("55243587898");
		professor.setEmail("douglas@gmail.com");
		professor.setNome("Douglas");
		professor.setRg("448887776");
		professor.setSenha("xptoprof1");
		professor.setTelefone("47894433");
		
		professorDaoImpl.createOrUpdate(professor);
		Assert.assertNotNull(professor.getId());

		professorDaoImpl.delete(professor.getId());
		
		Professor fromStore = (Professor) professorDaoImpl.findByCPF("55243587898");
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_professor_by_id() {
		Professor professor = new Professor();
		professor.setCelular("(11)97163-4740");
		professor.setCpf("55243587898");
		professor.setEmail("douglas@gmail.com");
		professor.setNome("Douglas");
		professor.setRg("448887776");
		professor.setSenha("xptoprof1");
		professor.setTelefone("47894433");
		
		professorDaoImpl.createOrUpdate(professor);
		Assert.assertNotNull(professor.getId());
		
		Professor fromStore = (Professor) professorDaoImpl.find(professor.getId());
		
		Assert.assertEquals(professor, fromStore);
	}
	
	@Test
	public void list_professor() {
		Professor professor1 = new Professor();
		professor1.setCelular("(11)97163-4740");
		professor1.setCpf("55243587898");
		professor1.setEmail("douglas@gmail.com");
		professor1.setNome("Douglas");
		professor1.setRg("448887776");
		professor1.setSenha("xptoprof1");
		professor1.setTelefone("47894433");
		professorDaoImpl.createOrUpdate(professor1);
		Assert.assertNotNull(professor1.getId());
		
		Professor professor2 = new Professor();
		professor2.setCelular("(11)97163-4740");
		professor2.setCpf("55243587898");
		professor2.setEmail("douglas@gmail.com");
		professor2.setNome("Douglas");
		professor2.setRg("448887776");
		professor2.setSenha("xptoprof1");
		professor2.setTelefone("47894433");
		professorDaoImpl.createOrUpdate(professor2);
		Assert.assertNotNull(professor2.getId());
		
		Professor professor3 = new Professor();
		professor3.setCelular("(11)97163-4740");
		professor3.setCpf("55243587898");
		professor3.setEmail("douglas@gmail.com");
		professor3.setNome("Douglas");
		professor3.setRg("448887776");
		professor3.setSenha("xptoprof1");
		professor3.setTelefone("47894433");
		professorDaoImpl.createOrUpdate(professor3);
		Assert.assertNotNull(professor3.getId());
		
		List<Professor> profs = Arrays.asList(professor1, professor2, professor3);
		List<Pessoa> fromStore = professorDaoImpl.findAll();
		
		Assert.assertArrayEquals(profs.toArray(), fromStore.toArray());
	}
	
}
