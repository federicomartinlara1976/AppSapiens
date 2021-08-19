package com.sapiens.mdval.ui.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sapiens.mdval.ui.validacionscripts.PanelPrincipal;
import com.sapiens.mdval.utils.Constants;
import com.sapiens.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class PanelPrincipalChangeListener extends PanelPrincipalListener implements ChangeListener {

	public PanelPrincipalChangeListener(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
//		Integer selectedIndex = panelPrincipal.getJTabbedPane1().getSelectedIndex();
//
//		switch (selectedIndex) {
//		case 0:
//			eventTabElementosValidar();
//			break;
//		case 1:
//			eventTabElementosCorrectos();
//			break;
//		case 2:
//			eventTabElementosNoGlosario();
//			break;
//		case 3:
//			eventTabElementosErrores();
//			break;
//		case 4:
//			eventTabExcepciones();
//			break;
//		}
	}

	private void eventTabElementosValidar() {
		LogWrapper.debug(log, "Click en la tab elementos a validar ");
	}

	private void eventTabElementosCorrectos() {
		LogWrapper.debug(log, "Click en la tab elementos correctos ");
	}

	private void eventTabElementosNoGlosario() {
		LogWrapper.debug(log, "Click en la tab elementos que no estan en el glosario ");
	}

	private void eventTabElementosErrores() {
		showPopup(panelPrincipal.getFrameParent(), Constants.CMD_PANEL_PRINCIPAL_TAB_EXCEPCIONES);
	}

	private void eventTabExcepciones() {
		LogWrapper.debug(log, "Click en la tab excepciones ");
	}
}
