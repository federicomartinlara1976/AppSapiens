package com.mdval.ui.utils.dialog;

import java.util.Map;

import javax.swing.JFrame;

import com.mdval.ui.DlgIdentificador;
import com.mdval.ui.glosarios.DlgAltaModificacionCampos;
import com.mdval.ui.glosarios.DlgAltaModificacionGlosarios;
import com.mdval.ui.glosarios.DlgBajaGlosarioCampos;
import com.mdval.ui.normasnomenclatura.DlgAltaModificacionElementos;
import com.mdval.ui.normasnomenclatura.DlgAltaModificacionTiposParticula;
import com.mdval.ui.normasnomenclatura.DlgMantenimientoValoresParticulas;
import com.mdval.ui.normasnomenclatura.DlgModificacionNormas;
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
		
		if (Constants.CMD_ALTA_GLOSARIO_CAMPOS.equals(option)) {
			dialog = new DlgAltaModificacionCampos(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS.equals(option)) {
			dialog = new DlgAltaModificacionCampos(frameParent, modal, params);
		}
		
		if (Constants.CMD_ALTA_NORMAS.equals(option)) {
			dialog = new DlgModificacionNormas(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_NORMAS.equals(option)) {
			dialog = new DlgModificacionNormas(frameParent, modal, params);
		}
		
		if (Constants.CMD_ALTA_ELEMENTOS.equals(option)) {
			dialog = new DlgAltaModificacionElementos(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_ELEMENTOS.equals(option)) {
			dialog = new DlgAltaModificacionElementos(frameParent, modal, params);
		}
		
		if (Constants.CMD_ALTA_TIPOS_PARTICULA.equals(option)) {
			dialog = new DlgAltaModificacionTiposParticula(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_TIPOS_PARTICULA.equals(option)) {
			dialog = new DlgAltaModificacionTiposParticula(frameParent, modal, params);
		}
		
		if (Constants.CMD_ALTA_MANTENIMIENTO_PARTICULAS.equals(option)) {
			dialog = new DlgMantenimientoValoresParticulas(frameParent, modal);
		}
		
		if (Constants.CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS.equals(option)) {
			dialog = new DlgMantenimientoValoresParticulas(frameParent, modal, params);
		}
		
		return dialog;
	}
}
