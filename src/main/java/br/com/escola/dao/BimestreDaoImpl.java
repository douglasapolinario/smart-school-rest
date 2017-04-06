package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Bimestre;

@Stateless
public class BimestreDaoImpl extends GenericDao<Bimestre> {

	@Override
	public Class<Bimestre> getEntityType() {
		return Bimestre.class;
	}
	

}
