package br.com.escola.dao;

import javax.ejb.Stateless;

import br.com.escola.model.Escola;

@Stateless
public class EscolaDaoImpl extends GenericDao<Escola> {

	@Override
	public Class<Escola> getEntityType() {
		return Escola.class;
	}
	
}
