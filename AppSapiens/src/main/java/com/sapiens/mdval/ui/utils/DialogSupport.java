package com.sapiens.mdval.ui.utils;

import java.io.IOException;

import javax.swing.JDialog;

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
    private void initialize() {
		try {
			initComponents();
			initLiterals();
			initEvents();
			
			initialState();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
	}
	
	protected abstract void initComponents();
	
	protected abstract void initEvents();
	
	protected abstract void initialState();
	
	protected abstract void setupLiterals();
	
	private void initLiterals() throws IOException {
		literales = LiteralesSingleton.getInstance();
		
		setupLiterals();
	}
}
