package com.sapiens.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.mdval.ui.glosarios.DlgBajaGlosarioCampos;
import com.sapiens.mdval.ui.utils.ListenerSupport;
import com.sapiens.mdval.utils.Constants;

public class DlgBajaGlosarioCamposListener extends ListenerSupport implements ActionListener {

	private DlgBajaGlosarioCampos dlgBajaGlosario;

	public DlgBajaGlosarioCamposListener(DlgBajaGlosarioCampos dlgBajaGlosario) {
		super();
		this.dlgBajaGlosario = dlgBajaGlosario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_BAJA_GLOSARIO_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAceptar();
		}

		if (Constants.DLG_BAJA_GLOSARIO_BTN_CANCELAR.equals(jButton.getName())) {
			dlgBajaGlosario.dispose();
		}
	}

	private void eventBtnAceptar() {
		// TODO Auto-generated method stub
		
	}

}
