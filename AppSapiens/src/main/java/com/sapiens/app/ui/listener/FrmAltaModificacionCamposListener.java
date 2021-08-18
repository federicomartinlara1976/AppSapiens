package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.glosarios.FrmAltaModificacionCampos;
import com.sapiens.app.ui.utils.ListenerSupport;
import com.sapiens.app.utils.Constants;

public class FrmAltaModificacionCamposListener extends ListenerSupport implements ActionListener {

	private FrmAltaModificacionCampos frmAltaModificacionCampos;

	public FrmAltaModificacionCamposListener(FrmAltaModificacionCampos frmAltaModificacionCampos) {
		super();
		this.frmAltaModificacionCampos = frmAltaModificacionCampos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR.equals(jButton.getName())) {
			frmAltaModificacionCampos.dispose();
		}
	}

	private void eventBtnAlta() {
		
	}

}