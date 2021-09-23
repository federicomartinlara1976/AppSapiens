package com.mdval.ui.listener;

import java.util.List;
import java.util.Objects;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.commons.collections.CollectionUtils;

import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.bussiness.entities.ValidaScriptResponse;
import com.mdval.bussiness.service.ValidacionService;
import com.mdval.ui.model.DetalleValidacionTableModel;
import com.mdval.ui.validacionscripts.PanelPrincipal;
import com.mdval.ui.validacionscripts.PanelResultados;
import com.mdval.utils.Constants;

public class PanelPrincipalChangeListener extends PanelPrincipalListener implements ChangeListener {
	
	private ValidacionService validacionService;

	public PanelPrincipalChangeListener(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
		
		validacionService = (ValidacionService) getService(Constants.VALIDACION_SERVICE);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Integer selectedIndex = panelPrincipal.getJTabbedPane1().getSelectedIndex();
		
		switch (selectedIndex) {
		case 0: break;
		case 1:
			cargarElementosCorrectos();
			break;
		case 2: 
			cargarElementosNoGlosario();
			break;
		case 3: 
			cargarElementosErrores();
			break;
		case 4: 
			cargarExcepciones();
			break;
		}
	}

	/**
	 * 
	 */
	private void cargarExcepciones() {
		PanelResultados panelResultados = panelPrincipal.getPanelExcepciones();
		panelResultados.reset();
		
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelPrincipal.getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosExcepcionesValidacion(response.getNumeroValidacion());
			if (CollectionUtils.isNotEmpty(detalles)) {
				model.setData(detalles);
				
				panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
			}
		}
	}

	/**
	 * 
	 */
	private void cargarElementosErrores() {
		PanelResultados panelResultados = panelPrincipal.getPanelConErrores();
		panelResultados.reset();
		
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelPrincipal.getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosConErroresValidacion(response.getNumeroValidacion());
			if (CollectionUtils.isNotEmpty(detalles)) {
				model.setData(detalles);
				
				panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
			}
		}
	}

	/**
	 * 
	 */
	private void cargarElementosNoGlosario() {
		PanelResultados panelResultados = panelPrincipal.getPanelNoEstanEnGlosario();
		panelResultados.reset();
		
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelPrincipal.getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosNoGlosarioValidacion(response.getNumeroValidacion());
			if (CollectionUtils.isNotEmpty(detalles)) {
				model.setData(detalles);
				panelResultados.getBtnAddTodosGlosario().setEnabled(Boolean.TRUE);
				
				panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
			}
		}
	}

	/**
	 * 
	 */
	private void cargarElementosCorrectos() {
		PanelResultados panelResultados = panelPrincipal.getPanelElementosCorrectos();
		panelResultados.reset();
		
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelPrincipal.getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosCorrectosValidacion(response.getNumeroValidacion());
			if (CollectionUtils.isNotEmpty(detalles)) {
				model.setData(detalles);
				
				panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
			}
		}
	}
}
