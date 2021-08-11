package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.sapiens.app.ui.glosarios.DlgDefinicionGlosarios;
import com.sapiens.app.ui.glosarios.DlgGlosarioCampos;
import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.utils.Constants;

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
