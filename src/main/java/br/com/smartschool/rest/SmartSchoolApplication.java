package br.com.smartschool.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class SmartSchoolApplication extends ResourceConfig {
	
	public SmartSchoolApplication() {
		packages("br.com.smartschool");
		
		property(ServerProperties.TRACING, "ALL");
	}
	
}
