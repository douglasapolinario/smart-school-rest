package br.com.escola.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.escola.cdi.WeldJUnit4Runner;
import br.com.escola.model.Serie;
import br.com.escola.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class SerieDaoImplTest extends AbstractTest {

	@Inject
	private SerieDaoImpl serieDaoImpl;
	
	@Test
	public void save_nota() {
		Serie serie = new Serie();
		serie.setAno("1");
		serie.setTurma("A");

		serieDaoImpl.createOrUpdate(serie);
		Assert.assertNotNull(serie.getId());
	}
	
	@Test
	public void update_nota() {
		Serie serie = new Serie();
		serie.setAno("1");
		serie.setTurma("A");

		serieDaoImpl.createOrUpdate(serie);
		Assert.assertNotNull(serie.getId());
		
		serie.setAno("2");
		serie.setTurma("B");
		Serie fromStore = serieDaoImpl.createOrUpdate(serie);
		Assert.assertEquals(serie, fromStore);
	}
	
	@Test
	public void remove_nota() {
		Serie serie = new Serie();
		serie.setAno("1");
		serie.setTurma("A");

		serieDaoImpl.createOrUpdate(serie);
		Assert.assertNotNull(serie.getId());
		
		serieDaoImpl.delete(serie.getId());
		Serie fromStore = serieDaoImpl.find(serie.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_nota_by_id() {
		Serie serie = new Serie();
		serie.setAno("1");
		serie.setTurma("A");

		serieDaoImpl.createOrUpdate(serie);
		Assert.assertNotNull(serie.getId());
		
		Serie fromStore = serieDaoImpl.find(serie.getId());
		Assert.assertEquals(serie, fromStore);
	}
	
	@Test
	public void list_nota() {
		Serie serie1 = new Serie();
		serie1.setAno("1");
		serie1.setTurma("A");
		
		serieDaoImpl.createOrUpdate(serie1);
		Assert.assertNotNull(serie1.getId());
		
		Serie serie2 = new Serie();
		serie2.setAno("1");
		serie2.setTurma("A");
		
		serieDaoImpl.createOrUpdate(serie2);
		Assert.assertNotNull(serie2.getId());
		
		Serie serie3 = new Serie();
		serie3.setAno("1");
		serie3.setTurma("A");
		
		serieDaoImpl.createOrUpdate(serie3);
		Assert.assertNotNull(serie3.getId());
		
		List<Serie> faltas = Arrays.asList(serie1, serie2, serie3);
		List<Serie> fromStore = serieDaoImpl.findAll();
		
		Assert.assertArrayEquals(faltas.toArray(), fromStore.toArray());
	}
	
}
