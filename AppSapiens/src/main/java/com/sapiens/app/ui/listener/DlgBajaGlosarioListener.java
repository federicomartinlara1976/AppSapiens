package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.glosarios.DlgBajaGlosario;

public class DlgBajaGlosarioListener extends ListenerSupport implements ActionListener {

	private DlgBajaGlosario dlgBajaGlosario;

	public DlgBajaGlosarioListener(DlgBajaGlosario dlgBajaGlosario) {
		super();
		this.dlgBajaGlosario = dlgBajaGlosario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		
	}

}
