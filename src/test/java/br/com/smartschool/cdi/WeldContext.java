package br.com.smartschool.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class WeldContext {
	
	public static final WeldContext INSTANCE = new WeldContext();
	
	private final Weld weld;
	private final WeldContainer weldContainer;
	
	private WeldContext() {
		this.weld = new Weld();
		this.weldContainer = weld.initialize();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				weld.shutdown();
			}
		});
	}
	
	public <T> T getBean(Class<T> type) {
		return weldContainer.instance().select(type).get();
	}

}
