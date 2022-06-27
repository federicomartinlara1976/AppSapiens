package com.mdsql.ui.utils;


import java.io.IOException;

import javax.swing.JMenuBar;

import com.mdsql.utils.LiteralesSingleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public abstract class MenuSupport extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637526827846474731L;
	
	protected LiteralesSingleton literales;

	/**
	 * 
	 */
	public MenuSupport() {
		super();
		initialize();
	}
	
	/**
     * Proceso de inicialización
     */
    private void initialize() {
		try {
			initComponents();
			initLiterals();
			initEvents();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
	}
	
    /**
	 * Encapsula la creación de componentes
	 */
	protected abstract void initComponents();
	
	/**
	 * Instala los eventos a los componentes que los necesiten
	 */
	protected abstract void initEvents();
	
	/**
	 * Literales de los componentes
	 */
	protected abstract void setupLiterals();
	
	/**
	 * Encapsula la creación de los literales
	 * @throws IOException
	 */
	private void initLiterals() throws IOException {
		literales = LiteralesSingleton.getInstance();
		
		setupLiterals();
	}
}
