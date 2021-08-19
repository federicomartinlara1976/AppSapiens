package com.sapiens.mdval.ui.utils.dialog;

import java.util.Map;

import com.sapiens.mdval.ui.consultas.FrmComprobacionNombreElemento;
import com.sapiens.mdval.ui.glosarios.FrmAltaModificacionCampos;
import com.sapiens.mdval.ui.glosarios.FrmAltaModificacionGlosarios;
import com.sapiens.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.sapiens.mdval.ui.glosarios.FrmGlosarioCampos;
import com.sapiens.mdval.ui.modelos.FrmDefinicionModelos;
import com.sapiens.mdval.ui.modelos.FrmMantenimientoModelos;
import com.sapiens.mdval.ui.normasnomenclatura.FrmAltaModificacionElementos;
import com.sapiens.mdval.ui.normasnomenclatura.FrmAltaModificacionTiposParticula;
import com.sapiens.mdval.ui.normasnomenclatura.FrmDefinicionElementos;
import com.sapiens.mdval.ui.normasnomenclatura.FrmDefinicionElementosNorma;
import com.sapiens.mdval.ui.normasnomenclatura.FrmDefinicionElementosNormaElemento;
import com.sapiens.mdval.ui.normasnomenclatura.FrmDefinicionNormas;
import com.sapiens.mdval.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.sapiens.mdval.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.sapiens.mdval.ui.normasnomenclatura.FrmMantenimientoValoresParticulas;
import com.sapiens.mdval.ui.normasnomenclatura.FrmModificacionNormas;
import com.sapiens.mdval.ui.normasnomenclatura.FrmValoresParticulas;
import com.sapiens.mdval.ui.utils.FrameSupport;
import com.sapiens.mdval.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la cadena de la
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
		
		if (Constants.MNU_DEF_NORMAS.equals(menuOption)) {
			frame = new FrmDefinicionNormas();
		}
		
		if (Constants.MNU_DEF_ELEMENTOS.equals(menuOption)) {
			frame = new FrmDefinicionElementos();
		}
		
		if (Constants.MNU_DEF_ELEMENTOS_NORMA.equals(menuOption)) {
			frame = new FrmDefinicionElementosNorma();
		}
		
		if (Constants.MNU_DEF_TIPOS_PARTICULAS.equals(menuOption)) {
			frame = new FrmDefinicionTiposParticula();
		}
		
		if (Constants.MNU_DEF_PARTICULAS_NORMA_ELEMENTO.equals(menuOption)) {
			frame = new FrmDefinicionElementosNormaElemento();
		}
		
		if (Constants.MNU_VALORES_PARTICULAS.equals(menuOption)) {
			frame = new FrmValoresParticulas();
		}
		
		if (Constants.MNU_COMPROBAR_NOMBRE_ELEMENTO.equals(menuOption)) {
			frame = new FrmComprobacionNombreElemento();
		}
		
		if (Constants.MNU_MODELOS.equals(menuOption)) {
			frame = new FrmDefinicionModelos();
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
		
		if (Constants.CMD_ALTA_NORMAS.equals(menuOption)) {
			frame = new FrmModificacionNormas();
		}
		
		if (Constants.CMD_MODIFICACION_NORMAS.equals(menuOption)) {
			frame = new FrmModificacionNormas(params);
		}
		
		if (Constants.CMD_ALTA_ELEMENTOS.equals(menuOption)) {
			frame = new FrmAltaModificacionElementos();
		}
		
		if (Constants.CMD_MODIFICACION_ELEMENTOS.equals(menuOption)) {
			frame = new FrmAltaModificacionElementos(params);
		}
		
		if (Constants.CMD_ALTA_TIPOS_PARTICULA.equals(menuOption)) {
			frame = new FrmAltaModificacionTiposParticula();
		}
		
		if (Constants.CMD_MODIFICACION_TIPOS_PARTICULA.equals(menuOption)) {
			frame = new FrmAltaModificacionTiposParticula(params);
		}
		
		if (Constants.CMD_ALTA_VALORES_PARTICULAS.equals(menuOption)) {
			frame = new FrmMantenimientoParticulas(params);
		}
		
		if (Constants.CMD_BAJA_VALORES_PARTICULAS.equals(menuOption)) {
			frame = new FrmMantenimientoParticulas(params);
		}
		
		if (Constants.CMD_MODIFICACION_VALORES_PARTICULAS.equals(menuOption)) {
			frame = new FrmMantenimientoParticulas(params);
		}
		
		if (Constants.CMD_ALTA_MANTENIMIENTO_PARTICULAS.equals(menuOption)) {
			frame = new FrmMantenimientoValoresParticulas(params);
		}
		
		if (Constants.CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS.equals(menuOption)) {
			frame = new FrmMantenimientoValoresParticulas(params);
		}
		
		if (Constants.CMD_ALTA_MODELOS.equals(menuOption)) {
			frame = new FrmMantenimientoModelos();
		}
		
		if (Constants.CMD_MODIFICACION_MODELOS.equals(menuOption)) {
			frame = new FrmMantenimientoModelos();
		}
		
		return frame;
	}

}
