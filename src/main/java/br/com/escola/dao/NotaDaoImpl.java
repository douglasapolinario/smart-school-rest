package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Nota;

@Stateless
public class NotaDaoImpl extends GenericDao<Nota> {

	@Override
	public Class<Nota> getEntityType() {
		return Nota.class;
	}

}
