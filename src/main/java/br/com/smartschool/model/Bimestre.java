package br.com.smartschool.model;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@NodeEntity
public class Bimestre extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;

	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.INCOMING)
	private Pessoa aluno;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Disciplina disciplina;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Serie serie;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Nota nota;

	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Falta falta;

	@Override
	public String toString() {
		return "Bimestre [descricao=" + descricao + ", aluno=" + aluno + ", disciplina=" + disciplina + ", serie="
				+ serie + ", nota=" + nota + ", falta=" + falta + "]";
	}

}
