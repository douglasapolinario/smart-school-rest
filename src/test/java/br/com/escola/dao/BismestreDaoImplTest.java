package br.com.escola.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.escola.cdi.WeldJUnit4Runner;
import br.com.escola.model.Bimestre;
import br.com.escola.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class BismestreDaoImplTest extends AbstractTest {

	@Inject
	private BimestreDaoImpl bimestreDaoImpl;
	
	@Test
	public void save_bimestre() {
		Bimestre bimestre = new Bimestre();
		bimestre.setDescricao("1 bimestre");

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
	}
	
	@Test
	public void update_bimestre() {
		Bimestre bimestre = new Bimestre();
		bimestre.setDescricao("1 bimestre");

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
		
		bimestre.setDescricao("2 bimestre");
		Bimestre fromStore = bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertEquals(bimestre, fromStore);
	}
	
	@Test
	public void remove_bimestre() {
		Bimestre bimestre = new Bimestre();
		bimestre.setDescricao("1 bimestre");

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
		
		bimestreDaoImpl.delete(bimestre.getId());
		Bimestre fromStore = bimestreDaoImpl.find(bimestre.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_bimestre_by_id() {
		Bimestre bimestre = new Bimestre();
		bimestre.setDescricao("1 bimestre");

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
		
		Bimestre fromStore = bimestreDaoImpl.find(bimestre.getId());
		Assert.assertEquals(bimestre, fromStore);
	}
	
	@Test
	public void list_bimestre() {
		Bimestre bimestre1 = new Bimestre();
		bimestre1.setDescricao("1 bimestre");

		bimestreDaoImpl.createOrUpdate(bimestre1);
		Assert.assertNotNull(bimestre1.getId());
		
		Bimestre bimestre2 = new Bimestre();
		bimestre2.setDescricao("1 bimestre");

		bimestreDaoImpl.createOrUpdate(bimestre2);
		Assert.assertNotNull(bimestre2.getId());
		
		Bimestre bimestre3 = new Bimestre();
		bimestre3.setDescricao("1 bimestre");

		bimestreDaoImpl.createOrUpdate(bimestre3);
		Assert.assertNotNull(bimestre3.getId());
		
		List<Bimestre> bimestres = Arrays.asList(bimestre1, bimestre2, bimestre3);
		List<Bimestre> fromStore = bimestreDaoImpl.findAll();
		
		Assert.assertArrayEquals(bimestres.toArray(), fromStore.toArray());
	}
}
