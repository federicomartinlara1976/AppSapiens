package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.sapiens.app.ui.validacionscripts.PanelPrincipal;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class PanelPrincipalActionListener extends PanelPrincipalListener implements ActionListener {
	
	public PanelPrincipalActionListener(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_TODO.equals(jButton.getName())) {
			eventBtnLimpiarTodo();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION.equals(jButton.getName())) {
			eventBtnLimpiarValidacion();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_LOAD_SCRIPT.equals(jButton.getName())) {
			eventBtnLoadScript();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_VALIDAR.equals(jButton.getName())) {
			eventBtnValidar();
		}
		
		if (Constants.PANEL_PRINCIPAL_BTN_SEARCH.equals(jButton.getName())) {
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
