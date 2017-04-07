package br.com.escola.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.escola.dao.DisciplinaDaoImpl;

@ApplicationPath("/")
public class EscolaService extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
 
	public EscolaService() {
		singletons.add(new AlunoResource());
		singletons.add(new DisciplinaDaoImpl());
	}
 
	public Set<Class<?>> getClasses() {
		return empty;
	}
 
	public Set<Object> getSingletons() {
		return singletons;
	}
	
}
