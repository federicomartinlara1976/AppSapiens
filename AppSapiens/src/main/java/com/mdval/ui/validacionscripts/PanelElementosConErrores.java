package com.mdval.ui.validacionscripts;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import com.mdval.ui.listener.tables.PanelElementosConErroresTableListener;

/**
 *
 * @author federico
 */
public class PanelElementosConErrores extends PanelResultados {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8717868648566455220L;
	
	/**
	 *
	 */
	@Override
	protected void initEvents() {
		super.initEvents();
		
		ListSelectionListener listSelectionListener = new PanelElementosConErroresTableListener(this);
		
		ListSelectionModel rowSM = super.getTblResultados().getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
	}
}
