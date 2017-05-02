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
@EqualsAndHashCode(callSuper=false, exclude={"aluno", "recados"})
@NodeEntity
public class Agenda extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;

	private Long ano; 
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.OUTGOING)
	private Pessoa aluno;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Set<Recado> recados;
	
	@Override
	public String toString() {
		return "Agenda [descicao=" + descricao + ", ano=" + ano + ", aluno=" + aluno + "]";
	}

}
