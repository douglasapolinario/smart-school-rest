package br.com.escola.model;

import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

import br.com.escola.model.relationship.type.RelationshipType;

public class Responsavel extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Relationship(type = RelationshipType.RESPONSAVEL, direction = Relationship.OUTGOING)
	private Set<Aluno> alunos;

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

}
