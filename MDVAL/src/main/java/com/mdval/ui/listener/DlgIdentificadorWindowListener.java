package com.mdval.ui.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.mdval.ui.DlgIdentificador;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DlgIdentificadorWindowListener implements WindowListener {

	private DlgIdentificador dlgIdentificador;

	public DlgIdentificadorWindowListener(DlgIdentificador dlgIdentificador) {
		super();
		this.dlgIdentificador = dlgIdentificador;
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {
		if (dlgIdentificador.getIsTerminate()) {
			LogWrapper.debug(log, "Terminate app");
			System.exit(0);
		}
	}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
