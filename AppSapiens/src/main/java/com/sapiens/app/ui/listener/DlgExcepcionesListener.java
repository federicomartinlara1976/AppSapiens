package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.sapiens.app.utils.Constants;

import lombok.extern.log4j.Log4j;

@Log4j
public class DlgExcepcionesListener implements ActionListener {

	private JDialog jDialog;

	public DlgExcepcionesListener(JDialog jDialog) {
		super();
		this.jDialog = jDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_EXCEPCIONES_BTN_CANCELAR.equals(jButton.getName())) {
			jDialog.dispose();
		}
	}

}
