package com.mdval.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author federico
 *
 */
public class AppHelper {
	
	/**
	 * Para usar el bean después de obtenerlo, hacer un cast
	 * del bean concreto.
	 * 
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		ApplicationContext context = (ApplicationContext) appGlobalSingleton.getProperty(Constants.SPRING_CONTEXT);
	
		return context.getBean(name);
	}
}
