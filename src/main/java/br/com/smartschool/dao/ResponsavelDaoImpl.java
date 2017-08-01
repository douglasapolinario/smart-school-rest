package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Responsavel;

@Stateless
public class ResponsavelDaoImpl extends GenericDao<Responsavel> {

	@Override
	public Class<Responsavel> getEntityType() {
		return Responsavel.class;
	}

	public Responsavel findByCPF(String cpf) {
		StringBuilder queryCypher = new StringBuilder("MATCH (responsavel:Responsavel) WHERE responsavel.cpf = '?' RETURN responsavel");
		queryCypher.insert(queryCypher.indexOf("?"), cpf);
		queryCypher.deleteCharAt(queryCypher.indexOf("?"));
		
		return findByCypherQuery(queryCypher.toString());
	}
	
	public Responsavel findByEmail(String email) {
		StringBuilder queryCypher = new StringBuilder("MATCH (responsavel:Responsavel) WHERE responsavel.email = '?' RETURN responsavel");
		queryCypher.insert(queryCypher.indexOf("?"), email);
		queryCypher.deleteCharAt(queryCypher.indexOf("?"));
		
		return findByCypherQuery(queryCypher.toString());
	}

}
