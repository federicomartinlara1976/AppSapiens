package com.sapiens.mdval.ui.utils;

import java.io.IOException;

import javax.swing.JPanel;

import com.sapiens.mdval.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public abstract class PanelSupport extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637526827846474731L;
	
	protected LiteralesSingleton literales;
	
	@Getter
	protected FrameSupport frameParent;

	/**
	 * 
	 */
	public PanelSupport() {
		super();
		initialize();
	}
	
	/**
	 * 
	 */
	public PanelSupport(FrameSupport frameParent) {
		super();
		this.frameParent = frameParent;
		
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
			
			initialState();
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
