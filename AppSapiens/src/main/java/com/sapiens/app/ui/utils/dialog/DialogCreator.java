package com.sapiens.app.ui.utils.dialog;

import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.sapiens.app.ui.glosarios.DlgAltaModificacionCampos;
import com.sapiens.app.ui.glosarios.DlgAltaModificacionGlosarios;
import com.sapiens.app.ui.glosarios.DlgBajaGlosario;
import com.sapiens.app.ui.glosarios.DlgDefinicionGlosarios;
import com.sapiens.app.ui.glosarios.DlgGlosarioCampos;
import com.sapiens.app.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la ventana padre y la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class DialogCreator extends Creator {
	
	private String menuOption;
	
	private JFrame frameParent;
	
	private Boolean modal;
	
	public DialogCreator(JFrame frameParent, String menuOption) {
		this.modal = Boolean.TRUE;
		this.menuOption = menuOption;
		this.frameParent = frameParent;
	}

	/**
	 *
	 */
	@Override
	public JDialog factoryMethod(Map<String, Object> params) {
		JDialog dialog = null;
		
		if (Constants.MNU_DEF_GLOSARIOS.equals(menuOption)) {
			dialog = new DlgDefinicionGlosarios(frameParent, modal);
		}
		
		if (Constants.MNU_DATOS_GLOSARIO_CAMPOS.equals(menuOption)) {
			dialog = new DlgGlosarioCampos(frameParent, modal);
		}
		
		if (Constants.CMD_ALTA_GLOSARIOS.equals(menuOption)) {
			dialog = new DlgAltaModificacionGlosarios(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIOS.equals(menuOption)) {
			dialog = new DlgAltaModificacionGlosarios(frameParent, modal, params);
		}
		
		if (Constants.CMD_BAJA_GLOSARIO_CAMPOS.equals(menuOption)) {
			dialog = new DlgBajaGlosario(frameParent, modal, params);
		}
		
		if (Constants.CMD_ALTA_GLOSARIO_CAMPOS.equals(menuOption)) {
			dialog = new DlgAltaModificacionCampos(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS.equals(menuOption)) {
			dialog = new DlgAltaModificacionCampos(frameParent, modal, params);
		}
		
		return dialog;
	}

}
