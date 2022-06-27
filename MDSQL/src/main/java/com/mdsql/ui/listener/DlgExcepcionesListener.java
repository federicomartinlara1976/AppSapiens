package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.validacionscripts.DlgExcepciones;
import com.mdsql.utils.Constants;

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
		
		if (Constants.DLG_EXCEPCIONES_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			dlgExcepciones.dispose();
		}

		if (Constants.DLG_EXCEPCIONES_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgExcepciones.getTxtComentario().setText(StringUtils.EMPTY);
			dlgExcepciones.dispose();
		}
	}
}
