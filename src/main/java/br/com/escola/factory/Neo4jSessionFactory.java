package br.com.escola.factory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

@Singleton
public class Neo4jSessionFactory {

	private SessionFactory sessionFactory;

	@PostConstruct
	public void init() {
		sessionFactory = new SessionFactory("br.com.escola.model");;
	}
	
	@Produces
	public Session createSession() {
		return sessionFactory.openSession();
	}
}
