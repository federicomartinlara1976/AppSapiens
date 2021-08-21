package com.mdval.ui.utils.dialog;

import java.util.Map;

import javax.swing.JFrame;

import com.mdval.ui.DlgIdentificador;
import com.mdval.ui.glosarios.DlgAltaModificacionGlosarios;
import com.mdval.ui.glosarios.DlgBajaGlosarioCampos;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la ventana padre y la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class DialogCreator extends Creator {
	
	private String option;
	
	private JFrame frameParent;
	
	private Boolean modal;
	
	public DialogCreator(JFrame frameParent, String option) {
		this.modal = Boolean.TRUE;
		this.option = option;
		this.frameParent = frameParent;
	}
	
	/**
	 *
	 */
	@Override
	public Object factoryMethod() {
		return null;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		DialogSupport dialog = null;
	
		if (Constants.CMD_INICIAR_APP.equals(option)) {
			dialog = new DlgIdentificador(frameParent, modal);
		}
		
		if (Constants.CMD_BAJA_GLOSARIO_CAMPOS.equals(option)) {
			dialog = new DlgBajaGlosarioCampos(frameParent, modal, params);
		}
		
		if (Constants.CMD_ALTA_GLOSARIOS.equals(option)) {
			dialog = new DlgAltaModificacionGlosarios(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIOS.equals(option)) {
			dialog = new DlgAltaModificacionGlosarios(frameParent, modal, params);
		}
		
		return dialog;
	}
}
