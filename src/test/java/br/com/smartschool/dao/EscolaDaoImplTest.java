package br.com.smartschool.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.EscolaDaoImpl;
import br.com.smartschool.model.Escola;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class EscolaDaoImplTest extends AbstractTest {

	@Inject
	private EscolaDaoImpl escolaDaoImpl;
	
	@Test
	public void save_escola() {
		Escola escola = Escola.builder()
				.cnpj("35992922000107")
				.razaoSocial("Rui Barbosa SA")
				.build();

		escolaDaoImpl.createOrUpdate(escola);
		Assert.assertNotNull(escola.getId());
	}
	
	@Test
	public void update_escola() {
		Escola escola = Escola.builder()
				.cnpj("35992922000107")
				.razaoSocial("Rui Barbosa SA")
				.build();

		escolaDaoImpl.createOrUpdate(escola);
		Assert.assertNotNull(escola.getId());
		
		escola.setRazaoSocial("Rui Barbosa LTDA");
		Escola fromStore = escolaDaoImpl.createOrUpdate(escola);
		Assert.assertEquals(escola, fromStore);
	}
	
	@Test
	public void remove_escola() {
		Escola escola = Escola.builder()
				.cnpj("35992922000107")
				.razaoSocial("Rui Barbosa SA")
				.build();

		escolaDaoImpl.createOrUpdate(escola);
		Assert.assertNotNull(escola.getId());
		
		escolaDaoImpl.delete(escola.getId());
		Escola fromStore = escolaDaoImpl.find(escola.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_escola_by_id() {
		Escola escola = Escola.builder()
				.cnpj("35992922000107")
				.razaoSocial("Rui Barbosa SA")
				.build();

		escolaDaoImpl.createOrUpdate(escola);
		Assert.assertNotNull(escola.getId());
		
		Escola fromStore = escolaDaoImpl.find(escola.getId());
		Assert.assertEquals(escola, fromStore);
	}
	
	@Test
	public void list_escola() {
		Escola escola1 = Escola.builder()
				.cnpj("35992922000107")
				.razaoSocial("Rui Barbosa SA")
				.build();

		escolaDaoImpl.createOrUpdate(escola1);
		Assert.assertNotNull(escola1.getId());
		
		Escola escola2 = Escola.builder()
				.cnpj("35992922000107")
				.razaoSocial("Rui Barbosa SA")
				.build();

		escolaDaoImpl.createOrUpdate(escola2);
		Assert.assertNotNull(escola2.getId());
		
		Escola escola3 = Escola.builder()
				.cnpj("35992922000107")
				.razaoSocial("Rui Barbosa SA")
				.build();

		escolaDaoImpl.createOrUpdate(escola3);
		Assert.assertNotNull(escola3.getId());
		
		List<Escola> escolas = Arrays.asList(escola1, escola2, escola3);
		List<Escola> fromStore = escolaDaoImpl.findAll();
		
		Assert.assertArrayEquals(escolas.toArray(), fromStore.toArray());
	}
	
}
