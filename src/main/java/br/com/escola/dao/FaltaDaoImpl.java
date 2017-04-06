package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Falta;

@Stateless
public class FaltaDaoImpl extends GenericDao<Falta> {

	@Override
	public Class<Falta> getEntityType() {
		return Falta.class;
	}

}
