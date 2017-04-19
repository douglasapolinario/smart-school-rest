package br.com.smartschool.dao;

import javax.ejb.Stateless;

import br.com.smartschool.model.Escola;

@Stateless
public class EscolaDaoImpl extends GenericDao<Escola> {

	@Override
	public Class<Escola> getEntityType() {
		return Escola.class;
	}
	
}
