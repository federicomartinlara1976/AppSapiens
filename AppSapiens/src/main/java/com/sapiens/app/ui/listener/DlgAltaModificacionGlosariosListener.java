package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.glosarios.DlgAltaModificacionGlosarios;
import com.sapiens.app.utils.Constants;

public class DlgAltaModificacionGlosariosListener implements ActionListener {

	private DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios;

	public DlgAltaModificacionGlosariosListener(DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios) {
		super();
		this.dlgAltaModificacionGlosarios = dlgAltaModificacionGlosarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR.equals(jButton.getName())) {
			dlgAltaModificacionGlosarios.dispose();
		}
	}
	
	private void eventBtnAlta() {
		// TODO Auto-generated method stub
		
	}

	
}
