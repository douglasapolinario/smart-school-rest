package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Agenda;

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
