package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Serie;

@Stateless
public class SerieDaoImpl extends GenericDao<Serie> {

	@Override
	public Class<Serie> getEntityType() {
		return Serie.class;
	}

	public Serie findByAnoTurma(String ano, String turma) {
		StringBuilder queryCypher = new StringBuilder("MATCH (serie:Serie) WHERE serie.ano = '?1' and serie.turma = '?2' RETURN serie");
		queryCypher.insert(queryCypher.indexOf("?1"), ano);
		queryCypher.insert(queryCypher.indexOf("?2"), turma);
		queryCypher.delete(queryCypher.indexOf("?1"), queryCypher.indexOf("?1") + 2);
		queryCypher.delete(queryCypher.indexOf("?2"), queryCypher.indexOf("?2") + 2);
		
		return findByCypherQuery(queryCypher.toString());
	}
	
}
