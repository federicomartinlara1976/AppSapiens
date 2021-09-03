package com.mdval.ui.utils.creators;

import java.util.Map;

import com.mdval.ui.consultas.FrmComprobacionNombreElemento;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.glosarios.FrmGlosarioCampos;
import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementos;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementosNorma;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementosNormaElemento;
import com.mdval.ui.normasnomenclatura.FrmDefinicionNormas;
import com.mdval.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.mdval.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.mdval.ui.normasnomenclatura.FrmValoresParticulas;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class FrameCreator extends Creator {
	
	private String option;
	
	public FrameCreator(String option) {
		this.option = option;
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
		FrameSupport frame = null;
		
		if (Constants.MNU_DEF_GLOSARIOS.equals(option)) {
			frame = new FrmDefinicionGlosarios();
		}
		
		if (Constants.MNU_DATOS_GLOSARIO_CAMPOS.equals(option)) {
			frame = new FrmGlosarioCampos();
		}
		
		if (Constants.MNU_DEF_NORMAS.equals(option)) {
			frame = new FrmDefinicionNormas();
		}
		
		if (Constants.MNU_DEF_ELEMENTOS.equals(option)) {
			frame = new FrmDefinicionElementos();
		}
		
		if (Constants.MNU_DEF_ELEMENTOS_NORMA.equals(option)) {
			frame = new FrmDefinicionElementosNorma();
		}
		
		if (Constants.MNU_DEF_TIPOS_PARTICULAS.equals(option)) {
			frame = new FrmDefinicionTiposParticula();
		}
		
		if (Constants.MNU_DEF_PARTICULAS_NORMA_ELEMENTO.equals(option)) {
			frame = new FrmDefinicionElementosNormaElemento();
		}
		
		if (Constants.MNU_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmValoresParticulas();
		}
		
		if (Constants.MNU_COMPROBAR_NOMBRE_ELEMENTO.equals(option)) {
			frame = new FrmComprobacionNombreElemento();
		}
		
		if (Constants.MNU_MODELOS.equals(option)) {
			frame = new FrmDefinicionModelos();
		}
		
		if (Constants.CMD_ALTA_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas();
		}
		
		if (Constants.CMD_BAJA_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas();
		}
		
		if (Constants.CMD_MODIFICACION_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas();
		}
		
		return frame;
	}
}
