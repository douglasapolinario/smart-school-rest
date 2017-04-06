package br.com.escola.model;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.escola.model.relationship.type.RelationshipType;

@NodeEntity
public class Bimestre extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;

	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.INCOMING)
	private Pessoa aluno;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Disciplina disciplina;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Serie serie;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Nota nota;

	@Relationship(type = RelationshipType.TEM, direction = Relationship.INCOMING)
	private Falta falta;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getAluno() {
		return aluno;
	}

	public void setAluno(Pessoa aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Falta getFalta() {
		return falta;
	}

	public void setFalta(Falta falta) {
		this.falta = falta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((falta == null) ? 0 : falta.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
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
		Bimestre other = (Bimestre) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (falta == null) {
			if (other.falta != null)
				return false;
		} else if (!falta.equals(other.falta))
			return false;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bimestre [descricao=" + descricao + ", aluno=" + aluno + ", disciplina=" + disciplina + ", serie="
				+ serie + ", nota=" + nota + ", falta=" + falta + "]";
	}

}
