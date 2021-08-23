package com.mdval.ui.model.cabeceras;

import java.io.IOException;
import java.util.List;

import com.mdval.utils.LiteralesSingleton;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public abstract class Cabecera {
	
	protected LiteralesSingleton literales;
	
	public Cabecera() {
		super();
		
		initialize();
	}
	
	private void initialize() {
		try {
			literales = LiteralesSingleton.getInstance();
			
			setupCabecera();
		} catch (IOException e) {
			LogWrapper.error(log,  "ERROR:", e);
		}
	}
	
	public abstract void setupCabecera();

	public abstract List<String> getColumnIdentifiers();
	
	public abstract List<Class<?>> getColumnClasses();
}
