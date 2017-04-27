package br.com.smartschool.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.ResponsavelDaoImpl;
import br.com.smartschool.model.Pessoa;
import br.com.smartschool.model.Responsavel;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class ResponsavelDaoTest extends AbstractTest {

	@Inject
	private ResponsavelDaoImpl responsavelDaoImpl;
	
	@Test
	public void save_responsavel() {
		Responsavel responsavel = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("232.455.342-19")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum")
				.rg("327761129")
				.build();
		
		responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertNotNull(responsavel.getId());
	}

	@Test
	public void update_responsavel() {
		Responsavel responsavel = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("232.455.342-18")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum")
				.rg("327761129")
				.build();
		
		responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertNotNull(responsavel.getId());
		
		responsavel.setCpf("232.455.342-17");
		responsavel.setEmail("pairesp@gmail.com");
		responsavel.setNome("Pai Resp do Aluno Hum");
		
		Responsavel responsavelUpdated = (Responsavel) responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertEquals(responsavel, responsavelUpdated);
	}
	
	@Test
	public void remove_responsavel() {
		Responsavel responsavel = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("232.455.342-16")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum")
				.rg("327761129")
				.build();
		
		responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertNotNull(responsavel.getId());
		
		responsavelDaoImpl.delete(responsavel.getId());
		Responsavel fromStore = (Responsavel) responsavelDaoImpl.find(responsavel.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_responsavel_by_id() {
		Responsavel responsavel = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("232.455.342-15")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum")
				.rg("327761129")
				.build();
		
		responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertNotNull(responsavel.getId());
		
		Responsavel fromStore = (Responsavel) responsavelDaoImpl.find(responsavel.getId());
		Assert.assertEquals(responsavel, fromStore);
	}
	
	@Test
	public void list_responsavel() {
		Responsavel responsavel1 = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("232.455.342-11")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum")
				.rg("327761129")
				.build();
		
		responsavelDaoImpl.createOrUpdate(responsavel1);
		Assert.assertNotNull(responsavel1.getId());
		
		Responsavel responsavel2 = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("232.455.342-10")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum")
				.rg("327761129")
				.build();
		
		responsavelDaoImpl.createOrUpdate(responsavel2);
		Assert.assertNotNull(responsavel2.getId());
		
		Responsavel responsavel3 = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("232.455.342-12")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum")
				.rg("327761129")
				.build();
		
		responsavelDaoImpl.createOrUpdate(responsavel3);
		Assert.assertNotNull(responsavel3.getId());
		
		List<Responsavel> responsaveis = Arrays.asList(responsavel1, responsavel2, responsavel3);
		List<Pessoa> fromStore = responsavelDaoImpl.findAll();
		
		Assert.assertArrayEquals(responsaveis.toArray(), fromStore.toArray());
	}
	
}
