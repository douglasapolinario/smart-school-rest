package br.com.escola.model;

import java.io.Serializable;
import java.math.BigInteger;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Nota extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger valor;

	public BigInteger getValor() {
		return valor;
	}

	public void setValor(BigInteger valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Nota other = (Nota) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nota [valor=" + valor + "]";
	}



}
