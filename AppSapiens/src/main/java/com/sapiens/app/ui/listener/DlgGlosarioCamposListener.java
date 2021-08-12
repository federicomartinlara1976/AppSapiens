package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.glosarios.DlgGlosarioCampos;

public class DlgGlosarioCamposListener extends ListenerSupport implements ActionListener {

	private DlgGlosarioCampos dlgGlosarioCampos;

	public DlgGlosarioCamposListener(DlgGlosarioCampos dlgGlosarioCampos) {
		super();
		this.dlgGlosarioCampos = dlgGlosarioCampos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		
	}
}
