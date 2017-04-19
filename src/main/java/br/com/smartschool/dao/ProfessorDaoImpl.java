package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Pessoa;

@Stateless
public class ProfessorDaoImpl extends GenericDao<Pessoa> {

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
