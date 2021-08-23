package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdval.ui.glosarios.DlgBajaGlosarioCampos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

public class DlgBajaGlosarioCamposListener extends ListenerSupport implements ActionListener {

	private DlgBajaGlosarioCampos dlgBajaGlosario;

	public DlgBajaGlosarioCamposListener(DlgBajaGlosarioCampos dlgBajaGlosario) {
		super();
		this.dlgBajaGlosario = dlgBajaGlosario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_BAJA_GLOSARIO_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}

		if (Constants.DLG_BAJA_GLOSARIO_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgBajaGlosario.dispose();
		}
	}

	private void eventBtnAceptar() {
		// TODO Auto-generated method stub
		
	}

}
