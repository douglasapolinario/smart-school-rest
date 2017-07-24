package br.com.smartschool.model;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
	
	@Builder
	private Professor(String nome, String sobrenome, String email, String senha, String rg, String cpf, String celular, String telefone, 
			Set<Serie> series, Set<Disciplina> disciplinas) {
		super(nome, sobrenome, email, senha, rg, cpf, celular, telefone);
		this.series = series;
		this.disciplinas = disciplinas;
	}
	
}
