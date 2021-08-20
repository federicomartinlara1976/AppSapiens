package com.sapiens.mdval.ui.utils;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.sapiens.mdval.utils.LiteralesSingleton;

import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public abstract class DialogSupport extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637526827846474731L;

	protected LiteralesSingleton literales;
	
	/**
	 * 
	 */
	public DialogSupport() {
		super();
		
		initialize();
	}
	
	/**
	 * 
	 */
	public DialogSupport(JFrame parent, boolean modal) {
		super(parent, modal);
		
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
    private void initComponents() {
		setupComponents();
		
		pack();
	}
    
    /**
	 * Instala los componentes internos de este dialog
	 */
    protected abstract void setupComponents();
	
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
