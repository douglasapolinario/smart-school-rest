package br.com.smartschool.model;

import java.io.Serializable;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@EqualsAndHashCode(callSuper=false, exclude={"professores", "alunos", "series"})
@NodeEntity
public class Disciplina extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	
	@Relationship(type = RelationshipType.LECIONA, direction = Relationship.INCOMING)
	private Set<Pessoa> professores;

	@Relationship(type = RelationshipType.APRENDE, direction = Relationship.INCOMING)
	@JsonBackReference
	private Set<Pessoa> alunos;
	
	@Relationship(type = RelationshipType.GRADE, direction = Relationship.OUTGOING)
	private Set<Serie> series;

	@Override
	public String toString() {
		return "Disciplina [descricao=" + descricao + "]";
	}

}
