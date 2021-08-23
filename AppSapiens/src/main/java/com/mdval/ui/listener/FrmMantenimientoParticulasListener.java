package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdval.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

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

		if (Constants.DLG_MANTENIMIENTO_PARTICULAS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}
		
		if (Constants.DLG_MANTENIMIENTO_PARTICULAS_BTN_BAJA.equals(jButton.getActionCommand())) {
			eventBtnBaja();
		}
		
		if (Constants.DLG_MANTENIMIENTO_PARTICULAS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			eventBtnModificacion();
		}
	}
	
	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmMantenimientoParticulas, Constants.CMD_ALTA_MANTENIMIENTO_PARTICULAS);
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
		showPopup(frmMantenimientoParticulas, Constants.CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS);
	}
}
