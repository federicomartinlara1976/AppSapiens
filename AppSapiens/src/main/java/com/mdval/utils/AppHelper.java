package com.mdval.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author federico
 *
 */
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
	
	/**
	 * Normaliza el valor de SI y NO a S y N
	 * 
	 * @param value
	 * @return
	 */
	public static String normalizeCmbSiNoValue(String value) {
		return "SI".equals(value)
				? "S"
				: "N";
	}
	
	/**
	 * Normaliza el valor de S y N a SI y NO
	 * 
	 * @param value
	 * @return
	 */
	public static String normalizeSiNoValueToCmb(String value) {
		return "S".equals(value)
				? "SI"
				: "NO";
	}
}
