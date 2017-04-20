package br.com.smartschool.model;

import java.io.Serializable;
import java.util.Set;

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
public class Escola extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	
	private String razaoSocial;

	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.INCOMING)
	private Set<Pessoa> alunos;
	
	@Relationship(type = RelationshipType.PROFESSOR, direction = Relationship.INCOMING)
	private Set<Pessoa> professores;
	
	@Relationship(type = RelationshipType.SERIES, direction = Relationship.INCOMING)
	private Set<Serie> series;

	@Override
	public String toString() {
		return "Escola [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + "]";
	}	

	
}