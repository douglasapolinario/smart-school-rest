package br.com.smartschool.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Agenda agenda;

	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.OUTGOING)
	private Set<Serie> series;

	@Relationship(type = RelationshipType.RESPONSAVEL, direction = Relationship.INCOMING)
	private Set<Responsavel> responsaveis;

	@Relationship(type = RelationshipType.APRENDE, direction = Relationship.OUTGOING)
	@JsonManagedReference
	private Set<Disciplina> disciplinas;
	
	@Builder
	private Aluno(String nome, String email, String senha, String rg, String cpf, String celular, String telefone, 
			Agenda agenda, Set<Serie> series, Set<Responsavel> responsaveis, Set<Disciplina> disciplinas) {
		super(nome, email, senha, rg, cpf, celular, telefone);
		this.agenda = agenda;
		this.series = series;
		this.responsaveis = responsaveis;
		this.disciplinas = disciplinas;
	}
	
	public Optional<Map<String, String>> applyValidations() {
		Map<String, String> validations = new HashMap<>();
		
		if (getCpf() == null || getCpf().isEmpty()) {
			validations.put("cpf", "CPF é obrigatório");
		}
		
		return Optional.of(validations).filter(map -> !map.isEmpty());
	}

}
