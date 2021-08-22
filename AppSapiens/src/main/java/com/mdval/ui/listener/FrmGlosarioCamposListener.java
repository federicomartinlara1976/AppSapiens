package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import com.mdval.ui.glosarios.FrmGlosarioCampos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmGlosarioCamposListener extends ListenerSupport implements ActionListener {

	private FrmGlosarioCampos frmGlosarioCampos;

	public FrmGlosarioCamposListener(FrmGlosarioCampos frmGlosarioCampos) {
		super();
		this.frmGlosarioCampos = frmGlosarioCampos;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_GLOSARIO_CAMPOS_BTN_BUSCAR_GLOSARIO.equals(jButton.getName())) {
			eventBtnBuscarGlosario();
		}

		if (Constants.DLG_GLOSARIO_CAMPOS_BTN_BUSCAR.equals(jButton.getName())) {
			eventBtnBuscar();
		}
		
		if (Constants.DLG_GLOSARIO_CAMPOS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}
		
		if (Constants.DLG_GLOSARIO_CAMPOS_BTN_BAJA.equals(jButton.getName())) {
			eventBtnBaja();
		}
		
		if (Constants.DLG_GLOSARIO_CAMPOS_BTN_MODIFICACION.equals(jButton.getName())) {
			eventBtnModificacion();
		}
		
		if (Constants.DLG_GLOSARIO_CAMPOS_BTN_IMPRIMIR.equals(jButton.getName())) {
			eventBtnImprimir();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscarGlosario() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 */
	private void eventBtnBuscar() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmGlosarioCampos, Constants.CMD_ALTA_GLOSARIO_CAMPOS);
	}
	
	/**
	 * 
	 */
	private void eventBtnBaja() {
		showPopup(frmGlosarioCampos, Constants.CMD_BAJA_GLOSARIO_CAMPOS);
	}
	
	/**
	 * 
	 */
	private void eventBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.DLG_GLOSARIO_CAMPOS_CAMPO_SELECCIONADO, frmGlosarioCampos.getCampoSeleccionado());
		
		showPopup(frmGlosarioCampos, Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS, params);
	}
	
	/**
	 * 
	 */
	private void eventBtnImprimir() {
		// TODO Auto-generated method stub
		
	}
}
