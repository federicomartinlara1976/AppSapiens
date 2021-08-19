package com.sapiens.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.mdval.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.sapiens.mdval.ui.utils.ListenerSupport;
import com.sapiens.mdval.utils.Constants;

public class FrmDefinicionTiposParticulaListener extends ListenerSupport implements ActionListener {

	private FrmDefinicionTiposParticula frmDefinicionTiposParticula;

	public FrmDefinicionTiposParticulaListener(FrmDefinicionTiposParticula frmDefinicionTiposParticula) {
		super();
		this.frmDefinicionTiposParticula = frmDefinicionTiposParticula;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_DEFINICION_TIPOS_PARTICULA_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_DEFINICION_TIPOS_PARTICULA_BTN_MODIFICACION.equals(jButton.getName())) {
			evntBtnModificacion();
		}
	}

	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_TIPOS_PARTICULA);
	}

	private void evntBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_TIPOS_PARTICULA);
	}
}
