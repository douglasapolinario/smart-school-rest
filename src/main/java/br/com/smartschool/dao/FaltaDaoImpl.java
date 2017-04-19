package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Falta;

@Stateless
public class FaltaDaoImpl extends GenericDao<Falta> {

	@Override
	public Class<Falta> getEntityType() {
		return Falta.class;
	}

}
