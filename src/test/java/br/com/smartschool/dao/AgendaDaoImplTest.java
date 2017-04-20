package br.com.smartschool.dao;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.AgendaDaoImpl;
import br.com.smartschool.model.Agenda;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class AgendaDaoImplTest extends AbstractTest {
	
	@Inject
	private AgendaDaoImpl agendaDao = new AgendaDaoImpl();
	
	@Test
	public void save_agenda() {
		Agenda agenda = Agenda.builder()
				.descricao("Agenda do aluno xpto")
				.build();
		
		agendaDao.createOrUpdate(agenda);
		
		Assert.assertNotNull(agenda.getId());
	}

	@Test
	public void update_agenda() {
		Agenda agenda = Agenda.builder()
				.descricao("Agenda do aluno xpto")
				.build();
		agenda = agendaDao.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		Agenda fromStore = agendaDao.find(agenda.getId());
		fromStore.setDescricao("Agenda do aluno xpto alterado");
		agendaDao.createOrUpdate(fromStore);
		
		Assert.assertEquals(agenda, fromStore);
	}
	
	@Test
	public void remove_agenda() {
		Agenda agenda = Agenda.builder()
				.descricao("Agenda do aluno xpto")
				.build();
		agendaDao.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		agendaDao.delete(agenda.getId());
		
		Agenda fromStore = agendaDao.find(agenda.getId());
		
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_agenda_by_id() {
		Agenda agenda = Agenda.builder()
				.descricao("Agenda do aluno xpto")
				.build();
		agendaDao.createOrUpdate(agenda);
		Assert.assertNotNull(agenda.getId());
		
		Agenda fromStore = agendaDao.find(agenda.getId());
		
		Assert.assertEquals(agenda, fromStore);
	}
	
	@Test
	public void list_agenda() {
		Agenda agenda1 = Agenda.builder()
				.descricao("Agenda do aluno xpto1")
				.build();
		agendaDao.createOrUpdate(agenda1);
		
		Agenda agenda2 = Agenda.builder()
				.descricao("Agenda do aluno xpto2")
				.build();
		agendaDao.createOrUpdate(agenda2);
		
		Agenda agenda3 = Agenda.builder()
				.descricao("Agenda do aluno xpto3")
				.build();
		agendaDao.createOrUpdate(agenda3);
		
		List<Agenda> agendas = Arrays.asList(agenda1, agenda2, agenda3);
		List<Agenda> fromStore = (List<Agenda>) agendaDao.findAll();
		
		Assert.assertArrayEquals(agendas.toArray(), fromStore.toArray());
	}
	
}
