package com.mdsql.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * @author federico
 *
 */
public class LiteralesSingleton {
	
	private static LiteralesSingleton instance;
	
	private Properties properties;
	
	private LiteralesSingleton() throws IOException {
		properties = new Properties();
		
		//the base folder is ./, the root of the main.properties file  
		String literalesPath = "./literales.properties";
		
		try (FileInputStream fistream = new FileInputStream(literalesPath)) {
			properties.load(new InputStreamReader(fistream, StandardCharsets.ISO_8859_1));
		}
	}
	
	public static LiteralesSingleton getInstance() throws IOException {
		if (instance == null) {
			instance = new LiteralesSingleton();
		}
		return instance;
	}
	
	/**
	 * @param key
	 * @return
	 */
	public String getLiteral(String key) {
		String value = properties.getProperty(key);

		return StringUtils.isNotBlank(value) ? value : StringUtils.EMPTY;
	}
}
