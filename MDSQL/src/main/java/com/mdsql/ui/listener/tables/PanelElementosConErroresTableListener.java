package com.mdsql.ui.listener.tables;

import javax.swing.event.ListSelectionListener;

import com.mdsql.ui.validacionscripts.PanelElementosConErrores;

public class PanelElementosConErroresTableListener extends PanelResultadosTableListener implements ListSelectionListener {

	private PanelElementosConErrores panelElementosConErrores;

	public PanelElementosConErroresTableListener(PanelElementosConErrores panelElementosConErrores) {
		super(panelElementosConErrores);
		this.panelElementosConErrores = panelElementosConErrores;
	}
	
	@Override
	public void onSeleccionado() {
		panelElementosConErrores.getBtnMarcarExcepcion().setEnabled(Boolean.TRUE);
	}
}
