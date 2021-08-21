package com.mdval.ui.utils;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mdval.ui.PanelLogotipo;
import com.mdval.utils.DateFormatter;
import com.mdval.utils.LiteralesSingleton;

import lombok.Getter;
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
	
	@Getter
	protected PanelLogotipo panelLogo;
	
	protected Map<String, Object> params;
	
	protected DateFormatter dateFormatter;
	
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
	 * 
	 */
	public DialogSupport(JFrame parent, boolean modal, Map<String, Object> params) {
		super(parent, modal);
		this.params = params;
		
		initialize();
	}
	
	/**
     * Proceso de inicialización
     */
    private void initialize() {
		try {
			panelLogo = new PanelLogotipo("logotipo.png");
			panelLogo.setPreferredSize(new Dimension(286, 63));
			
			dateFormatter = new DateFormatter();
			
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
	 * Inicia los modelos de combos, tablas, etc
	 */
	protected abstract void initModels();
	
	/**
	 * Estado inicial: los valores iniciales de los componentes que lo requieran
	 */
	protected abstract void initialState();
	
	/**
	 * Encapsula la creación de los literales
	 * @throws IOException
	 */
	private void initLiterals() throws IOException {
		literales = LiteralesSingleton.getInstance();
		
		setupLiterals();
	}
}
