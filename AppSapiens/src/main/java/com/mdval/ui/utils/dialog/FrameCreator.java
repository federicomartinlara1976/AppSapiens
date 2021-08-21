package com.mdval.ui.utils.dialog;

import java.util.Map;

import com.mdval.ui.consultas.FrmComprobacionNombreElemento;
import com.mdval.ui.glosarios.FrmAltaModificacionCampos;
import com.mdval.ui.glosarios.FrmAltaModificacionGlosarios;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.glosarios.FrmGlosarioCampos;
import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.modelos.FrmMantenimientoModelos;
import com.mdval.ui.normasnomenclatura.FrmAltaModificacionElementos;
import com.mdval.ui.normasnomenclatura.FrmAltaModificacionTiposParticula;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementos;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementosNorma;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementosNormaElemento;
import com.mdval.ui.normasnomenclatura.FrmDefinicionNormas;
import com.mdval.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.mdval.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.mdval.ui.normasnomenclatura.FrmMantenimientoValoresParticulas;
import com.mdval.ui.normasnomenclatura.FrmModificacionNormas;
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
		
		if (Constants.CMD_ALTA_GLOSARIOS.equals(option)) {
			frame = new FrmAltaModificacionGlosarios();
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIOS.equals(option)) {
			frame = new FrmAltaModificacionGlosarios(params);
		}
		
		if (Constants.CMD_ALTA_GLOSARIO_CAMPOS.equals(option)) {
			frame = new FrmAltaModificacionCampos();
		}
		
		if (Constants.CMD_MODIFICACION_GLOSARIO_CAMPOS.equals(option)) {
			frame = new FrmAltaModificacionCampos(params);
		}
		
		if (Constants.CMD_ALTA_NORMAS.equals(option)) {
			frame = new FrmModificacionNormas();
		}
		
		if (Constants.CMD_MODIFICACION_NORMAS.equals(option)) {
			frame = new FrmModificacionNormas(params);
		}
		
		if (Constants.CMD_ALTA_ELEMENTOS.equals(option)) {
			frame = new FrmAltaModificacionElementos();
		}
		
		if (Constants.CMD_MODIFICACION_ELEMENTOS.equals(option)) {
			frame = new FrmAltaModificacionElementos(params);
		}
		
		if (Constants.CMD_ALTA_TIPOS_PARTICULA.equals(option)) {
			frame = new FrmAltaModificacionTiposParticula();
		}
		
		if (Constants.CMD_MODIFICACION_TIPOS_PARTICULA.equals(option)) {
			frame = new FrmAltaModificacionTiposParticula(params);
		}
		
		if (Constants.CMD_ALTA_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas(params);
		}
		
		if (Constants.CMD_BAJA_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas(params);
		}
		
		if (Constants.CMD_MODIFICACION_VALORES_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoParticulas(params);
		}
		
		if (Constants.CMD_ALTA_MANTENIMIENTO_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoValoresParticulas(params);
		}
		
		if (Constants.CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS.equals(option)) {
			frame = new FrmMantenimientoValoresParticulas(params);
		}
		
		if (Constants.CMD_ALTA_MODELOS.equals(option)) {
			frame = new FrmMantenimientoModelos();
		}
		
		if (Constants.CMD_MODIFICACION_MODELOS.equals(option)) {
			frame = new FrmMantenimientoModelos();
		}
		
		return frame;
	}
}
