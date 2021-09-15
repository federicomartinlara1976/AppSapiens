package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;

import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.ui.model.SubProyectoComboBoxModel;
import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.validacionscripts.PanelPrincipal;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class PanelPrincipalActionListener extends PanelPrincipalListener implements ActionListener, Observer {
	
	private FrmDefinicionModelos frmDefinicionModelos;

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
		Map<String, Object> params = new HashMap<>();
		params.put("fromMenu", Boolean.FALSE);

		frmDefinicionModelos = (FrmDefinicionModelos) UIHelper.createFrame(Constants.CMD_BUSCAR_MODELOS, params);
		UIHelper.show(frmDefinicionModelos);

		frmDefinicionModelos.getFrmDefinicionModelosListener().addObservador(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;
		
		if (Constants.FRM_DEFINICION_MODELOS_BTN_SELECCIONAR.equals(cmd)) {
			Modelo seleccionado = frmDefinicionModelos.getSeleccionado();
			
			if (!Objects.isNull(seleccionado)) {
				panelPrincipal.getTxtModeloProyecto().setText(seleccionado.getCodigoProyecto());
				List<SubProyecto> subProyectos = seleccionado.getSubProyectos();
				
				if (CollectionUtils.isNotEmpty(subProyectos)) {
					SubProyectoComboBoxModel modelSubProyectos = new SubProyectoComboBoxModel(subProyectos);
					panelPrincipal.getCmbSubmodelo().setModel(modelSubProyectos);
				}
 			}
		}
	}
}
