package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.ui.glosarios.DlgBajaGlosarioCampos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.MDValConstants;

public class DlgBajaGlosarioCamposListener extends ListenerSupport implements ActionListener {

	private DlgBajaGlosarioCampos dlgBajaGlosario;

	public DlgBajaGlosarioCamposListener(DlgBajaGlosarioCampos dlgBajaGlosario) {
		super();
		this.dlgBajaGlosario = dlgBajaGlosario;
	}
	
	/**
	 * @param o
	 */
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (MDValConstants.DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}

		if (MDValConstants.DLG_BAJA_CAMPO_GLOSARIO_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgBajaGlosario.dispose();
		}
	}

	private void eventBtnAceptar() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
					MDValConstants.CAMPOS_GLOSARIO_SERVICE);
			
						String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se va a borrar un registro existente
				String codUsuario = (String) appGlobalSingleton.getProperty(MDValConstants.COD_USR);
				CampoGlosario campoGlosario = dlgBajaGlosario.getCampoSeleccionado();
				
				String rf = dlgBajaGlosario.getTxtRF().getText();
				String sd = dlgBajaGlosario.getTxtSD().getText();
				String comentario = dlgBajaGlosario.getTxtComentario().getText();
				
				camposGlosarioService.bajaCampoGlosario(campoGlosario, rf, sd, comentario, codUsuario);

				msg = literales.getLiteral("mensaje.borrar");
				JOptionPane.showMessageDialog(dlgBajaGlosario.getParent(), msg);

				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers(MDValConstants.DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR);
				dlgBajaGlosario.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgBajaGlosario.getFrameParent(), MDValConstants.CMD_ERROR, params);
		}
	}

}
