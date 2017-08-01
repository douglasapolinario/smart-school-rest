package br.com.smartschool.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true, exclude={"alunos"})
@NodeEntity
public class Responsavel extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Relationship(type = RelationshipType.RESPONSAVEL, direction = Relationship.OUTGOING)
	private Set<Aluno> alunos;
	
	@Builder
	private Responsavel(String nome, String sobrenome, String email, String senha, String rg, String cpf, String celular, String telefone, 
			Set<Aluno> alunos) {
		super(nome, sobrenome, email, senha, rg, cpf, celular, telefone);
		this.alunos = alunos;
	}
	
	public Optional<Map<String, String>> applyValidations() {
		Map<String, String> validations = new HashMap<>();
		
		if (getNome() == null || getNome().isEmpty()) {
			validations.put("nome", "Nome responsável não pode ser nulo");
		}
		
		if (getSobrenome() == null || getSobrenome().isEmpty()) {
			validations.put("sobrenome", "Sobrenome responsável não pode ser nulo");
		}
	
		
		if (getRg() == null || getRg().isEmpty()) {
			validations.put("rg", "RG responsável inválido");
		}
		
		if (getCpf() == null || getCpf().isEmpty()) {
			validations.put("cpf", "CPF responsável inválido");
		}
	
		if (getCelular() == null || getCelular().isEmpty()) {
			validations.put("celular", "Celular responsável não pode ser nulo");
		}
		
		if (getTelefone() == null || getTelefone().isEmpty()) {
			validations.put("telefone", "Telefone responsável não pode ser nulo");
		}
		
		if (getEmail() == null || getEmail().isEmpty()) {
			validations.put("email", "Email responsável não pode ser nulo");
		}
		
		return Optional.of(validations).filter(map -> !map.isEmpty());
	}

}
