package br.com.escola.model;

import java.io.Serializable;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.escola.model.relationship.type.RelationshipType;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Set<Pessoa> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Pessoa> alunos) {
		this.alunos = alunos;
	}

	public Set<Pessoa> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Pessoa> professores) {
		this.professores = professores;
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
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
		Escola other = (Escola) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Escola [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + "]";
	}	

	
}