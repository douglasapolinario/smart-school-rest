package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Disciplina;

@Stateless
public class DisciplinaDaoImpl extends GenericDao<Disciplina> {

	@Override
	public Class<Disciplina> getEntityType() {
		return Disciplina.class;
	}

	public Disciplina findByDescribe(String describe) {
		StringBuilder queryCypher = new StringBuilder("MATCH (disciplina:Disciplina) WHERE disciplina.descricao = '?' RETURN disciplina");
		queryCypher.insert(queryCypher.indexOf("?"), describe);
		queryCypher.deleteCharAt(queryCypher.indexOf("?"));
		
		return findByCypherQuery(queryCypher.toString());
	}

}
