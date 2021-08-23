package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

public class FrmDefinicionModelosListener extends ListenerSupport implements ActionListener {

	private FrmDefinicionModelos frmDefinicionModelos;

	public FrmDefinicionModelosListener(FrmDefinicionModelos frmDefinicionModelos) {
		super();
		this.frmDefinicionModelos = frmDefinicionModelos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_DEFINICION_MODELOS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.DLG_DEFINICION_MODELOS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			evntBtnModificacion();
		}
	}

	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_MODELOS);
	}

	private void evntBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_MODELOS);
	}
}
