package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.sapiens.app.ui.glosarios.DlgDefinicionGlosarios;
import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.ui.utils.dialog.Creator;
import com.sapiens.app.ui.utils.dialog.DialogCreator;
import com.sapiens.app.utils.Constants;

public class DlgDefinicionGlosariosListener implements ActionListener {

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
		JDialog dialog = createDialog(Constants.CMD_ALTA_GLOSARIOS);
		
		showDialog(dialog);
		
	}
	
	private void evntBtnModificacion() {
		JDialog dialog = createDialog(Constants.CMD_MODIFICACION_GLOSARIOS);
		
		showDialog(dialog);
	}

	private void eventBtnSeleccionar() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param item
	 * @return
	 */
	private JDialog createDialog(String item) {
		Creator dialogCreator = new DialogCreator(dlgDefinicionGlosarios.getFrameParent(), item);
		return dialogCreator.factoryMethod();
	}
	
	/**
	 * @param dialog
	 */
	private void showDialog(JDialog dialog) {
		if (!Objects.isNull(dialog)) {
			UIHelper.centerOnScreen(dialog);
			dialog.setVisible(true);
		}
	}
}
