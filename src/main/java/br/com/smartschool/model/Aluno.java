package br.com.smartschool.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true, exclude={"agenda", "series", "responsaveis", "disciplinas"})
@NodeEntity
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String imagem;

	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Agenda agenda;

	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.OUTGOING)
	private Set<Serie> series;

	@Relationship(type = RelationshipType.RESPONSAVEL, direction = Relationship.INCOMING)
	@JsonBackReference
	private Set<Responsavel> responsaveis;

	@Relationship(type = RelationshipType.APRENDE, direction = Relationship.OUTGOING)
	private Set<Disciplina> disciplinas;
	
	@Builder
	private Aluno(String nome, String sobrenome, String email, String senha, String rg, String cpf, String celular, String telefone, String imagem,
			Agenda agenda, Set<Serie> series, Set<Responsavel> responsaveis, Set<Disciplina> disciplinas) {
		super(nome, sobrenome, email, senha, rg, cpf, celular, telefone);
		this.agenda = agenda;
		this.series = series;
		this.responsaveis = responsaveis;
		this.disciplinas = disciplinas;
		this.imagem = imagem;
	}
	
	public Optional<Map<String, String>> applyValidations() {
		Map<String, String> validations = new HashMap<>();
		
		if (getCpf() == null || getCpf().isEmpty()) {
			validations.put("cpf", "CPF é obrigatório");
		}
		
		return Optional.of(validations).filter(map -> !map.isEmpty());
	}

}
