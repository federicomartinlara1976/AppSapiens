package com.mdsql.ui.validacionscripts;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import com.mdsql.ui.listener.tables.PanelElementosNoGlosarioTableListener;

/**
 *
 * @author federico
 */
public class PanelElementosNoGlosario extends PanelResultados {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8717868648566455220L;
	
	public PanelElementosNoGlosario(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
	}

	/**
	 *
	 */
	@Override
	protected void initEvents() {
		super.initEvents();
		
		ListSelectionListener listSelectionListener = new PanelElementosNoGlosarioTableListener(this);
		
		ListSelectionModel rowSM = super.getTblResultados().getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
	}
}
