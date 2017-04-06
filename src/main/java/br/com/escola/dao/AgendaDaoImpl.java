package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Agenda;

@Stateless
public class AgendaDaoImpl extends GenericDao<Agenda> {

	@Override
	public Class<Agenda> getEntityType() {
		return Agenda.class;
	}

	public Agenda findByDescribe(String describe) {
		StringBuilder queryCypher = new StringBuilder("MATCH (agenda:Agenda) WHERE agenda.descricao = '?' RETURN agenda");
		queryCypher.insert(queryCypher.indexOf("?"), describe);
		queryCypher.deleteCharAt(queryCypher.indexOf("?"));
		
		return findByCypherQuery(queryCypher.toString());
	}
	

}
