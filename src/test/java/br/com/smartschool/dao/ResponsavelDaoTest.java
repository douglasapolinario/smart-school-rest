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
		Responsavel responsavel = new Responsavel();
		responsavel.setCelular("(11)971634740");
		responsavel.setCpf("232.455.342-19");
		responsavel.setEmail("pai@gmail.com");
		responsavel.setNome("Pai do Aluno Hum");
		responsavel.setRg("327761129");
		
		responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertNotNull(responsavel.getId());
	}

	@Test
	public void update_responsavel() {
		Responsavel responsavel = new Responsavel();
		responsavel.setCelular("(11)971634740");
		responsavel.setCpf("232.455.342-18");
		responsavel.setEmail("pai@gmail.com");
		responsavel.setNome("Pai do Aluno Hum");
		responsavel.setRg("327761129");
		
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
		Responsavel responsavel = new Responsavel();
		responsavel.setCelular("(11)971634740");
		responsavel.setCpf("232.455.342-16");
		responsavel.setEmail("pai@gmail.com");
		responsavel.setNome("Pai do Aluno Hum");
		responsavel.setRg("327761129");
		
		responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertNotNull(responsavel.getId());
		
		responsavelDaoImpl.delete(responsavel.getId());
		Responsavel fromStore = (Responsavel) responsavelDaoImpl.find(responsavel.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_responsavel_by_id() {
		Responsavel responsavel = new Responsavel();
		responsavel.setCelular("(11)971634740");
		responsavel.setCpf("232.455.342-15");
		responsavel.setEmail("pai@gmail.com");
		responsavel.setNome("Pai do Aluno Hum");
		responsavel.setRg("327761129");
		
		responsavelDaoImpl.createOrUpdate(responsavel);
		Assert.assertNotNull(responsavel.getId());
		
		Responsavel fromStore = (Responsavel) responsavelDaoImpl.find(responsavel.getId());
		Assert.assertEquals(responsavel, fromStore);
	}
	
	@Test
	public void list_responsavel() {
		Responsavel responsavel1 = new Responsavel();
		responsavel1.setCelular("(11)971634740");
		responsavel1.setCpf("232.455.342-11");
		responsavel1.setEmail("pai@gmail.com");
		responsavel1.setNome("Pai do Aluno Hum");
		responsavel1.setRg("327761129");
		
		responsavelDaoImpl.createOrUpdate(responsavel1);
		Assert.assertNotNull(responsavel1.getId());
		
		Responsavel responsavel2 = new Responsavel();
		responsavel2.setCelular("(11)971634740");
		responsavel2.setCpf("232.455.342-10");
		responsavel2.setEmail("pai@gmail.com");
		responsavel2.setNome("Pai do Aluno Hum");
		responsavel2.setRg("327761129");
		
		responsavelDaoImpl.createOrUpdate(responsavel2);
		Assert.assertNotNull(responsavel2.getId());
		
		Responsavel responsavel3 = new Responsavel();
		responsavel3.setCelular("(11)971634740");
		responsavel3.setCpf("232.455.342-12");
		responsavel3.setEmail("pai@gmail.com");
		responsavel3.setNome("Pai do Aluno Hum");
		responsavel3.setRg("327761129");
		
		responsavelDaoImpl.createOrUpdate(responsavel3);
		Assert.assertNotNull(responsavel3.getId());
		
		List<Responsavel> responsaveis = Arrays.asList(responsavel1, responsavel2, responsavel3);
		List<Pessoa> fromStore = responsavelDaoImpl.findAll();
		
		Assert.assertArrayEquals(responsaveis.toArray(), fromStore.toArray());
	}
	
}
