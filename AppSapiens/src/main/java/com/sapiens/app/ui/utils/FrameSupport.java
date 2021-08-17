package com.sapiens.app.ui.utils;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.sapiens.app.ui.PanelLogotipo;

import lombok.Getter;

/**
 * @author federico
 *
 */
public abstract class FrameSupport extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637526827846474731L;
	
	@Getter
	protected PanelLogotipo panelLogo;

	/**
	 * 
	 */
	public FrameSupport() {
		panelLogo = new PanelLogotipo("logotipo.png");
		panelLogo.setPreferredSize(new Dimension(286, 63));
	}
}
