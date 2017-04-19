package br.com.smartschool.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class SmartSchoolBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(AlunoResource.class).to(AlunoResource.class);
	}

}
