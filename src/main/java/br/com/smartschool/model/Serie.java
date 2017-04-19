package br.com.smartschool.model;

import java.io.Serializable;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.com.smartschool.model.relationship.type.RelationshipType;

@NodeEntity
public class Serie extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ano;

	private String turma;
	
	@Relationship(type = RelationshipType.ALUNO, direction = Relationship.INCOMING)
	private Pessoa aluno;
	
	@Relationship(type = RelationshipType.PROFESSOR, direction = Relationship.INCOMING)
	private Set<Pessoa> professores;

	@Relationship(type = RelationshipType.GRADE, direction = Relationship.INCOMING)
	private Set<Disciplina> disciplinas;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Pessoa getAluno() {
		return aluno;
	}

	public void setAluno(Pessoa aluno) {
		this.aluno = aluno;
	}

	public Set<Pessoa> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Pessoa> professores) {
		this.professores = professores;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Serie [ano=" + ano + ", turma=" + turma + "]";
	}
	


}
