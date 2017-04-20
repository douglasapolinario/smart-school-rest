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
		
		Agenda agenda = new Agenda();
		agenda.setDescricao("Agenda do aluno xpto");

		aluno = new Aluno();
		aluno.setCelular("(11)971634740");
		aluno.setCpf("34378323877");
		aluno.setEmail("aluno1@gmail.com");
		aluno.setNome("Aluno Hum dos Santos");
		aluno.setRg("441867935");
		aluno.setAgenda(agenda);
		
		Set<Serie> series = new HashSet<>();
		series.add(serie);
		aluno.setSeries(series);
		
		Responsavel pai = new Responsavel();
		pai.setCelular("(11)971634740");
		pai.setCpf("37636224895");
		pai.setEmail("pai@gmail.com");
		pai.setNome("Pai do Aluno Hum");
		pai.setRg("327761129");
		
		Responsavel mae = new Responsavel();
		mae.setCelular("(11)971634740");
		mae.setCpf("23456789097");
		mae.setEmail("mae@gmail.com");
		mae.setNome("Mae do Aluno Hum");
		mae.setRg("327761126");
		
		Set<Responsavel> responsaveis = new HashSet<>(Arrays.asList(pai, mae));
		aluno.setResponsaveis(responsaveis);
		
		Set<Disciplina> disciplinas = new HashSet<>();
		Disciplina disciplina = new Disciplina();
		disciplina.setDescricao("Geografia");
		disciplina.setSeries(series);
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
		Pessoa aluno1 = new Pessoa();
		aluno1.setCelular("(11)971634740");
		aluno1.setCpf("34378323877");
		aluno1.setEmail("aluno1@gmail.com");
		aluno1.setNome("Aluno Hum dos Santos");
		aluno1.setRg("441867935");
		alunoDao.createOrUpdate(aluno1);
		
		Pessoa aluno2 = new Pessoa();
		aluno2.setCelular("(11)99990987");
		aluno2.setCpf("23467656433");
		aluno2.setEmail("aluno2@gmail.com");
		aluno2.setNome("Aluno Dois dos Santos");
		aluno2.setRg("441867933");
		alunoDao.createOrUpdate(aluno2);
		
		Pessoa aluno3 = new Pessoa();
		aluno3.setCelular("(11)98876655");
		aluno3.setCpf("43265487655");
		aluno3.setEmail("aluno3@gmail.com");
		aluno3.setNome("Aluno Tres dos Santos");
		aluno3.setRg("441867925");
		alunoDao.createOrUpdate(aluno3);
		
		List<Pessoa> alunos = Arrays.asList(aluno1, aluno2, aluno3);
		List<Pessoa> alunosFromStorage = alunoDao.findAll();
		
		Assert.assertArrayEquals(alunos.toArray(), alunosFromStorage.toArray());
	}
	
}
