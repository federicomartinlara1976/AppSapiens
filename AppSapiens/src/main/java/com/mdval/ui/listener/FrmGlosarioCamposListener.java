package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.glosarios.FrmGlosarioCampos;
import com.mdval.ui.model.DefinicionCamposGlosarioTableModel;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
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
			String tipoDato = (String) frmGlosarioCampos.getCmbTipoDato().getSelectedItem();
			String nombreColumna = frmGlosarioCampos.getTxtNombreColumna().getText();
			String mostrarExcepciones = (String) frmGlosarioCampos.getCmbMostrarExcepciones().getSelectedItem();

			Long codGlosario = Long.parseLong(sCodGlosario);
			BigDecimal bCodGlosario = new BigDecimal(codGlosario);

			List<CampoGlosario> campos = buscar(bCodGlosario, tipoDato, nombreColumna, mostrarExcepciones);
			populateModel(campos);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmGlosarioCampos, Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmGlosarioCampos, Constants.CMD_ALTA_GLOSARIO_CAMPOS);
	}

	/**
	 * 
	 */
	private void eventBtnBaja() {
		showPopup(frmGlosarioCampos, Constants.CMD_BAJA_GLOSARIO_CAMPOS);
	}

	/**
	 * 
	 */
	private void eventBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_GLOSARIO_CAMPOS_CAMPO_SELECCIONADO, frmGlosarioCampos.getCampoSeleccionado());

		showPopup(frmGlosarioCampos, Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS, params);
	}

	/**
	 * 
	 */
	private void eventBtnImprimir() {
		// TODO Auto-generated method stub

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
	private List<CampoGlosario> buscar(BigDecimal codigoGlosario, String tipoDato, String nombreColumna,
			String mostrarExcepciones) {
		CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
				Constants.CAMPOS_GLOSARIO_SERVICE);
		List<CampoGlosario> campos = camposGlosarioService.consultarCamposGlosario(codigoGlosario, tipoDato,
				nombreColumna, mostrarExcepciones);
		return campos;
	}

	/**
	 * Vuelca la lista de campos encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<CampoGlosario> campos) {
		// Obtiene el modelo y lo actualiza
		DefinicionCamposGlosarioTableModel tableModel = (DefinicionCamposGlosarioTableModel) frmGlosarioCampos
				.getTblCampos().getModel();
		tableModel.setData(campos);

		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmGlosarioCampos.getBtnBaja().setEnabled(Boolean.FALSE);
		frmGlosarioCampos.getBtnModificacion().setEnabled(Boolean.FALSE);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof FrmDefinicionGlosariosListener) {
			if (!Objects.isNull(frmDefinicionGlosarios.getSeleccionado())) {
				frmGlosarioCampos.getTxtCodigoGlosario().setText(
						frmDefinicionGlosarios.getSeleccionado().getCodigoGlosario().toBigInteger().toString());
				frmGlosarioCampos.getTxtGlosario()
						.setText(frmDefinicionGlosarios.getSeleccionado().getDescripcionGlosario());
				frmGlosarioCampos.getBtnBuscar().setEnabled(Boolean.TRUE);
			}
		}
	}
}
