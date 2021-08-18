package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.utils.ListenerSupport;
import com.sapiens.app.ui.validacionscripts.DlgExcepciones;
import com.sapiens.app.utils.Constants;

/**
 * @author federico
 *
 */
public class DlgExcepcionesListener extends ListenerSupport implements ActionListener {

	private DlgExcepciones dlgExcepciones;

	public DlgExcepcionesListener(DlgExcepciones dlgExcepciones) {
		super();
		this.dlgExcepciones = dlgExcepciones;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.DLG_EXCEPCIONES_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAceptar();
		}

		if (Constants.DLG_EXCEPCIONES_BTN_CANCELAR.equals(jButton.getName())) {
			dlgExcepciones.dispose();
		}
	}

	/**
	 * 
	 */
	private void eventBtnAceptar() {
		// TODO Auto-generated method stub
		
	}

}
