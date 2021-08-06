package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.validacionscripts.DlgExcepciones;
import com.sapiens.app.utils.Constants;

public class DlgExcepcionesListener implements ActionListener {

	private DlgExcepciones dlgExcepciones;

	public DlgExcepcionesListener(DlgExcepciones dlgExcepciones) {
		super();
		this.dlgExcepciones = dlgExcepciones;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_EXCEPCIONES_BTN_CANCELAR.equals(jButton.getName())) {
			dlgExcepciones.dispose();
		}
	}

}
