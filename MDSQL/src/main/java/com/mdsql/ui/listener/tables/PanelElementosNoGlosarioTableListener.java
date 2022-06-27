package com.mdsql.ui.listener.tables;

import javax.swing.event.ListSelectionListener;

import com.mdsql.ui.validacionscripts.PanelElementosNoGlosario;

public class PanelElementosNoGlosarioTableListener extends PanelResultadosTableListener implements ListSelectionListener {

	private PanelElementosNoGlosario panelElementosNoGlosario;

	public PanelElementosNoGlosarioTableListener(PanelElementosNoGlosario panelElementosNoGlosario) {
		super(panelElementosNoGlosario);
		this.panelElementosNoGlosario = panelElementosNoGlosario;
	}
	
	@Override
	public void onSeleccionado() {
		panelElementosNoGlosario.getBtnAddGlosario().setEnabled(Boolean.TRUE);
	}
}
