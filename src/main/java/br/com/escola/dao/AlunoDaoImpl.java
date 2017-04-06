package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Pessoa;

@Stateless
public class AlunoDaoImpl extends GenericDao<Pessoa> {

	@Override
	public Class<Pessoa> getEntityType() {
		return Pessoa.class;
	}
	
	public Pessoa findByCPF(String cpf) {
		StringBuilder queryCypher = new StringBuilder("MATCH (pessoa:Pessoa) WHERE pessoa.cpf = '?' RETURN pessoa");
		queryCypher.insert(queryCypher.indexOf("?"), cpf);
		queryCypher.deleteCharAt(queryCypher.indexOf("?"));
		
		return findByCypherQuery(queryCypher.toString());
	}

}
