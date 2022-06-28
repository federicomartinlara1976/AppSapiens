package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.validacionscripts.DlgExcepciones;
import com.mdval.utils.MDValConstants;

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
		
		if (MDValConstants.DLG_EXCEPCIONES_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			dlgExcepciones.dispose();
		}

		if (MDValConstants.DLG_EXCEPCIONES_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgExcepciones.getTxtComentario().setText(StringUtils.EMPTY);
			dlgExcepciones.dispose();
		}
	}
}
