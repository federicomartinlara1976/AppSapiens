package com.mdval.ui.renderer;


import java.awt.Color;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import com.mdval.utils.LiteralesSingleton;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class LabelRenderer extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2036889204388173667L;

	protected LiteralesSingleton literales;
	
	/**
	 * 
	 */
	public LabelRenderer() {
		super();
		
		try {
			literales = LiteralesSingleton.getInstance();
			
			setOpaque(Boolean.TRUE);
			Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1); 
	        setBorder(border);
		} catch (IOException e) {
			LogWrapper.error(log, "ERROR:", e);
		}
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
