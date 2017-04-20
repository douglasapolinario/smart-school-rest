package br.com.smartschool.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import br.com.smartschool.converter.LocalDateTimeConverter;
import br.com.smartschool.model.relationship.type.RelationshipType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@NodeEntity
public class Recado extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Convert(LocalDateTimeConverter.class)
	private LocalDateTime data;
	
	private String assunto;
	
	private String textoRecado;
	
	@Relationship(type = RelationshipType.TEM, direction = Relationship.OUTGOING)
	private Agenda agenda;

	@Override
	public String toString() {
		return "Recado [data=" + data + ", assunto=" + assunto + ", textoRecado=" + textoRecado + "]";
	}


}
