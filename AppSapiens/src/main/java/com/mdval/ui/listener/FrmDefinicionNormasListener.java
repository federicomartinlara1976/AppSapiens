package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdval.ui.normasnomenclatura.FrmDefinicionNormas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

public class FrmDefinicionNormasListener extends ListenerSupport implements ActionListener {

	private FrmDefinicionNormas frmDefinicionNormas;

	public FrmDefinicionNormasListener(FrmDefinicionNormas frmDefinicionNormas) {
		super();
		this.frmDefinicionNormas = frmDefinicionNormas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_DEFINICION_NORMAS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_DEFINICION_NORMAS_BTN_MODIFICACION.equals(jButton.getName())) {
			evntBtnModificacion();
		}
	}

	private void eventBtnAlta() {
		showPopup(frmDefinicionNormas, Constants.CMD_ALTA_NORMAS);
	}

	private void evntBtnModificacion() {
		showPopup(frmDefinicionNormas, Constants.CMD_MODIFICACION_NORMAS);
	}
}