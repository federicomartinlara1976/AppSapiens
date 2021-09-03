package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JButton;

import com.mdval.ui.normasnomenclatura.DlgModificacionNormas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
public class DlgModificacionNormasListener extends ListenerSupport implements ActionListener {

	private DlgModificacionNormas dlgModificacionNormas;

	public DlgModificacionNormasListener(DlgModificacionNormas dlgModificacionNormas) {
		super();
		this.dlgModificacionNormas = dlgModificacionNormas;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.DLG_MODIFICACION_NORMAS_BTN_ALTA_ELEMENTO.equals(jButton.getActionCommand())) {
			
		}

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_BAJA_ELEMENTO.equals(jButton.getActionCommand())) {
			
		}
		
		if (Constants.DLG_MODIFICACION_NORMAS_BTN_MODIFICACION_ELEMENTO.equals(jButton.getActionCommand())) {
			
		}

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgModificacionNormas.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		dlgModificacionNormas.dispose();
	}
}
