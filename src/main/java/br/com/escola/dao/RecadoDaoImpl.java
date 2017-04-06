package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Recado;

@Stateless
public class RecadoDaoImpl extends GenericDao<Recado> {

	@Override
	public Class<Recado> getEntityType() {
		return Recado.class;
	}

}
