/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.sapiens.app.ui.menu.MainMenuBar;
import com.sapiens.app.ui.utils.FrameSupport;
import com.sapiens.app.ui.validacionscripts.PanelPrincipal;

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
