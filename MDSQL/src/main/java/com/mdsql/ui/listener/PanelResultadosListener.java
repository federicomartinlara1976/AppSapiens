package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.DetValidacion;
import com.mdsql.bussiness.entities.InformeValidacion;
import com.mdsql.bussiness.entities.ValidaScriptResponse;
import com.mdsql.bussiness.service.ExcelGeneratorService;
import com.mdsql.bussiness.service.ValidacionService;
import com.mdsql.ui.model.DetalleValidacionTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.ui.validacionscripts.DlgExcepciones;
import com.mdsql.ui.validacionscripts.PanelResultados;
import com.mdsql.utils.AppGlobalSingleton;
import com.mdsql.utils.Constants;

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

			insertarEnGlosario(detalles, Boolean.FALSE);
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

			insertarEnGlosario(detalles, Boolean.TRUE);
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
				informeValidacion.setRf(rf);
				informeValidacion.setSd(sd);
				
				excelGeneratorService.generarExcelValidacionNomenclatura(informeValidacion, path);
			}

		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelResultados.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * @param detalles
	 * @param todos
	 */
	private void insertarEnGlosario(List<DetValidacion> detalles, Boolean todos) {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			String usuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (!todos) {
					for (DetValidacion det : detalles) {
						validacionService.insertarGlosario(det.getNumeroValidacion(), det.getNumeroElementoValid(),
								usuario);
					}
				}
				else {
					// Esto debe ser una única llamada al procedimiento, para añadir todos,
					// numeroElemento deberá ser 0
					validacionService.insertarGlosario(detalles.get(0).getNumeroValidacion(), BigDecimal.ZERO,
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
	public void cargarElementosNoGlosario() {
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelResultados.getPanelPrincipal().getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosNoGlosarioValidacion(response.getNumeroValidacion());
			model.setData(detalles);
			panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
			
			if (CollectionUtils.isNotEmpty(detalles)) {
				panelResultados.getBtnAddTodosGlosario().setEnabled(Boolean.TRUE);
			}
		}
	}
	
	/**
	 * 
	 */
	public void cargarElementosErrores() {
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelResultados.getPanelPrincipal().getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosConErroresValidacion(response.getNumeroValidacion());
			model.setData(detalles);
			panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
			panelResultados.getBtnMarcarExcepcion().setEnabled(Boolean.FALSE);
		}
	}
	
	/**
	 * 
	 */
	public void cargarExcepciones() {
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelResultados.getPanelPrincipal().getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosExcepcionesValidacion(response.getNumeroValidacion());
			model.setData(detalles);
			panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
		}
	}

	/**
	 * 
	 */
	public void cargarElementosCorrectos() {
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
	
		ValidaScriptResponse response = panelResultados.getPanelPrincipal().getResponse();
		if (!Objects.isNull(response)) {
			List<DetValidacion> detalles = validacionService.consultaElementosCorrectosValidacion(response.getNumeroValidacion());
			model.setData(detalles);
			panelResultados.getBtnGenerarLog().setEnabled(Boolean.TRUE);
		}
	}
}
