package br.com.smartschool.model;

import java.io.Serializable;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@NodeEntity
public class Serie extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ano;

	private String turma;
	
	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.INCOMING)
	private Pessoa aluno;
	
	@Relationship(type = RelationshipType.PROFESSOR, direction = Relationship.INCOMING)
	private Set<Pessoa> professores;

	@Relationship(type = RelationshipType.GRADE, direction = Relationship.INCOMING)
	private Set<Disciplina> disciplinas;

	@Override
	public String toString() {
		return "Serie [ano=" + ano + ", turma=" + turma + "]";
	}
	


}
