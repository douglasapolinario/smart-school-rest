package br.com.escola.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class EscolaService extends ResourceConfig {
	
	public EscolaService() {
//		register(new SmartSchoolBinder());
		packages("br.com.escola");
		
		property(ServerProperties.TRACING, "ALL");
	}

//	private Set<Object> singletons = new HashSet<Object>();
//	private Set<Class<?>> empty = new HashSet<Class<?>>();
// 
//	public EscolaService() {
//		singletons.add(new AlunoResource());
////		singletons.add(new DisciplinaDaoImpl());
////		singletons.add(new GenericDao() {
////
////			@Override
////			public Class getEntityType() {
////				// TODO Auto-generated method stub
////				return null;
////			}
////		});
//	}
// 
//	public Set<Class<?>> getClasses() {
//		return empty;
//	}
// 
//	public Set<Object> getSingletons() {
//		return singletons;
//	}
	
}
