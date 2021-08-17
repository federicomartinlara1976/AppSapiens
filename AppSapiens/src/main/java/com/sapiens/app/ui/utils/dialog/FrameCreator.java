package com.sapiens.app.ui.utils.dialog;

import java.util.Map;

import com.sapiens.app.ui.glosarios.FrmAltaModificacionCampos;
import com.sapiens.app.ui.glosarios.FrmAltaModificacionGlosarios;
import com.sapiens.app.ui.glosarios.FrmDefinicionGlosarios;
import com.sapiens.app.ui.glosarios.FrmGlosarioCampos;
import com.sapiens.app.ui.utils.FrameSupport;
import com.sapiens.app.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la ventana padre y la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class FrameCreator extends Creator {
	
	private String menuOption;
	
	public FrameCreator(String menuOption) {
		this.menuOption = menuOption;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		FrameSupport frame = null;
		
		if (Constants.MNU_DEF_GLOSARIOS.equals(menuOption)) {
			frame = new FrmDefinicionGlosarios();
		}
		
		if (Constants.MNU_DATOS_GLOSARIO_CAMPOS.equals(menuOption)) {
			frame = new FrmGlosarioCampos();
		}
		
		if (Constants.CMD_ALTA_GLOSARIOS.equals(menuOption)) {
			frame = new FrmAltaModificacionGlosarios();
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIOS.equals(menuOption)) {
			frame = new FrmAltaModificacionGlosarios(params);
		}
		
		if (Constants.CMD_ALTA_GLOSARIO_CAMPOS.equals(menuOption)) {
			frame = new FrmAltaModificacionCampos();
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS.equals(menuOption)) {
			frame = new FrmAltaModificacionCampos(params);
		}
		
		return frame;
	}

}
