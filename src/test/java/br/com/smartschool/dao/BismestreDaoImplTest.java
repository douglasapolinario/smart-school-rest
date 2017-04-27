package br.com.smartschool.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.BimestreDaoImpl;
import br.com.smartschool.model.Bimestre;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class BismestreDaoImplTest extends AbstractTest {

	@Inject
	private BimestreDaoImpl bimestreDaoImpl;
	
	@Test
	public void save_bimestre() {
		Bimestre bimestre = Bimestre.builder()
				.descricao("1 bimestre")
				.build();

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
	}
	
	@Test
	public void update_bimestre() {
		Bimestre bimestre = Bimestre.builder()
				.descricao("1 bimestre")
				.build();

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
		
		bimestre.setDescricao("2 bimestre");
		Bimestre fromStore = bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertEquals(bimestre, fromStore);
	}
	
	@Test
	public void remove_bimestre() {
		Bimestre bimestre = Bimestre.builder()
				.descricao("1 bimestre")
				.build();

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
		
		bimestreDaoImpl.delete(bimestre.getId());
		Bimestre fromStore = bimestreDaoImpl.find(bimestre.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_bimestre_by_id() {
		Bimestre bimestre = Bimestre.builder()
				.descricao("1 bimestre")
				.build();

		bimestreDaoImpl.createOrUpdate(bimestre);
		Assert.assertNotNull(bimestre.getId());
		
		Bimestre fromStore = bimestreDaoImpl.find(bimestre.getId());
		Assert.assertEquals(bimestre, fromStore);
	}
	
	@Test
	public void list_bimestre() {
		Bimestre bimestre1 = Bimestre.builder()
				.descricao("1 bimestre")
				.build();
		bimestreDaoImpl.createOrUpdate(bimestre1);
		Assert.assertNotNull(bimestre1.getId());
		
		Bimestre bimestre2 = Bimestre.builder()
				.descricao("2 bimestre")
				.build();
		bimestreDaoImpl.createOrUpdate(bimestre2);
		Assert.assertNotNull(bimestre2.getId());
		
		Bimestre bimestre3 = Bimestre.builder()
				.descricao("3 bimestre")
				.build();
		bimestreDaoImpl.createOrUpdate(bimestre3);
		Assert.assertNotNull(bimestre3.getId());
		
		Bimestre bimestre4 = Bimestre.builder()
				.descricao("4 bimestre")
				.build();
		bimestreDaoImpl.createOrUpdate(bimestre4);
		Assert.assertNotNull(bimestre4.getId());
		
		List<Bimestre> bimestres = Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4);
		List<Bimestre> fromStore = bimestreDaoImpl.findAll();
		
		Assert.assertArrayEquals(bimestres.toArray(), fromStore.toArray());
	}
}
