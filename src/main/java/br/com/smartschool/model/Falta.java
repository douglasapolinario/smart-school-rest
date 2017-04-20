package br.com.smartschool.model;

import java.io.Serializable;
import java.math.BigInteger;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@NodeEntity
public class Falta extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger total;

	@Override
	public String toString() {
		return "Falta [total=" + total + "]";
	}

}
