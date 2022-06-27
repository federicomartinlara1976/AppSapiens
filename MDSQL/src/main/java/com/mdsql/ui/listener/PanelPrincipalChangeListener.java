package com.mdsql.ui.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.mdsql.ui.validacionscripts.PanelPrincipal;
import com.mdsql.ui.validacionscripts.PanelResultados;

public class PanelPrincipalChangeListener extends PanelPrincipalListener implements ChangeListener {
	
	public PanelPrincipalChangeListener(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Integer selectedIndex = panelPrincipal.getJTabbedPane1().getSelectedIndex();
		PanelResultados panelResultados = (PanelResultados) panelPrincipal.getJTabbedPane1().getComponentAt(selectedIndex);
		PanelResultadosListener listener = panelResultados.getPanelResultadosListener();
		
		switch (selectedIndex) {
		case 0: break;
		case 1:
			listener.cargarElementosCorrectos();
			break;
		case 2: 
			listener.cargarElementosNoGlosario();
			break;
		case 3: 
			listener.cargarElementosErrores();
			break;
		case 4: 
			listener.cargarExcepciones();
			break;
		}
	}

	
}
