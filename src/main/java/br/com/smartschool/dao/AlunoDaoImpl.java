package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Aluno;

@Stateless
public class AlunoDaoImpl extends GenericDao<Aluno> {

	@Override
	public Class<Aluno> getEntityType() {
		return Aluno.class;
	}
	
	public Aluno findByCPF(String cpf) {
		StringBuilder queryCypher = new StringBuilder("MATCH (aluno:Aluno) WHERE aluno.cpf = '?' RETURN aluno");
		queryCypher.insert(queryCypher.indexOf("?"), cpf);
		queryCypher.deleteCharAt(queryCypher.indexOf("?"));
		
		return findByCypherQuery(queryCypher.toString());
	}

}
