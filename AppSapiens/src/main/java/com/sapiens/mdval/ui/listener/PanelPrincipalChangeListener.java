package com.sapiens.mdval.ui.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sapiens.mdval.ui.validacionscripts.PanelPrincipal;
import com.sapiens.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class PanelPrincipalChangeListener extends PanelPrincipalListener implements ChangeListener {

	public PanelPrincipalChangeListener(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Integer selectedIndex = panelPrincipal.getJTabbedPane1().getSelectedIndex();
		LogWrapper.debug(log, "Está en %s", panelPrincipal.getJTabbedPane1().getTitleAt(selectedIndex));
	}
}
