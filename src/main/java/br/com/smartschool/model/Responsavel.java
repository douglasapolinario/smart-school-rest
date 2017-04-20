package br.com.smartschool.model;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@NodeEntity
public class Responsavel extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Relationship(type = RelationshipType.RESPONSAVEL, direction = Relationship.OUTGOING)
	private Set<Aluno> alunos;
	
	@Builder
	private Responsavel(String nome, String email, String senha, String rg, String cpf, String celular, String telefone, 
			Set<Aluno> alunos) {
		super(nome, email, senha, rg, cpf, celular, telefone);
		this.alunos = alunos;
	}

}
