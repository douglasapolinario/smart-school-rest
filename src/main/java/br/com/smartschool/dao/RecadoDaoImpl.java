package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Recado;

@Stateless
public class RecadoDaoImpl extends GenericDao<Recado> {

	@Override
	public Class<Recado> getEntityType() {
		return Recado.class;
	}

}
