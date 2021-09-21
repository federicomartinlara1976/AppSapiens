package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.bussiness.service.ValidacionService;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.validacionscripts.PanelResultados;
import com.mdval.utils.Constants;

public class PanelResultadosListener extends ListenerSupport implements ActionListener, Observer {

	private PanelResultados panelResultados;

	private ValidacionService validacionService;

	public PanelResultadosListener(PanelResultados panelResultados) {
		this.panelResultados = panelResultados;
		validacionService = (ValidacionService) getService(Constants.VALIDACION_SERVICE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANEL_RESULTADOS_BTN_MARCAR_EXCEPCION.equals(jButton.getActionCommand())) {
			eventBtnMarcarExcepcion();
		}

		if (Constants.PANEL_RESULTADOS_BTN_ADD_GLOSARIO.equals(jButton.getActionCommand())) {
			eventBtnAddGlosario();
		}

		if (Constants.PANEL_RESULTADOS_BTN_ADD_TODOS_GLOSARIO.equals(jButton.getActionCommand())) {
			eventBtnAddTodos();
		}

		if (Constants.PANEL_RESULTADOS_BTN_GENERAR_LOG.equals(jButton.getActionCommand())) {
			eventBtnGenerarLog();
		}
	}

	private void eventBtnMarcarExcepcion() {
		// TODO Auto-generated method stub

	}

	private void eventBtnAddGlosario() {
		// TODO Auto-generated method stub

	}

	private void eventBtnAddTodos() {
		// TODO Auto-generated method stub

	}

	private void eventBtnGenerarLog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param detValidacion
	 * @param codUsr
	 */
	private void insertarEnGlosario(DetValidacion detValidacion, String codUsr) {
		validacionService.insertarGlosario(detValidacion.getNumeroValidacion(), detValidacion.getNumeroElementoValid(),
				codUsr);
	}

	/**
	 * @param detValidacion
	 * @param codUsr
	 */
	private void insertarExcepcion(DetValidacion detValidacion, String codUsr) {
		validacionService.insertarExcepcion(detValidacion.getNumeroValidacion(), detValidacion.getNumeroElementoValid(),
				detValidacion.getTxtDescripcionValid(), codUsr);
	}
}
