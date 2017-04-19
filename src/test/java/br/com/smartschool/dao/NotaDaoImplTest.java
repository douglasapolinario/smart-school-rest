package br.com.smartschool.dao;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.NotaDaoImpl;
import br.com.smartschool.model.Nota;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class NotaDaoImplTest extends AbstractTest {

	@Inject
	private NotaDaoImpl notaDaoImpl;
	
	@Test
	public void save_nota() {
		Nota nota = new Nota();
		nota.setValor(new BigInteger("2"));

		notaDaoImpl.createOrUpdate(nota);
		Assert.assertNotNull(nota.getId());
	}
	
	@Test
	public void update_nota() {
		Nota nota = new Nota();
		nota.setValor(new BigInteger("2"));

		notaDaoImpl.createOrUpdate(nota);
		Assert.assertNotNull(nota.getId());
		
		nota.setValor(new BigInteger("3"));
		Nota fromStore = notaDaoImpl.createOrUpdate(nota);
		Assert.assertEquals(nota, fromStore);
	}
	
	@Test
	public void remove_nota() {
		Nota nota = new Nota();
		nota.setValor(new BigInteger("2"));

		notaDaoImpl.createOrUpdate(nota);
		Assert.assertNotNull(nota.getId());
		
		notaDaoImpl.delete(nota.getId());
		Nota fromStore = notaDaoImpl.find(nota.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_nota_by_id() {
		Nota nota = new Nota();
		nota.setValor(new BigInteger("2"));

		notaDaoImpl.createOrUpdate(nota);
		Assert.assertNotNull(nota.getId());
		
		Nota fromStore = notaDaoImpl.find(nota.getId());
		Assert.assertEquals(nota, fromStore);
	}
	
	@Test
	public void list_nota() {
		Nota nota1 = new Nota();
		nota1.setValor(new BigInteger("2"));

		notaDaoImpl.createOrUpdate(nota1);
		Assert.assertNotNull(nota1.getId());
		
		Nota nota2 = new Nota();
		nota2.setValor(new BigInteger("2"));

		notaDaoImpl.createOrUpdate(nota2);
		Assert.assertNotNull(nota2.getId());
		
		Nota nota3 = new Nota();
		nota3.setValor(new BigInteger("2"));

		notaDaoImpl.createOrUpdate(nota3);
		Assert.assertNotNull(nota3.getId());
		
		List<Nota> faltas = Arrays.asList(nota1, nota2, nota3);
		List<Nota> fromStore = notaDaoImpl.findAll();
		
		Assert.assertArrayEquals(faltas.toArray(), fromStore.toArray());
	}
	
}
