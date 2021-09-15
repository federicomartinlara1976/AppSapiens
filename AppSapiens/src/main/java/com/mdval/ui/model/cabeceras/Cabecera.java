package com.mdval.ui.model.cabeceras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mdval.utils.LiteralesSingleton;
import com.mdval.utils.LogWrapper;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public abstract class Cabecera {
	
	protected LiteralesSingleton literales;
	
	@Getter
	protected List<String> columnIdentifiers;
	
	@Getter
	protected List<Class<?>> columnClasses;
	
	@Getter
	protected List<Integer> columnSizes;
	
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
			columnSizes = new ArrayList<>();
			
			setupCabecera();
		} catch (IOException e) {
			LogWrapper.error(log,  "ERROR:", e);
		}
	}
	
	/**
	 * 
	 */
	public abstract void setupCabecera();
}
