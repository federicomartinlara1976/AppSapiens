package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.bussiness.service.ExcelGeneratorService;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.glosarios.FrmGlosarioCampos;
import com.mdval.ui.model.DefinicionCamposGlosarioTableCamposModel;
import com.mdval.ui.model.DefinicionCamposGlosarioTableModelosModel;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.utils.observer.Observable;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.AppHelper;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmGlosarioCamposListener extends ListenerSupport implements ActionListener, Observer {

	private FrmGlosarioCampos frmGlosarioCampos;

	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmGlosarioCamposListener(FrmGlosarioCampos frmGlosarioCampos) {
		super();
		this.frmGlosarioCampos = frmGlosarioCampos;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_GLOSARIO_CAMPOS_BTN_BUSCAR_GLOSARIO.equals(jButton.getActionCommand())) {
			eventBtnBuscarGlosario();
		}

		if (Constants.FRM_GLOSARIO_CAMPOS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (Constants.FRM_GLOSARIO_CAMPOS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_GLOSARIO_CAMPOS_BTN_BAJA.equals(jButton.getActionCommand())) {
			eventBtnBaja();
		}

		if (Constants.FRM_GLOSARIO_CAMPOS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			eventBtnModificacion();
		}

		if (Constants.FRM_GLOSARIO_CAMPOS_BTN_IMPRIMIR.equals(jButton.getActionCommand())) {
			eventBtnImprimir();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscarGlosario() {
		frmDefinicionGlosarios = (FrmDefinicionGlosarios) UIHelper.createFrame(Constants.MNU_DEF_GLOSARIOS);
		UIHelper.show(frmDefinicionGlosarios);

		frmDefinicionGlosarios.getFrmDefinicionGlosariosListener().addObservador(this);
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			String sCodGlosario = frmGlosarioCampos.getTxtCodigoGlosario().getText();
			BigDecimal codGlosario = AppHelper.toBigDecimal(sCodGlosario, literales.getLiteral("codigoGlosario.error"));
			
			String tipoDato = (String) frmGlosarioCampos.getCmbTipoDato().getSelectedItem();
			String nombreColumna = frmGlosarioCampos.getTxtNombreColumna().getText();
			String vMostrarExcepciones = (String) frmGlosarioCampos.getCmbMostrarExcepciones().getSelectedItem();

			String mcaException = AppHelper.normalizeCmbSiNoValue(vMostrarExcepciones);

			List<CampoGlosario> campos = buscarCampos(codGlosario, tipoDato, nombreColumna, mcaException);
			populateModelCampos(campos);

			List<Modelo> modelos = buscarModelos(codGlosario);
			populateModelModelos(modelos);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmGlosarioCampos, Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_GLOSARIO_CAMPOS_GLOSARIO_SELECCIONADO, frmGlosarioCampos.getGlosarioSeleccionado());

		showPopup(frmGlosarioCampos, Constants.CMD_ALTA_GLOSARIO_CAMPOS, params);
	}

	/**
	 * 
	 */
	private void eventBtnBaja() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_GLOSARIO_CAMPOS_CAMPO_SELECCIONADO, frmGlosarioCampos.getCampoSeleccionado());

		showPopup(frmGlosarioCampos, Constants.CMD_BAJA_GLOSARIO_CAMPOS, params);
	}

	/**
	 * 
	 */
	private void eventBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_GLOSARIO_CAMPOS_CAMPO_SELECCIONADO, frmGlosarioCampos.getCampoSeleccionado());
		params.put(Constants.FRM_GLOSARIO_CAMPOS_GLOSARIO_SELECCIONADO, frmGlosarioCampos.getGlosarioSeleccionado());

		showPopup(frmGlosarioCampos, Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS, params);
	}

	/**
	 * 
	 */
	private void eventBtnImprimir() {
		// En este punto preguntar la ruta con el componente específico de
		// selección de carpeta.
		String path = UIHelper.selectFolder(frmGlosarioCampos);

		if (StringUtils.isNotBlank(path)) {
			ExcelGeneratorService excelGeneratorService = (ExcelGeneratorService) getService(
					Constants.EXCEL_GENERATOR_SERVICE);

			String codigoGlosario = frmGlosarioCampos.getTxtCodigoGlosario().getText();
			String nombreGlosario = frmGlosarioCampos.getTxtGlosario().getText();
			DefinicionCamposGlosarioTableCamposModel tableModel = (DefinicionCamposGlosarioTableCamposModel) frmGlosarioCampos
					.getTblCampos().getModel();
			List<CampoGlosario> campos = tableModel.getData();

			excelGeneratorService.generarExcelGlosarioCampoModelo(campos, path, codigoGlosario, nombreGlosario);
		}
	}

	/**
	 * Busca campos de un glosario según los criterios especificados
	 * 
	 * @param codigoGlosario
	 * @param tipoDato
	 * @param nombreColumna
	 * @param mostrarExcepciones
	 * @return
	 */
	private List<CampoGlosario> buscarCampos(BigDecimal codigoGlosario, String tipoDato, String nombreColumna,
			String mostrarExcepciones) {
		CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
				Constants.CAMPOS_GLOSARIO_SERVICE);
		List<CampoGlosario> campos = camposGlosarioService.consultarCamposGlosario(codigoGlosario, tipoDato,
				nombreColumna, mostrarExcepciones);
		return campos;
	}

	/**
	 * Busca modelos de un glosario
	 * 
	 * @param codigoGlosario
	 * @return
	 */
	private List<Modelo> buscarModelos(BigDecimal codigoGlosario) {
		CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
				Constants.CAMPOS_GLOSARIO_SERVICE);
		List<Modelo> modelos = camposGlosarioService.consultarModelosGlosario(codigoGlosario);
		return modelos;
	}

	/**
	 * Vuelca la lista de campos encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModelCampos(List<CampoGlosario> campos) {
		// Obtiene el modelo y lo actualiza
		DefinicionCamposGlosarioTableCamposModel tableModel = (DefinicionCamposGlosarioTableCamposModel) frmGlosarioCampos
				.getTblCampos().getModel();
		tableModel.setData(campos);

		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmGlosarioCampos.getBtnBaja().setEnabled(Boolean.FALSE);
		frmGlosarioCampos.getBtnModificacion().setEnabled(Boolean.FALSE);
		frmGlosarioCampos.getBtnImprimir().setEnabled(Boolean.TRUE);
	}

	/**
	 * Vuelca la lista de campos encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModelModelos(List<Modelo> modelos) {
		// Obtiene el modelo y lo actualiza
		DefinicionCamposGlosarioTableModelosModel tableModel = (DefinicionCamposGlosarioTableModelosModel) frmGlosarioCampos
				.getTblModelos().getModel();
		tableModel.setData(modelos);
	}

	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;

		if (Constants.FRM_DEFINICION_GLOSARIOS_BTN_SELECCIONAR.equals(cmd)) {
			if (!Objects.isNull(frmDefinicionGlosarios.getSeleccionado())) {
				frmGlosarioCampos.setGlosarioSeleccionado(frmDefinicionGlosarios.getSeleccionado());
				frmGlosarioCampos.getTxtCodigoGlosario().setText(
						frmDefinicionGlosarios.getSeleccionado().getCodigoGlosario().toBigInteger().toString());
				frmGlosarioCampos.getTxtGlosario()
						.setText(frmDefinicionGlosarios.getSeleccionado().getDescripcionGlosario());
				frmGlosarioCampos.getBtnBuscar().setEnabled(Boolean.TRUE);
				frmGlosarioCampos.getBtnAlta().setEnabled(Boolean.TRUE);

				// Limpiar las dos tablas al cambiar de glosario
				DefinicionCamposGlosarioTableCamposModel tableModelCampos = (DefinicionCamposGlosarioTableCamposModel) frmGlosarioCampos
						.getTblCampos().getModel();
				DefinicionCamposGlosarioTableModelosModel tableModelModelos = (DefinicionCamposGlosarioTableModelosModel) frmGlosarioCampos
						.getTblModelos().getModel();

				tableModelCampos.clearData();
				tableModelModelos.clearData();
				
				// Limpiar el combo de selección de tipo y el de nombre de columna
				frmGlosarioCampos.getCmbTipoDato().setSelectedItem(StringUtils.EMPTY);
				frmGlosarioCampos.getTxtNombreColumna().setText(StringUtils.EMPTY);
			}
		}

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR.equals(cmd)) {
			eventBtnBuscar();
		}

		if (Constants.DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR.equals(cmd)) {
			eventBtnBuscar();
		}
	}
}
