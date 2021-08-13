package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.sapiens.app.ui.glosarios.DlgGlosarioCampos;
import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.utils.Constants;

/**
 * @author federico
 *
 */
public class DlgGlosarioCamposListener extends ListenerSupport implements ActionListener {

	private DlgGlosarioCampos dlgGlosarioCampos;

	public DlgGlosarioCamposListener(DlgGlosarioCampos dlgGlosarioCampos) {
		super();
		this.dlgGlosarioCampos = dlgGlosarioCampos;
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
		JDialog dialog = UIHelper.createDialog(dlgGlosarioCampos.getFrameParent(),
				Constants.CMD_ALTA_GLOSARIO_CAMPOS);
		UIHelper.showDialog(dialog);
	}
	
	/**
	 * 
	 */
	private void eventBtnBaja() {
		JDialog dialog = UIHelper.createDialog(dlgGlosarioCampos.getFrameParent(),
				Constants.CMD_BAJA_GLOSARIO_CAMPOS);
		UIHelper.showDialog(dialog);
	}
	
	/**
	 * 
	 */
	private void eventBtnModificacion() {
		JDialog dialog = UIHelper.createDialog(dlgGlosarioCampos.getFrameParent(),
				Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS);
		UIHelper.showDialog(dialog);
	}
	
	/**
	 * 
	 */
	private void eventBtnImprimir() {
		// TODO Auto-generated method stub
		
	}
}
