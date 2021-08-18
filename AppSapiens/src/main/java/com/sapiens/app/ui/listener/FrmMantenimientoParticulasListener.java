package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.sapiens.app.ui.normasnomenclatura.FrmValoresParticulas;
import com.sapiens.app.ui.utils.ListenerSupport;
import com.sapiens.app.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmMantenimientoParticulasListener extends ListenerSupport implements ActionListener {

	private FrmMantenimientoParticulas frmMantenimientoParticulas;

	public FrmMantenimientoParticulasListener(FrmMantenimientoParticulas frmMantenimientoParticulas) {
		super();
		this.frmMantenimientoParticulas = frmMantenimientoParticulas;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_MANTENIMIENTO_PARTICULAS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}
		
		if (Constants.DLG_MANTENIMIENTO_PARTICULAS_BTN_BAJA.equals(jButton.getName())) {
			eventBtnBaja();
		}
		
		if (Constants.DLG_MANTENIMIENTO_PARTICULAS_BTN_MODIFICACION.equals(jButton.getName())) {
			eventBtnModificacion();
		}
	}
	
	/**
	 * 
	 */
	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_MANTENIMIENTO_PARTICULAS);
	}
	
	/**
	 * 
	 */
	private void eventBtnBaja() {
	}
	
	/**
	 * 
	 */
	private void eventBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS);
	}
}
