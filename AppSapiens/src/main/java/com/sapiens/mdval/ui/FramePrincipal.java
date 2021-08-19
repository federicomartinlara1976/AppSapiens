package com.sapiens.mdval.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.sapiens.mdval.ui.menu.MainMenuBar;
import com.sapiens.mdval.ui.utils.FrameSupport;
import com.sapiens.mdval.ui.validacionscripts.PanelPrincipal;

/**
 *
 * @author federico
 */
public class FramePrincipal extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6813614532398369392L;
	
	private JMenuBar menuBar;
	private JPanel panelPrincipal;

	/**
	 * Creates new form FramePrincipal
	 */
	public FramePrincipal() {
		super();
	}

	protected void setupComponents() {
		panelPrincipal = new PanelPrincipal(this);
		menuBar = new MainMenuBar();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH );
		
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		setJMenuBar(menuBar);
	}
	
	protected void setupLiterals() {
		setTitle(literales.getLiteral("panelPrincipal.titulo"));
	}

	@Override
	protected void initEvents() {}

	@Override
	protected void initialState() {}
}