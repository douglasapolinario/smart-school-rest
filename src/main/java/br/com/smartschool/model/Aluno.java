package br.com.smartschool.model;

import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.smartschool.model.relationship.type.RelationshipType;

public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Agenda agenda;

	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.OUTGOING)
	private Set<Serie> series;

	@Relationship(type = RelationshipType.RESPONSAVEL, direction = Relationship.INCOMING)
	private Set<Responsavel> responsaveis;

	@Relationship(type = RelationshipType.APRENDE, direction = Relationship.OUTGOING)
	@JsonManagedReference
	private Set<Disciplina> disciplinas;

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Set<Serie> getSeries() {
		return series;
	}

	public void setSeries(Set<Serie> series) {
		this.series = series;
	}

	public Set<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(Set<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
