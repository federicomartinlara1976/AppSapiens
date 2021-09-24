package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.bussiness.entities.InformeValidacion;
import com.mdval.bussiness.entities.ValidaScriptResponse;
import com.mdval.bussiness.service.ExcelGeneratorService;
import com.mdval.bussiness.service.ValidacionService;
import com.mdval.ui.model.DetalleValidacionTableModel;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.validacionscripts.DlgExcepciones;
import com.mdval.ui.validacionscripts.PanelResultados;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.Constants;

public class PanelResultadosListener extends ListenerSupport implements ActionListener {

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

	/**
	 * 
	 */
	private void eventBtnMarcarExcepcion() {
		try {
			DetValidacion seleccionado = panelResultados.getSeleccionado();

			DlgExcepciones dlg = new DlgExcepciones(panelResultados.getFrameParent(), Boolean.TRUE);
			UIHelper.centerOnScreen(dlg);
			dlg.setVisible(Boolean.TRUE);

			String excepcion = dlg.getTxtComentario().getText();
			if (StringUtils.isNotBlank(excepcion)) {
				insertarExcepcion(seleccionado, excepcion);
				cargarElementosErrores();
			}

		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelResultados.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAddGlosario() {
		try {
			DetValidacion seleccionado = panelResultados.getSeleccionado();

			List<DetValidacion> detalles = new ArrayList<>();
			detalles.add(seleccionado);

			insertarEnGlosario(detalles);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelResultados.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	private void eventBtnAddTodos() {
		try {
			DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados()
					.getModel();
			List<DetValidacion> detalles = model.getData();

			insertarEnGlosario(detalles);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelResultados.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnGenerarLog() {
		try {
			// En este punto preguntar la ruta con el componente específico de
			// selección de carpeta.
			String path = UIHelper.selectFolder(panelResultados.getFrameParent());

			if (StringUtils.isNotBlank(path)) {
				ExcelGeneratorService excelGeneratorService = (ExcelGeneratorService) getService(
						Constants.EXCEL_GENERATOR_SERVICE);

				ValidacionService validacionService = (ValidacionService) getService(Constants.VALIDACION_SERVICE);

				// Coge el número de validación del response y RF y SD del panel principal
				ValidaScriptResponse response = panelResultados.getPanelPrincipal().getResponse();
				BigDecimal numeroValidacion = response.getNumeroValidacion();
				
				String rf = panelResultados.getPanelPrincipal().getRequest().getCodigoRF();
				String sd = panelResultados.getPanelPrincipal().getRequest().getCodigoSD();
				
				InformeValidacion informeValidacion = validacionService.generarInformeValidacion(numeroValidacion);
				informeValidacion.setRF(rf);
				informeValidacion.setSD(sd);
				
				excelGeneratorService.generarExcelValidacionNomenclatura(informeValidacion, path);
			}

		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelResultados.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * @param detValidacion
	 * @param codUsr
	 */
	private void insertarEnGlosario(List<DetValidacion> detalles) {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			String usuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				for (DetValidacion det : detalles) {
					validacionService.insertarGlosario(det.getNumeroValidacion(), det.getNumeroElementoValid(),
							usuario);
				}

				String msg = literales.getLiteral("mensaje.guardar");

				JOptionPane.showMessageDialog(panelResultados.getParent(), msg);

				cargarElementosNoGlosario();

			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelResultados.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * @param detValidacion
	 * @param excepcion
	 */
	private void insertarExcepcion(DetValidacion detValidacion, String excepcion) {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			String usuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				validacionService.insertarExcepcion(detValidacion.getNumeroValidacion(),
						detValidacion.getNumeroElementoValid(), excepcion, usuario);

				String msg = literales.getLiteral("mensaje.guardar");

				JOptionPane.showMessageDialog(panelResultados.getParent(), msg);

				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers(Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR);

			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelResultados.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
	
	/**
	 * 
	 */
	private void cargarElementosNoGlosario() {
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelResultados.getPanelPrincipal().getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosNoGlosarioValidacion(response.getNumeroValidacion());
			model.setData(detalles);
			panelResultados.getBtnAddTodosGlosario().setEnabled(Boolean.FALSE);
			panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
		}
	}
	
	/**
	 * 
	 */
	private void cargarElementosErrores() {
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelResultados.getPanelPrincipal().getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosConErroresValidacion(response.getNumeroValidacion());
			model.setData(detalles);
			panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
		}
	}
}
