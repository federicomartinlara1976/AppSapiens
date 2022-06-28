package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.ui.glosarios.DlgAltaModificacionCampos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.AppHelper;
import com.mdval.utils.MDValConstants;

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

		if (MDValConstants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (MDValConstants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionCampos.dispose();
		}
	}

	private void eventBtnAlta() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
					MDValConstants.CAMPOS_GLOSARIO_SERVICE);
			Glosario glosarioSeleccionado = dlgAltaModificacionCampos.getGlosarioSeleccionado();
			String codUsuario = (String) appGlobalSingleton.getProperty(MDValConstants.COD_USR);

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
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers(MDValConstants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR);
				dlgAltaModificacionCampos.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgAltaModificacionCampos.getFrameParent(), MDValConstants.CMD_ERROR, params);
		}
	}

}
