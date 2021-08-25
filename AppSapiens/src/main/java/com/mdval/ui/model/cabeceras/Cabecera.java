package com.mdval.ui.model.cabeceras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mdval.utils.LiteralesSingleton;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public abstract class Cabecera {
	
	protected LiteralesSingleton literales;
	
	protected List<String> columnIdentifiers;
	protected List<Class<?>> columnClasses;
	
	/**
	 * 
	 */
	public Cabecera() {
		super();
		
		initialize();
	}
	
	/**
	 * 
	 */
	private void initialize() {
		try {
			literales = LiteralesSingleton.getInstance();
			
			columnIdentifiers = new ArrayList<>();
			columnClasses = new ArrayList<>();
			
			setupCabecera();
		} catch (IOException e) {
			LogWrapper.error(log,  "ERROR:", e);
		}
	}
	
	/**
	 * 
	 */
	public abstract void setupCabecera();

	/**
	 * @return
	 */
	public List<String> getColumnIdentifiers() {
		return columnIdentifiers;
	}
	
	/**
	 * @return
	 */
	public List<Class<?>> getColumnClasses() {
		return columnClasses;
	}
}
