package com.mdval.ui.utils.creators;

import java.util.Map;

import com.mdval.ui.consultas.FrmComprobacionNombreElemento;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.glosarios.FrmGlosarioCampos;
import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.modelos.FrmMantenimientoModelos;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementos;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementosNorma;
import com.mdval.ui.normasnomenclatura.FrmDefinicionNormas;
import com.mdval.ui.normasnomenclatura.FrmDefinicionParticulasNormaElemento;
import com.mdval.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.mdval.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.mdval.ui.normasnomenclatura.FrmValoresParticulas;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.utils.MDValConstants;

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
	
	private FrameSupport parent;
	
	public FrameCreator(String option) {
		this.option = option;
	}
	
	public FrameCreator(FrameSupport parent, String option) {
		this.parent = parent;
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
		
		if (MDValConstants.MNU_DEF_GLOSARIOS.equals(option)) {
			frame = new FrmDefinicionGlosarios();
		}
		
		if (MDValConstants.MNU_DATOS_GLOSARIO_CAMPOS.equals(option)) {
			frame = new FrmGlosarioCampos();
		}
		
		if (MDValConstants.MNU_DEF_NORMAS.equals(option)) {
			frame = new FrmDefinicionNormas();
		}
		
		if (MDValConstants.MNU_DEF_ELEMENTOS.equals(option)) {
			frame = new FrmDefinicionElementos();
		}
		
		if (MDValConstants.MNU_DEF_ELEMENTOS_NORMA.equals(option)) {
			frame = new FrmDefinicionElementosNorma();
		}
		
		if (MDValConstants.MNU_DEF_TIPOS_PARTICULAS.equals(option)) {
			frame = new FrmDefinicionTiposParticula();
		}
		
		if (MDValConstants.MNU_DEF_PARTICULAS_NORMA_ELEMENTO.equals(option)) {
			frame = new FrmDefinicionParticulasNormaElemento();
		}
		
		if (MDValConstants.MNU_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmValoresParticulas();
		}
		
		if (MDValConstants.MNU_COMPROBAR_NOMBRE_ELEMENTO.equals(option)) {
			frame = new FrmComprobacionNombreElemento();
		}
		
		if (MDValConstants.MNU_MODELOS.equals(option)) {
			frame = new FrmDefinicionModelos();
		}
		
		if (MDValConstants.CMD_ALTA_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas(parent);
		}
		
		if (MDValConstants.CMD_BAJA_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas();
		}
		
		if (MDValConstants.CMD_MODIFICACION_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas(parent, params);
		}
		
		if (MDValConstants.CMD_ALTA_MODELOS.equals(option)) {
			frame = new FrmMantenimientoModelos(parent);
		}
		
		if (MDValConstants.CMD_MODIFICACION_MODELOS.equals(option)) {
			frame = new FrmMantenimientoModelos(parent, params);
		}
		
		if (MDValConstants.CMD_BUSCAR_MODELOS.equals(option)) {
			frame = new FrmDefinicionModelos(parent, params);
		}
		
		return frame;
	}
}
