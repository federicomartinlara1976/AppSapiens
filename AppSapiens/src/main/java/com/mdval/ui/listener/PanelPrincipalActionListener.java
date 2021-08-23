package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdval.ui.validacionscripts.PanelPrincipal;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class PanelPrincipalActionListener extends PanelPrincipalListener implements ActionListener {
	
	public PanelPrincipalActionListener(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_TODO.equals(jButton.getActionCommand())) {
			eventBtnLimpiarTodo();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION.equals(jButton.getActionCommand())) {
			eventBtnLimpiarValidacion();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_LOAD_SCRIPT.equals(jButton.getActionCommand())) {
			eventBtnLoadScript();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_VALIDAR.equals(jButton.getActionCommand())) {
			eventBtnValidar();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_SEARCH.equals(jButton.getActionCommand())) {
			eventBtnSearch();
		}
	}
	
	private void eventBtnLimpiarTodo() {
		LogWrapper.debug(log, "Click boton limpiar todo");
	}

	private void eventBtnLimpiarValidacion() {
		LogWrapper.debug(log, "Click boton limpiar validacion");
	}

	private void eventBtnLoadScript() {
		LogWrapper.debug(log, "Click boton cargar script");
	}

	private void eventBtnValidar() {
		LogWrapper.debug(log, "Click boton validar");
	}

	private void eventBtnSearch() {
		LogWrapper.debug(log, "Click boton buscar");
	}
}
