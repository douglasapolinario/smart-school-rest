package br.com.smartschool.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.DisciplinaDaoImpl;
import br.com.smartschool.model.Disciplina;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class DisciplinaDaoImplTest extends AbstractTest {

	@Inject
	private DisciplinaDaoImpl disciplinaDaoImpl;
	
	@Test
	public void save_disciplina() {
		Disciplina disciplina = Disciplina.builder()
				.descricao("1 disciplina")
				.build();

		disciplinaDaoImpl.createOrUpdate(disciplina);
		Assert.assertNotNull(disciplina.getId());
	}
	
	@Test
	public void update_disciplina() {
		Disciplina disciplina = Disciplina.builder()
				.descricao("1 disciplina")
				.build();

		disciplinaDaoImpl.createOrUpdate(disciplina);
		Assert.assertNotNull(disciplina.getId());
		
		disciplina.setDescricao("2 disciplina");
		Disciplina fromStore = disciplinaDaoImpl.createOrUpdate(disciplina);
		Assert.assertEquals(disciplina, fromStore);
	}
	
	@Test
	public void remove_disciplina() {
		Disciplina disciplina = Disciplina.builder()
				.descricao("1 disciplina")
				.build();

		disciplinaDaoImpl.createOrUpdate(disciplina);
		Assert.assertNotNull(disciplina.getId());
		
		disciplinaDaoImpl.delete(disciplina.getId());
		Disciplina fromStore = disciplinaDaoImpl.find(disciplina.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_disciplina_by_id() {
		Disciplina disciplina = Disciplina.builder()
				.descricao("1 disciplina")
				.build();

		disciplinaDaoImpl.createOrUpdate(disciplina);
		Assert.assertNotNull(disciplina.getId());
		
		Disciplina fromStore = disciplinaDaoImpl.find(disciplina.getId());
		Assert.assertEquals(disciplina, fromStore);
	}
	
	@Test
	public void list_disciplina() {
		Disciplina disciplina1 = Disciplina.builder()
				.descricao("1 disciplina")
				.build();

		disciplinaDaoImpl.createOrUpdate(disciplina1);
		Assert.assertNotNull(disciplina1.getId());
		
		Disciplina disciplina2 = Disciplina.builder()
				.descricao("1 disciplina")
				.build();

		disciplinaDaoImpl.createOrUpdate(disciplina2);
		Assert.assertNotNull(disciplina2.getId());
		
		Disciplina disciplina3 = Disciplina.builder()
				.descricao("1 disciplina")
				.build();

		disciplinaDaoImpl.createOrUpdate(disciplina3);
		Assert.assertNotNull(disciplina3.getId());
		
		List<Disciplina> disciplinas = Arrays.asList(disciplina1, disciplina2, disciplina3);
		List<Disciplina> fromStore = disciplinaDaoImpl.findAll();
		
		Assert.assertArrayEquals(disciplinas.toArray(), fromStore.toArray());
	}
	
}
