package br.com.escola.util;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.testutil.TestServer;

public abstract class AbstractTest {
	
	@Inject
	private Session session;
	
	protected static TestServer testServer;
	
	@BeforeClass
	public static void setUp() {
		testServer = new TestServer.Builder().build();
	}

	@AfterClass
	public static void cleanUp() {
		testServer.shutdown();
	}
	
	@Before
	public void init() {
		
	}
	
	@After
	public void destroy() {
		session.purgeDatabase();
	}
	
}
