package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.CampoGlosario;
import com.mdsql.bussiness.entities.Glosario;
import com.mdsql.bussiness.service.CamposGlosarioService;
import com.mdsql.ui.glosarios.DlgAltaModificacionCampos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.utils.AppGlobalSingleton;
import com.mdsql.utils.AppHelper;
import com.mdsql.utils.Constants;

public class DlgAltaModificacionCamposListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionCampos dlgAltaModificacionCampos;

	public DlgAltaModificacionCamposListener(DlgAltaModificacionCampos dlgAltaModificacionCampos) {
		super();
		this.dlgAltaModificacionCampos = dlgAltaModificacionCampos;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionCampos.dispose();
		}
	}

	private void eventBtnAlta() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
					Constants.CAMPOS_GLOSARIO_SERVICE);
			Glosario glosarioSeleccionado = dlgAltaModificacionCampos.getGlosarioSeleccionado();
			String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);

			CampoGlosario oldCampoGlosario = dlgAltaModificacionCampos.getCampoGlosarioSeleccionado();
			CampoGlosario newCampoGlosario = new CampoGlosario();

			newCampoGlosario.setCodigoGlosario(glosarioSeleccionado.getCodigoGlosario());
			newCampoGlosario.setNombreColumna(dlgAltaModificacionCampos.getTxtNombre().getText());
			newCampoGlosario.setTipoDato((String) dlgAltaModificacionCampos.getCmbTipoDato().getSelectedItem());
			
			String sNumeroLongitud = dlgAltaModificacionCampos.getTxtTamanio().getText();
			BigDecimal bLongitud = AppHelper.toBigDecimal(sNumeroLongitud, literales.getLiteral("tam.error"));
			
			String sDecimales = dlgAltaModificacionCampos.getTxtDecimales().getText();
			BigDecimal bDecimales = AppHelper.toBigDecimal(sDecimales, literales.getLiteral("decimales.error"));
			
			newCampoGlosario.setNumeroLongitud(bLongitud);
			newCampoGlosario.setNumeroDecimal(bDecimales);

			String mcaException = AppHelper.normalizeCmbSiNoValue(((String) dlgAltaModificacionCampos.getCmbExcepcion().getSelectedItem()));

			newCampoGlosario.setMcaExcepcion(mcaException);
			newCampoGlosario.setTxtComentario(dlgAltaModificacionCampos.getTxtObservaciones().getText());
			newCampoGlosario.setTxtExcepcion(dlgAltaModificacionCampos.getTxtDescripcionExcepcion().getText());
			newCampoGlosario.setCodigoUsuario(codUsuario);

			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (dlgAltaModificacionCampos.getEditar()) {
					camposGlosarioService.modificarCampoGlosario(oldCampoGlosario, newCampoGlosario);

					msg = literales.getLiteral("mensaje.guardar");
				} else {
					camposGlosarioService.altaCampoGlosario(newCampoGlosario);

					msg = literales.getLiteral("mensaje.crear");
				}

				JOptionPane.showMessageDialog(dlgAltaModificacionCampos.getParent(), msg);

				/**
				 * En este punto invocar un m??todo que informe a los observadores del patr??n
				 * observer para que invoquen a su m??todo de actualizaci??n
				 */
				updateObservers(Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR);
				dlgAltaModificacionCampos.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgAltaModificacionCampos.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

}
