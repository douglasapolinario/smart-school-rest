package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Bimestre;

@Stateless
public class BimestreDaoImpl extends GenericDao<Bimestre> {

	@Override
	public Class<Bimestre> getEntityType() {
		return Bimestre.class;
	}
	

}
