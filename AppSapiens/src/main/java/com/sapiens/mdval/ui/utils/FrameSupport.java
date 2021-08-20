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
     * Proceso de inicialización
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
	
	/**
	 * Encapsula la creación de componentes
	 */
	private void initComponents() {
		setupComponents();
		
		pack();
	}
	
	/**
	 * Instala los componentes internos de este frame
	 */
	protected abstract void setupComponents();
	
	/**
	 * Instala los eventos a los componentes que los necesiten
	 */
	protected abstract void initEvents();
	
	/**
	 * Inicia los modelos de combos, tablas, etc
	 */
	protected abstract void initModels();
	
	/**
	 * Estado inicial: los valores iniciales de los componentes que lo requieran
	 */
	protected abstract void initialState();
	
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
