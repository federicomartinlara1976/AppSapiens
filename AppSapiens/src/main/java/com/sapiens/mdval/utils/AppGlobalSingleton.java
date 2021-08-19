package com.sapiens.mdval.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author federico
 *
 */
public class AppGlobalSingleton {
	
	private static AppGlobalSingleton instance;
	
	private Map<String, Object> properties;
	
	private AppGlobalSingleton() {
		properties = new HashMap<>();
	}
	
	public static AppGlobalSingleton getInstance() {
		if (instance == null) {
			instance = new AppGlobalSingleton();
		}
		return instance;
	}
	
	/**
	 * @param key
	 * @return
	 */
	public Object getProperty(String key) {
		return properties.get(key);
	}
	
	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}
}
