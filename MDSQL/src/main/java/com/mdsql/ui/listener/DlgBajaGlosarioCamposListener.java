package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.CampoGlosario;
import com.mdsql.bussiness.service.CamposGlosarioService;
import com.mdsql.ui.glosarios.DlgBajaGlosarioCampos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.utils.AppGlobalSingleton;
import com.mdsql.utils.Constants;

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

		if (Constants.DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}

		if (Constants.DLG_BAJA_CAMPO_GLOSARIO_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgBajaGlosario.dispose();
		}
	}

	private void eventBtnAceptar() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
					Constants.CAMPOS_GLOSARIO_SERVICE);
			
						String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se va a borrar un registro existente
				String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
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
				updateObservers(Constants.DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR);
				dlgBajaGlosario.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgBajaGlosario.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

}
