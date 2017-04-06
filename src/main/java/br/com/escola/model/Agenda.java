package br.com.escola.model;

import java.io.Serializable;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.escola.model.relationship.type.RelationshipType;

@NodeEntity
public class Agenda extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;

	private Long ano; 
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.OUTGOING)
	private Pessoa aluno;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Set<Recado> recados;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Pessoa getAluno() {
		return aluno;
	}

	public void setAluno(Pessoa aluno) {
		this.aluno = aluno;
	}

	public Set<Recado> getRecados() {
		return recados;
	}

	public void setRecados(Set<Recado> recados) {
		this.recados = recados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
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
		Agenda other = (Agenda) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda [descicao=" + descricao + ", ano=" + ano + ", aluno=" + aluno + "]";
	}

}
