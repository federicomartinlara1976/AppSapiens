package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.normasnomenclatura.FrmValoresParticulas;
import com.sapiens.app.ui.utils.ListenerSupport;
import com.sapiens.app.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmValoresParticulasListener extends ListenerSupport implements ActionListener {

	private FrmValoresParticulas frmValoresParticulas;

	public FrmValoresParticulasListener(FrmValoresParticulas frmValoresParticulas) {
		super();
		this.frmValoresParticulas = frmValoresParticulas;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_VALORES_PARTICULAS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}
		
		if (Constants.DLG_VALORES_PARTICULAS_BTN_BAJA.equals(jButton.getName())) {
			eventBtnBaja();
		}
		
		if (Constants.DLG_VALORES_PARTICULAS_BTN_MODIFICACION.equals(jButton.getName())) {
			eventBtnModificacion();
		}
	}
	
	/**
	 * 
	 */
	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_VALORES_PARTICULAS);
	}
	
	/**
	 * 
	 */
	private void eventBtnBaja() {
		showFrame(Constants.CMD_BAJA_VALORES_PARTICULAS);
	}
	
	/**
	 * 
	 */
	private void eventBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_VALORES_PARTICULAS);
	}
}