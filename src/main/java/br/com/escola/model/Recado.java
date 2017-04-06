package br.com.escola.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import br.com.escola.converter.LocalDateTimeConverter;
import br.com.escola.model.relationship.type.RelationshipType;

@NodeEntity
public class Recado extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Convert(LocalDateTimeConverter.class)
	private LocalDateTime data;
	
	private String assunto;
	
	private String textoRecado;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.OUTGOING)
	private Agenda agenda;

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTextoRecado() {
		return textoRecado;
	}

	public void setTextoRecado(String textoRecado) {
		this.textoRecado = textoRecado;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agenda == null) ? 0 : agenda.hashCode());
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((textoRecado == null) ? 0 : textoRecado.hashCode());
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
		Recado other = (Recado) obj;
		if (agenda == null) {
			if (other.agenda != null)
				return false;
		} else if (!agenda.equals(other.agenda))
			return false;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (textoRecado == null) {
			if (other.textoRecado != null)
				return false;
		} else if (!textoRecado.equals(other.textoRecado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recado [data=" + data + ", assunto=" + assunto + ", textoRecado=" + textoRecado + "]";
	}


}
