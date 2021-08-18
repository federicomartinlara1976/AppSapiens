package com.sapiens.app.ui.utils;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import com.sapiens.app.ui.PanelLogotipo;
import com.sapiens.app.utils.LiteralesSingleton;

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
