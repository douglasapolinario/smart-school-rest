package br.com.smartschool.model;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;

import br.com.caelum.stella.bean.validation.CPF;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@NodeEntity
public class Pessoa extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String email;

	private String senha;

	private String rg;

	@CPF
	private String cpf;

	private String celular;
	
	private String telefone;
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + ", senha=" + senha + ", rg=" + rg + ", cpf=" + cpf
				+ ", celular=" + celular + ", telefone=" + telefone + "]";
	}

	
}
