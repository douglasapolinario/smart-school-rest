package br.com.escola.model;

import java.io.Serializable;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.escola.model.relationship.type.RelationshipType;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Pessoa> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Pessoa> professores) {
		this.professores = professores;
	}

	public Set<Pessoa> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Pessoa> alunos) {
		this.alunos = alunos;
	}

	public Set<Serie> getSeries() {
		return series;
	}

	public void setSeries(Set<Serie> series) {
		this.series = series;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [descricao=" + descricao + "]";
	}

}
