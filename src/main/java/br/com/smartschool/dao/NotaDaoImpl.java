package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Nota;

@Stateless
public class NotaDaoImpl extends GenericDao<Nota> {

	@Override
	public Class<Nota> getEntityType() {
		return Nota.class;
	}

}
