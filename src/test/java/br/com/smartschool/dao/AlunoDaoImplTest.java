package br.com.smartschool.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.dao.AgendaDaoImpl;
import br.com.smartschool.dao.AlunoDaoImpl;
import br.com.smartschool.dao.DisciplinaDaoImpl;
import br.com.smartschool.dao.ResponsavelDaoImpl;
import br.com.smartschool.dao.SerieDaoImpl;
import br.com.smartschool.model.Agenda;
import br.com.smartschool.model.Aluno;
import br.com.smartschool.model.Disciplina;
import br.com.smartschool.model.Pessoa;
import br.com.smartschool.model.Responsavel;
import br.com.smartschool.model.Serie;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class AlunoDaoImplTest extends AbstractTest {

	@Inject
	private AlunoDaoImpl alunoDao;
	
	@Inject
	private ResponsavelDaoImpl responsavelDaoImpl;
	
	@Inject
	private SerieDaoImpl serieDao;
	
	@Inject
	private AgendaDaoImpl agendaDaoImpl;
	
	@Inject
	private DisciplinaDaoImpl disciplinaDaoImpl;
	
	private Aluno aluno;
	
	public AlunoDaoImplTest() {
		Serie serie = Serie.builder()
				.ano("2º")
				.turma("A")
				.build();
		
		Agenda agenda = Agenda.builder()
				.descricao("Agenda do aluno xpto")
				.ano(2017L)
				.build();

		aluno = Aluno.builder()
				.celular("(11)971634740")
				.cpf("34378323877")
				.email("aluno1@gmail.com")
				.nome("Aluno Hum dos Santos")
				.rg("441867935")
				.agenda(agenda)
				.build();
		
		Set<Serie> series = new HashSet<>();
		series.add(serie);
		aluno.setSeries(series);
		
		Responsavel pai = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("37636224895")
				.email("pai@gmail.com")
				.nome("Pai do Aluno Hum Hum dos Santos")
				.rg("327761129")
				.build();

		Responsavel mae = Responsavel.builder()
				.celular("(11)971634740")
				.cpf("23456789097")
				.email("mae@gmail.com")
				.nome("Mae do Aluno Hum")
				.rg("327761126")
				.build();
		
		Set<Responsavel> responsaveis = new HashSet<>(Arrays.asList(pai, mae));
		aluno.setResponsaveis(responsaveis);
		
		Set<Disciplina> disciplinas = new HashSet<>();
		Disciplina disciplina = Disciplina.builder()
				.descricao("Geografia")
				.series(series)
				.build();
		disciplinas.add(disciplina);
		aluno.setDisciplinas(disciplinas);
	}
	
	@Test
	public void save_aluno() {
		alunoDao.createOrUpdate(aluno);
		Assert.assertNotNull(aluno.getId());
		
		Agenda agendaFromStore = agendaDaoImpl.findByDescribe("Agenda do aluno xpto");
		Assert.assertNotNull(agendaFromStore);
		Assert.assertEquals(agendaFromStore, aluno.getAgenda());
		
		Set<Serie> seriesFromStore = new HashSet<>();
		Serie serie = serieDao.findByAnoTurma("2º", "A");
		seriesFromStore.add(serie);
		Assert.assertArrayEquals(seriesFromStore.toArray(), aluno.getSeries().toArray());
		
		Pessoa pai = responsavelDaoImpl.findByCPF("37636224895");
		Pessoa mae = responsavelDaoImpl.findByCPF("23456789097");
		Set<Pessoa> responsaveisFromStore = new HashSet<>(Arrays.asList(pai, mae));
		Assert.assertArrayEquals(responsaveisFromStore.toArray(), aluno.getResponsaveis().toArray());
		
		Set<Disciplina> disciplinasFromStore = new HashSet<>();
		Disciplina disciplina = disciplinaDaoImpl.findByDescribe("Geografia");
		disciplinasFromStore.add(disciplina);
		Assert.assertArrayEquals(disciplinasFromStore.toArray(), aluno.getDisciplinas().toArray());
	}

	@Test
	public void update_aluno() {
		alunoDao.createOrUpdate(aluno);
		Assert.assertNotNull(aluno.getId());
		
		Pessoa fromStore = alunoDao.findByCPF("34378323877");
		
		aluno.setNome("Fulano de Tal");
		alunoDao.createOrUpdate(aluno);
		
		Assert.assertEquals(fromStore, aluno);
	}
	
	@Test
	public void remove_aluno() {
		alunoDao.createOrUpdate(aluno);
		Assert.assertNotNull(aluno.getId());
		
		alunoDao.delete(aluno.getId());
		Pessoa fromStore = alunoDao.findByCPF("34378323877");
		
		Assert.assertNull(fromStore);
	}
	
	@Test
	public void list_aluno_by_id() {
		alunoDao.createOrUpdate(aluno);
		Assert.assertNotNull(aluno.getId());
		
		Pessoa fromStore = alunoDao.find(aluno.getId());
		
		Assert.assertEquals(fromStore, aluno);
	}
	
	@Test
	public void list_aluno() {
		Aluno aluno1 = Aluno.builder()
				.celular("(11)971634740")
				.cpf("34378323877")
				.email("aluno1@gmail.com")
				.nome("Aluno Hum dos Santos")
				.rg("441867935")
				.build();
		alunoDao.createOrUpdate(aluno1);
		
		Aluno aluno2 = Aluno.builder()
				.celular("(11)99990987")
				.cpf("23467656433")
				.email("aluno2@gmail.com")
				.nome("Aluno Dois dos Santos")
				.rg("441867933")
				.build();
		alunoDao.createOrUpdate(aluno2);
		
		Aluno aluno3 = Aluno.builder()
				.celular("(11)98876655")
				.cpf("43265487655")
				.email("aluno3@gmail.com")
				.nome("Aluno Tres dos Santos")
				.rg("441867925")
				.build();
		alunoDao.createOrUpdate(aluno3);
		
		List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3);
		List<Aluno> alunosFromStorage = alunoDao.findAll();
		
		Assert.assertArrayEquals(alunos.toArray(), alunosFromStorage.toArray());
	}
	
}
