package br.com.smartschool.factory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

@Singleton
public class Neo4jSessionFactory {

	private SessionFactory sessionFactory;

	@PostConstruct
	public void init() {
		sessionFactory = new SessionFactory("br.com.smartschool.model");;
	}
	
	@Produces
	@Default
	public Session createSession() {
		return sessionFactory.openSession();
	}
}
