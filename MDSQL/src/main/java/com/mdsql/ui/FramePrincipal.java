package com.mdsql.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.mdsql.ui.menu.MainMenuBar;
import com.mdsql.ui.utils.FrameSupport;
import com.mdsql.ui.validacionscripts.PanelPrincipal;

/**
 *
 * @author federico
 */
public class FramePrincipal extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6813614532398369392L;
	
	private JPanel panelPrincipal;

	/**
	 * Creates new form FramePrincipal
	 */
	public FramePrincipal() {
		super();
	}

	protected void setupComponents() {
		panelPrincipal = new PanelPrincipal(this);
		JMenuBar barraMenu = new MainMenuBar();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH );
		
		setMinimumSize(new Dimension(1366, 768));
        setPreferredSize(new Dimension(1366, 768));
        
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		setJMenuBar(barraMenu);
	}
	
	protected void setupLiterals() {
		setTitle(literales.getLiteral("panelPrincipal.titulo"));
	}

	@Override
	protected void initEvents() {}

	@Override
	protected void initialState() {}

	@Override
	protected void initModels() {}
}
