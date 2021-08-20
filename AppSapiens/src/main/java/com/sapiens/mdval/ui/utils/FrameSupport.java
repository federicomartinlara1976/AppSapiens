package com.sapiens.mdval.ui.utils;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import com.sapiens.mdval.ui.PanelLogotipo;
import com.sapiens.mdval.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public abstract class FrameSupport extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637526827846474731L;
	
	@Getter
	protected PanelLogotipo panelLogo;
	
	protected LiteralesSingleton literales;

	/**
	 * 
	 */
	public FrameSupport() {
		panelLogo = new PanelLogotipo("logotipo.png");
		panelLogo.setPreferredSize(new Dimension(286, 63));
		
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
			
			initModels();
			initialState();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
	}
	
	private void initComponents() {
		setupComponents();
		
		pack();
	}
	
	protected abstract void setupComponents();
	
	protected abstract void initEvents();
	
	protected abstract void initModels();
	
	protected abstract void initialState();
	
	protected abstract void setupLiterals();
	
	private void initLiterals() throws IOException {
		literales = LiteralesSingleton.getInstance();
		
		setupLiterals();
	}
}
