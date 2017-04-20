package br.com.smartschool.model;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@NodeEntity
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Relationship(type = RelationshipType.PROFESSOR, direction = Relationship.OUTGOING)
	private Set<Serie> series;

	@Relationship(type = RelationshipType.LECIONA, direction = Relationship.OUTGOING)
	@JsonManagedReference
	private Set<Disciplina> disciplinas;
	
}
