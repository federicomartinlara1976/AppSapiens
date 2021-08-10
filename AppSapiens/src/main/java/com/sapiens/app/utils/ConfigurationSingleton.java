package com.sapiens.app.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hcarreno
 *
 */
public class ConfigurationSingleton {

	private static ConfigurationSingleton instance;

	private Properties properties;

	private ConfigurationSingleton() throws IOException {
		properties = new Properties();
		
		//the base folder is ./, the root of the main.properties file  
		String propertiesPath = "./configuration.properties";
		
		FileInputStream fistream = new FileInputStream(propertiesPath);
		properties.load(fistream);
	}
	
	public static ConfigurationSingleton getInstance() throws IOException {
		if (instance == null) {
			instance = new ConfigurationSingleton();
		}
		return instance;
	}
	
	/**
	 * @param key
	 * @return
	 */
	public String getConfig(String key) {
		String value = properties.getProperty(key);

		return StringUtils.isNotBlank(value) ? value : StringUtils.EMPTY;
	}
}
