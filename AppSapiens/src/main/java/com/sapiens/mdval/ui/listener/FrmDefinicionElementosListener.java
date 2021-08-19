package com.sapiens.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.mdval.ui.normasnomenclatura.FrmDefinicionElementos;
import com.sapiens.mdval.ui.utils.ListenerSupport;
import com.sapiens.mdval.utils.Constants;

public class FrmDefinicionElementosListener extends ListenerSupport implements ActionListener {

	private FrmDefinicionElementos frmDefinicionElementos;

	public FrmDefinicionElementosListener(FrmDefinicionElementos frmDefinicionElementos) {
		super();
		this.frmDefinicionElementos = frmDefinicionElementos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_DEFINICION_ELEMENTOS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_DEFINICION_ELEMENTOS_BTN_MODIFICACION.equals(jButton.getName())) {
			evntBtnModificacion();
		}
	}

	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_ELEMENTOS);
	}

	private void evntBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_ELEMENTOS);
	}
}
