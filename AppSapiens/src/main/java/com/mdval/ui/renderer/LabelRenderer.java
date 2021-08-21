package com.mdval.ui.renderer;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public abstract class LabelRenderer extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2036889204388173667L;

	/**
	 * 
	 */
	public LabelRenderer() {
		super();
		setOpaque(Boolean.TRUE);
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1); 
        setBorder(border);
	}
	
	/**
	 * @param isSelected
	 */
	protected void setSelected(Boolean isSelected) {
		if (isSelected) {
			super.setBackground(Color.BLUE);
			super.setForeground(Color.WHITE);
		}
		else {
			super.setBackground(Color.WHITE);
			super.setForeground(Color.BLACK);
		}
	}
}
