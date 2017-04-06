package br.com.escola.dao;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.escola.cdi.WeldJUnit4Runner;
import br.com.escola.model.Agenda;
import br.com.escola.model.Recado;
import br.com.escola.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class RecadoDaoImplTest extends AbstractTest {

	@Inject
	private RecadoDaoImpl recadoDaoImpl;
	
	@Inject
	private AgendaDaoImpl agendaDaoImpl;
	
	@Test
	public void save_recado() {
		Agenda agenda = new Agenda();
		agenda.setDescricao("Agenda do aluno xpto");
		agendaDaoImpl.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		Recado recado = populateRecado(agenda);
		recadoDaoImpl.createOrUpdate(recado);
		
		Assert.assertNotNull(recado.getId());
	}

	@Test
	public void update_recado() {
		Agenda agenda = new Agenda();
		agenda.setDescricao("Agenda do aluno xpto");
		agendaDaoImpl.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		Recado recado = populateRecado(agenda);
		recadoDaoImpl.createOrUpdate(recado);
		
		recado.setTextoRecado("Teste teste");
		Recado recadoUpdated = recadoDaoImpl.createOrUpdate(recado);
		Assert.assertEquals(recado, recadoUpdated);
	}

	private Recado populateRecado(Agenda agenda) {
		Recado recado = new Recado();
		recado.setData(LocalDateTime.now());
		recado.setAssunto("Tese");
		recado.setAgenda(agenda);
		recado.setTextoRecado("Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste "
				+ "Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste "
				+ "Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste "
				+ "Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste "
				+ "Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste "
				+ "Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste "
				+ "Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste "
				+ "Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste Teste ");
		return recado;
	}
	
	@Test
	public void remove_agenda() {
		Agenda agenda = new Agenda();
		agenda.setDescricao("Agenda do aluno xpto");
		agendaDaoImpl.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		Recado recado = populateRecado(agenda);
		recadoDaoImpl.createOrUpdate(recado);
		Assert.assertNotNull(recado.getId());
		
		recadoDaoImpl.delete(recado.getId());
		
		Recado fromStore = recadoDaoImpl.find(recado.getId());
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_agenda_by_id() {
		Agenda agenda = new Agenda();
		agenda.setDescricao("Agenda do aluno xpto");
		agendaDaoImpl.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		Recado recado = populateRecado(agenda);
		recadoDaoImpl.createOrUpdate(recado);
		Assert.assertNotNull(recado.getId());
		
		Recado fromStore = recadoDaoImpl.find(recado.getId());
		
		Assert.assertEquals(recado, fromStore);
	}
	
	@Test
	public void list_agenda() {
		Agenda agenda = new Agenda();
		agenda.setDescricao("Agenda do aluno xpto");
		agendaDaoImpl.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		Recado recado1 = populateRecado(agenda);
		recadoDaoImpl.createOrUpdate(recado1);
		Assert.assertNotNull(recado1.getId());
		
		Recado recado2 = populateRecado(agenda);
		recadoDaoImpl.createOrUpdate(recado2);
		Assert.assertNotNull(recado2.getId());
		
		Recado recado3 = populateRecado(agenda);
		recadoDaoImpl.createOrUpdate(recado3);
		Assert.assertNotNull(recado3.getId());
		
		List<Recado> recados = Arrays.asList(recado1, recado2, recado3);
		List<Recado> recadosOnDB = recadoDaoImpl.findAll();
		
		Assert.assertArrayEquals(recados.toArray(), recadosOnDB.toArray());
	}
	
}
