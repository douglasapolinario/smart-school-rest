package br.com.smartschool.dao;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.FaltaDaoImpl;
import br.com.smartschool.model.Falta;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class FaltaDaoImplTest extends AbstractTest {

	@Inject
	private FaltaDaoImpl faltaDaoImpl;
	
	@Test
	public void save_falta() {
		Falta falta = new Falta();
		falta.setTotal(new BigInteger("2"));

		faltaDaoImpl.createOrUpdate(falta);
		Assert.assertNotNull(falta.getId());
	}
	
	@Test
	public void update_falta() {
		Falta falta = new Falta();
		falta.setTotal(new BigInteger("2"));

		faltaDaoImpl.createOrUpdate(falta);
		Assert.assertNotNull(falta.getId());
		
		falta.setTotal(new BigInteger("3"));
		Falta fromStore = faltaDaoImpl.createOrUpdate(falta);
		Assert.assertEquals(falta, fromStore);
	}
	
	@Test
	public void remove_falta() {
		Falta falta = new Falta();
		falta.setTotal(new BigInteger("2"));

		faltaDaoImpl.createOrUpdate(falta);
		Assert.assertNotNull(falta.getId());
		
		faltaDaoImpl.delete(falta.getId());
		Falta fromStore = faltaDaoImpl.find(falta.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_falta_by_id() {
		Falta falta = new Falta();
		falta.setTotal(new BigInteger("2"));

		faltaDaoImpl.createOrUpdate(falta);
		Assert.assertNotNull(falta.getId());
		
		Falta fromStore = faltaDaoImpl.find(falta.getId());
		Assert.assertEquals(falta, fromStore);
	}
	
	@Test
	public void list_falta() {
		Falta falta1 = new Falta();
		falta1.setTotal(new BigInteger("2"));

		faltaDaoImpl.createOrUpdate(falta1);
		Assert.assertNotNull(falta1.getId());
		
		Falta falta2 = new Falta();
		falta2.setTotal(new BigInteger("2"));

		faltaDaoImpl.createOrUpdate(falta2);
		Assert.assertNotNull(falta2.getId());
		
		Falta falta3 = new Falta();
		falta3.setTotal(new BigInteger("2"));

		faltaDaoImpl.createOrUpdate(falta3);
		Assert.assertNotNull(falta3.getId());
		
		List<Falta> faltas = Arrays.asList(falta1, falta2, falta3);
		List<Falta> fromStore = faltaDaoImpl.findAll();
		
		Assert.assertArrayEquals(faltas.toArray(), fromStore.toArray());
	}
	
}
