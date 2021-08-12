package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.sapiens.app.ui.glosarios.DlgDefinicionGlosarios;
import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.utils.Constants;

public class DlgDefinicionGlosariosListener extends ListenerSupport implements ActionListener {

	private DlgDefinicionGlosarios dlgDefinicionGlosarios;

	public DlgDefinicionGlosariosListener(DlgDefinicionGlosarios dlgDefinicionGlosarios) {
		super();
		this.dlgDefinicionGlosarios = dlgDefinicionGlosarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_MODIFICACION.equals(jButton.getName())) {
			evntBtnModificacion();
		}

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_SELECCIONAR.equals(jButton.getName())) {
			eventBtnSeleccionar();
		}
	}

	private void eventBtnAlta() {
		JDialog dialog = UIHelper.createDialog(dlgDefinicionGlosarios.getFrameParent(),
				Constants.CMD_ALTA_GLOSARIOS);
		UIHelper.showDialog(dialog);

	}

	private void evntBtnModificacion() {
		JDialog dialog = UIHelper.createDialog(dlgDefinicionGlosarios.getFrameParent(),
				Constants.CMD_MODIFICACION_GLOSARIOS);
		UIHelper.showDialog(dialog);
	}

	private void eventBtnSeleccionar() {
		// TODO Auto-generated method stub

	}
}