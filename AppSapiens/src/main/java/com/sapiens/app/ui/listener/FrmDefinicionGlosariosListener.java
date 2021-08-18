package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.glosarios.FrmDefinicionGlosarios;
import com.sapiens.app.ui.utils.ListenerSupport;
import com.sapiens.app.utils.Constants;

public class FrmDefinicionGlosariosListener extends ListenerSupport implements ActionListener {

	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmDefinicionGlosariosListener(FrmDefinicionGlosarios frmDefinicionGlosarios) {
		super();
		this.frmDefinicionGlosarios = frmDefinicionGlosarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_MODIFICACION.equals(jButton.getName())) {
			evntBtnModificacion();
		}

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_SELECCIONAR.equals(jButton.getName())) {
			eventBtnSeleccionar();
		}
	}

	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_GLOSARIOS);
	}

	private void evntBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_GLOSARIOS);
	}

	private void eventBtnSeleccionar() {
		// TODO Auto-generated method stub

	}
}
